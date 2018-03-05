package xyz.mynt.internal.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import xyz.mynt.internal.ApplicationConstants;
import xyz.mynt.internal.service.BarcodeService;
import xyz.mynt.internal.service.LoggerService;
import xyz.mynt.internal.type.InitializeProcessRequest;
import xyz.mynt.internal.type.NotifyBarcodeRequest;
import xyz.mynt.internal.type.NotifyBarcodeResponse;
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
	
	/*@GetMapping 
    public String homepage() {
        return "home";
    }*/
    
	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("home", "initializeProcessRequest", new InitializeProcessRequest());
    }
	
    @PostMapping(value="/process-barcode")
    public String processBarcode(@Valid @ModelAttribute("initializeProcessRequest") InitializeProcessRequest initializeProcessRequest, ModelMap model) {
    	LOGGER.info("CAROL request " + initializeProcessRequest.toString());
    	ProcessBarcodeRequest processBarcodeRequest = new ProcessBarcodeRequest();
    	processBarcodeRequest.setServiceType(initializeProcessRequest.getServiceType());
    	//processBarcodeRequest.setBarcodeString(request.getBarcodeString());
    	//processBarcodeRequest.setTimeout(request.getTimeout());
    	
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
    
    @RequestMapping(value = "/notify-barcode", method = RequestMethod.POST)
    public @ResponseBody NotifyBarcodeResponse notifyBarcode(@Valid @RequestBody NotifyBarcodeRequest notifyBarcodeRequest) {
    	LOGGER.info("CAROL notifyBarcode request " + notifyBarcodeRequest.toString());
    	NotifyBarcodeResponse response = barcodeService.notifyBarcode(notifyBarcodeRequest);
    	return response;
    }
    
    
}
