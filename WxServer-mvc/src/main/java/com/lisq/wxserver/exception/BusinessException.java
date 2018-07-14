package com.lisq.wxserver.exception;

public class BusinessException extends Exception{
	
	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Exception e) {
		super(message, e);
	}

}
