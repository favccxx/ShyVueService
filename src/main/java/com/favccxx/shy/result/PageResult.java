package com.favccxx.shy.result;

import org.springframework.data.domain.Page;

import com.favccxx.shy.constants.ShyConstants;

public class PageResult<T> {
	
	int status;
	
	int code;
	
	String message = "";
	
	String devMsg = "";
	
	String moreInfo = "";
	
	Page<T> data;
	
	public static <T> PageResult<T> success(Page<T> pageData) {
		PageResult<T> result = new PageResult<T>();
		
		result.setStatus(ShyConstants.STATUS_SUCCESS);
		result.setCode(ShyConstants.CODE_SUCCESS);
		result.setData(pageData);
		result.setMessage(ShyConstants.DEFAULT_SUCCESS_MSG);
		
		return result;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDevMsg() {
		return devMsg;
	}

	public void setDevMsg(String devMsg) {
		this.devMsg = devMsg;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}

	public Page<T> getData() {
		return data;
	}

	public void setData(Page<T> data) {
		this.data = data;
	}
	
	
	

}
