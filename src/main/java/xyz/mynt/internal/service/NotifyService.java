package xyz.mynt.internal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xyz.mynt.internal.type.ProcessBarcodeResponse;

public class NotifyService implements NotifyServiceInterface {

	private static final Logger LOGGER = LoggerFactory.getLogger(NotifyService.class);
	
	@Override
	public ProcessBarcodeResponse notifyBarcode() throws Exception {

		LOGGER.debug("CAROL CALL NOTIFY NotifyService");
		ProcessBarcodeResponse response = null;
		return response; 
	}
	

}
