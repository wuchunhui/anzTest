package com.anz.bean;
/**
 * definition the return message,all the rest api return this structured
 * @author jesse
 * @since 1.0
 *
 */
public class ReturnMsg {
	/**
	 * fail code
	 */
	public final static int ERROR_CODE = 500;
	/**
	 * success code
	 */
	public final static int SUCCESS_CODE = 200;

	/**
	 * return code 
	 */
	private int code = 200;
	/**
	 * return message
	 */
	private String message;
	/**
	 * return data
	 */
	private Object data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
