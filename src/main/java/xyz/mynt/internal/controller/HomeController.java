package xyz.mynt.internal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.mynt.internal.ApplicationConstants;
import xyz.mynt.internal.service.BarcodeService;
import xyz.mynt.internal.service.LoggerService;
import xyz.mynt.internal.type.ProcessBarcodeRequest;
import xyz.mynt.internal.type.ProcessBarcodeResponse;
import xyz.mynt.internal.util.SimulatorUtil;

@Controller
public class HomeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    
	@Autowired
	private BarcodeService barcodeService;
	
	@Autowired
	private LoggerService loggerService;
	
	@GetMapping 
    public String homepage() {
        return "home";
    }
    
    @GetMapping(value="/process-barcode")
    public String processBarcode(ModelMap model, @RequestParam int timeout, @RequestParam String serviceType, @RequestParam String barcodeString) {    	
    	ProcessBarcodeRequest processBarcodeRequest = new ProcessBarcodeRequest();
    	processBarcodeRequest.setServiceType(serviceType);
    	processBarcodeRequest.setBarcodeString(barcodeString);
    	processBarcodeRequest.setTimeout(timeout);
    	
    	String transId = SimulatorUtil.getTransactionID();
    	loggerService.logTransaction(transId, ApplicationConstants.TXN_NEW, processBarcodeRequest.toString(), ApplicationConstants.CHANNEL_INTERNAL);
		
    	try {
    		loggerService.logTransaction(transId, ApplicationConstants.TXN_PROCESSING, processBarcodeRequest, ApplicationConstants.CHANNEL_OUTBOUND);
    		ProcessBarcodeResponse response = barcodeService.processBarcode(processBarcodeRequest);
        	loggerService.logTransaction(transId, ApplicationConstants.TXN_SUCCESSFUL, response, ApplicationConstants.CHANNEL_INBOUND);
		} catch (Exception e) {
			LOGGER.info("Exception occurred " + e.getMessage());
			model.put("error", "Sorry, the transaction encountered the ff error: " + e.toString());
			loggerService.logTransaction(transId, ApplicationConstants.TXN_FAILED, processBarcodeRequest.toString(), ApplicationConstants.CHANNEL_INBOUND);
			loggerService.probeTransaction(transId, ApplicationConstants.TXN_TIMEOUT, ApplicationConstants.CHANNEL_INTERNAL, processBarcodeRequest);
		}
    	
        model.put("request", "Request: " + processBarcodeRequest);
        return "home";
    }
  
    
}
