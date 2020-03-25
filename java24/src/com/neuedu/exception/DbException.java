package com.neuedu.exception;

public class DbException extends Exception {
	//-1 系统错误  999连接异常
	private int code;

	public DbException(String message, int code) {
		super(message);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

}
