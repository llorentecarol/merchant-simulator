package xyz.mynt.internal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.mynt.internal.service.BarcodeService;
import xyz.mynt.internal.type.ProcessBarcodeRequest;

@Controller
public class HomeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    
	@Autowired
	private BarcodeService barcodeService;
	
	@GetMapping 
    public String homepage() {
        return "home";
    }
    
    @GetMapping(value="/process-barcode")
    public String processBarcode(ModelMap model, @RequestParam String serviceType, @RequestParam String barcodeString) {
    	LOGGER.info("CAROL processBarcode " + serviceType);
    	LOGGER.info("RECEIVED barcodeString: " + barcodeString);
    	
    	ProcessBarcodeRequest processBarcodeRequest = new ProcessBarcodeRequest();
    	processBarcodeRequest.setServiceType(serviceType);
    	processBarcodeRequest.setBarcodeString(barcodeString);
    	try {
        	barcodeService.processBarcode(processBarcodeRequest);
		} catch (Exception e) {
			LOGGER.info("Exception occurred " + e.getMessage());
			model.put("error", e.toString());
		}
    	
        model.put("barcode", processBarcodeRequest);
        model.put("barcodeString", barcodeString);
        return "home";
    }
  
    
}
