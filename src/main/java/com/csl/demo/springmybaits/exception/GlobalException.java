package com.csl.demo.springmybaits.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局异常处理，将处理后的异常呈现到前端
 * ControllerAdvice支持的限定范围：
		按注解： @ControllerAdvice(annotations = RestController.class)
		按包名： @ControllerAdvice("org.example.controllers")
		按类型： @ControllerAdvice(assignableTypes = {ControllerInterface.class, AbstractController.class})
 * @author Cherry
 * @date  2019年5月23日
 */
@RestController
@ControllerAdvice
public class GlobalException {
	/*
	 * 抛出MethodException异常时对其进行处理，返回结果。
	 * 方法不可用 405
	 */
	@ExceptionHandler(MethodException.class)
	@ResponseStatus(value=HttpStatus.METHOD_NOT_ALLOWED)
	public Object handlerMethodException(MethodException me){
		return me.getError();
	}
}
