package xyz.mynt.internal.type;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class InitializeProcessRequest {

	 private int timeout;
	 private String serviceType;
	 private String barcodeString;
	 private String merchantId;
	 private String barcode;
	 private String merchantTransId;
	 private String merchantWallet;
	 private String merchantPin;
	 private BigDecimal amount;
	 private String transactionDetails;
	 private Data data;
}
