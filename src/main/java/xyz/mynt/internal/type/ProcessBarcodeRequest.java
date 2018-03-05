package xyz.mynt.internal.type;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ProcessBarcodeRequest {

	/*
	 * example: | { "merchantId": "10289", "serviceType": "01", "barcode":
	 * "1234567890123456", "merchantTransId": "1023245", "merchantWallet":
	 * "merchant_wallet", "merchantPin": "fb563d2cf1aa1f3033f7ac5221e28aa4e0483942",
	 * "amount": 100.00, "transactionDetails": "Payment of 100.00", "data": { } }
	 */

	private String merchantId;
	private String serviceType;
	private String barcode;
	private String merchantTransId;
	private String merchantWallet;
	private String merchantPin;
	private BigDecimal amount;
	private String transactionDetails;
	private Data data;

}
