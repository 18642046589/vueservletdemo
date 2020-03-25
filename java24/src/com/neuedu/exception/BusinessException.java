package com.neuedu.exception;

public class BusinessException extends Exception {
private int code;
public BusinessException(String message, int code) {
	super(message);
	this.code = code;
}

public int getCode() {
	return code;
}

}
