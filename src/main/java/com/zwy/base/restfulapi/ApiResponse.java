package com.zwy.base.restfulapi;

/**
 * 类 名: ApiResponse
 * 描 述:
 * 作 者: 张文雅
 * 创 建：2020年10月24日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
public final class ApiResponse<T> {
	private final int code;
	private final String message;
	private final T data;

	private ApiResponse(int code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public static <T> ApiResponse<T> create(int code, String message, T data) {
		return new ApiResponse(code, message, data);
	}

	public int getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}

	public T getData() {
		return this.data;
	}
}
