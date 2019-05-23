package com.csl.demo.springmybaits.common;

import java.io.Serializable;

public class ResultResponse<T> implements Serializable{
	private static final long serialVersionUID = 4639677666628071866L;
	private String msg;
	private int errorCode;
	private T data;
	public ResultResponse(String msg) {
		super();
		this.msg = msg;
	}
	public ResultResponse(String msg, int errorCode) {
		super();
		this.msg = msg;
		this.errorCode = errorCode;
	}
	public ResultResponse(String msg, int errorCode, T data) {
		super();
		this.msg = msg;
		this.errorCode = errorCode;
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
