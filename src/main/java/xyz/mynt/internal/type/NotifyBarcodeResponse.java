package xyz.mynt.internal.type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class NotifyBarcodeResponse {

	private String status;
	private String resultCode;
	private String transId;
	private String merchantId;
	private String serviceType;
	private String barcode;
	private String merchantTransId;
	private String merchantWallet;
	private String merchantPin;
	private String amount;
	private String transactionDetails;
	private String data;

}
