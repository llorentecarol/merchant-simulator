package xyz.mynt.internal.exception;

public class MerchantSimulatorConnectionException extends Exception {
	
	private static final long serialVersionUID = 1L;

	private String code;

	private Object request;

	public MerchantSimulatorConnectionException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MerchantSimulatorConnectionException(String code, String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.code = code;
	}

	public MerchantSimulatorConnectionException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
		// TODO Auto-generated constructor stub
	}

	public MerchantSimulatorConnectionException(String code, Throwable cause) {
		super(cause);
		this.code = code;
		// TODO Auto-generated constructor stub
	}
	
	public MerchantSimulatorConnectionException(String code, String message) {
		super(message);
		this.code = code;
	}

	public MerchantSimulatorConnectionException(String code, String message, Object request) {
		super(message);
		this.code = code;
		this.request = request;
	}

	public String getCode() {
		return code;
	}

	public Object getRequest() {
		return request;
	}
}
