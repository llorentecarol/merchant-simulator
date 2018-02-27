package xyz.mynt.internal.type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ProcessBarcodeResponse {
	@Getter @Setter private String status;
	@Getter @Setter private String code;
	@Getter @Setter private String message;
	@Getter @Setter private String serviceType;
	@Getter @Setter private String barcodeString;
}
