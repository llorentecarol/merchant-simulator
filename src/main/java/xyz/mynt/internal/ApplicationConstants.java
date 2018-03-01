package xyz.mynt.internal;

public class ApplicationConstants {
	
	public static final String TXN_NEW = "NEW";
	public static final String TXN_PROCESSING = "PROCESSING";
	public static final String TXN_TIMEOUT = "TIMEOUT";
	public static final String TXN_REPROCESS = "REPROCESS";
	public static final String TXN_SUCCESSFUL = "SUCCESSFUL";
	public static final String TXN_FAILED = "FAILED";

	public static final String CHANNEL_INTERNAL = "INTERNAL";
	public static final String CHANNEL_INBOUND = "INBOUND";
	public static final String CHANNEL_OUTBOUND = "OUTBOUND";
	

	public static final String PROBE_FORPROBING = "FOR PROBING";
	public static final String PROBE_ONGOING = "ON GOING";
	public static final String PROBE_DONE = "DONE";
	
	public static final String MAX_CARD_REACHED_CODE = "1001";
	public static final String CARD_ALREADY_EXIST_CODE = "1000";
	public static final String SUBSCRIBER_NOT_FOUND_CODE = "1002";
	public static final String CARD_NOT_FOUND_CODE = "1003";
	
	public static final String DUPLICATE_TXN_CODE = "1004";
	
	public static final String NOT_FOUND_CODE = "1005";

	private ApplicationConstants() {
		// TODO Auto-generated constructor stub
	}

}
