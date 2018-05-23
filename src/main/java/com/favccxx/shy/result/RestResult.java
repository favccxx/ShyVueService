package com.favccxx.shy.result;

import com.favccxx.shy.constants.ShyConstants;

public class RestResult<T> {

	/**
	 * 状态码 200 ： 调用成功 400： 调用失败
	 */
	int statusCode;

	/**
	 * 结果码 4001 ： 缺少必要的参数 4002： 参数格式不正确
	 * 
	 * 2000：查询并返回结果集 2001： 结果集为空
	 * 
	 */
	int resultCode;
	
	String message = ShyConstants.DEFAULT_SUCCESS_MSG;

	T data;
	
	
	public static <T> RestResult<T> success(T data) {
		RestResult<T> result = new RestResult<T>();
		
		result.setStatusCode(ShyConstants.STATUS_SUCCESS);
		result.setResultCode(ShyConstants.CODE_SUCCESS);
		result.setData(data);
		result.setMessage(ShyConstants.DEFAULT_SUCCESS_MSG);
		
		return result;
	}
	
	
	
	
	public static <T> RestResult<T> success(T data, String message) {
		RestResult<T> result = new RestResult<T>();		
		result.setStatusCode(ShyConstants.STATUS_SUCCESS);
		result.setResultCode(ShyConstants.CODE_SUCCESS);
		result.setData(data);
		result.setMessage(message);
		
		return result;
	}
	

	public static RestResult<?> invlidParam(String message) {
		RestResult<String> result = new RestResult<String>();
		result.setStatusCode(ShyConstants.STATUS_SUCCESS);
		result.setResultCode(ShyConstants.CODE_LACK_PARAMS);
		result.setMessage(message);
		return result;
	}
	
	public void setInvalidParams(String errorMessage) {
		this.statusCode = ShyConstants.STATUS_SUCCESS;
		this.resultCode = ShyConstants.CODE_INVALID_PARAMS;
		this.message = errorMessage;
	}
	
	

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


}
