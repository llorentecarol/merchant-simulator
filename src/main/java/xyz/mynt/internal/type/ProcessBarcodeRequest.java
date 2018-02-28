package xyz.mynt.internal.type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ProcessBarcodeRequest {

	@Getter @Setter private String serviceType;
	@Getter @Setter private String barcodeString;
	@Getter @Setter private int timeout;

}
