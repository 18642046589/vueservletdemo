package com.neuedu.exception;
/**
 * 自定义异常，应用程序异常
 * @author t460p
 *
 */
public class AppException extends Exception {
	// Exception自带错误描述msg
	// 我们可以在自定义异常里扩展一些属性，最常见的是扩展是扩展一个编码 -1 999
	private int code;
	// 有参构造

	public AppException(String message, int code) {
		super(message);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

}
