package com.epm.exception;

public class NotADefaultBrowser extends RuntimeException{
	public NotADefaultBrowser(String message){
		super(message);
	}
}