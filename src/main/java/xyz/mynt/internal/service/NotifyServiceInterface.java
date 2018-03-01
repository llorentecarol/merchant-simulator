package xyz.mynt.internal.service;

import org.springframework.stereotype.Service;

import xyz.mynt.internal.type.ProcessBarcodeResponse;

@Service
public interface NotifyServiceInterface {
	ProcessBarcodeResponse notifyBarcode() throws Exception;
}
