package com.dc.frame2.core.dto;

import java.io.Serializable;

public class AjaxResult implements Serializable{
	private static final long serialVersionUID = -6770538785772264261L;
	private boolean success=true;
	private String message;
	private Object data;
	
	public boolean isSuccess() {
		return success;
	}
	
	public AjaxResult setSuccess(boolean success) {
		this.success = success;
		return this;
	}
	
	public String getMessage() {
		return message;
	}
	
	public AjaxResult setMessage(String message) {
		this.message = message;
		return this;
	}
	
	public Object getData() {
		return data;
	}
	
	public AjaxResult setData(Object data) {
		this.data = data;
		return this;
	}
	
	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "AjaxResult{" +
					   "success=" + success +
					   ", message='" + message + '\'' +
					   ", data=" + data +
					   '}';
	}
}
