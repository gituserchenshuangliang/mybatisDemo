package com.csl.demo.springmybaits.exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;

public class MethodException extends BaseException {


	private static final long serialVersionUID = 1L;

	public MethodException(String message) {
		super(message);
	}

	@Override
	public Object getError() {
		HashMap<String, Object> map = new HashMap<String, Object>(10);
		map.put("status",HttpStatus.METHOD_NOT_ALLOWED.value());
		map.put("msg",this.getMessage());
		return map;
	}

}
