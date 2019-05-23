package com.csl.demo.springmybaits.exception;
/**
 * 自定义基础异常
 * @author Cherry
 * @date  2019年5月23日
 */
public abstract class BaseException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/*
	 * 定义异常信息
	 */
	public BaseException(String message){
		super(message);
	}
	/*
	 * 获取异常信息
	 */
	public abstract Object getError();
}
