package xyz.mynt.internal.type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
public class ProcessBarcodeResponse {

	private String barcode;
	private String merchantId;
	@Getter @Setter private String status;
	@Getter @Setter private String resultCode;
	@Getter @Setter private String resultNamespace;
	@Getter @Setter private String gcashTransId;
	
	/*
	@Getter @Setter private String status;
	@Getter @Setter private String code;
	@Getter @Setter private String message;
	@Getter @Setter private String serviceType;
	@Getter @Setter private String barcodeString;
	*/
	/*
	 * 
      responses:
        200:
          body:
            application/json:
              example: |
                {
                  "barcode": "1234567890123456",
                  "merchantId": "10289",
                  "status": 0,
                  "resultCode": "200",
                  "resultNamespace": "code_server"
                  "gcashTransId": "108971",
                  "message": "Transaction successful",
                  "transactionDetails": "Payment of 100.00",
                  "data": {
                  }
                }
	 */
}
