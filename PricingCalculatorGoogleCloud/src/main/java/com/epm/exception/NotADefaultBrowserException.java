package com.epm.exception;

public class NotADefaultBrowserException extends RuntimeException{
	public NotADefaultBrowserException(String message){
		super("Not a default browser! "+ message + "\nDefault Browsers supported are: "
				+ "\nChromeDriver \nEdgeDriver \nInternetExplorerDriver \nFirefoxDriver \nSafariDriver");
	}
}