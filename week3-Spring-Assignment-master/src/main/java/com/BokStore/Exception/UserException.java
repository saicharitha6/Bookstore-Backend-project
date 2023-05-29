package com.BokStore.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class UserException extends RuntimeException{
	
	private static final long serialversionUID = 1L;
	public UserException(String msg) {
		super(msg);
		System.out.println(msg);
	}
	public UserException(String msg, Throwable t) {
		super(msg,t);
		System.out.println(msg);
	}
}
