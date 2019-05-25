package com.csl.demo.springmybaits.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.csl.demo.springmybaits.annotation.ShutMethod;
import com.csl.demo.springmybaits.exception.MethodException;

/**
 * 简介
	SpringWebMVC的处理器拦截器，类似于Servlet开发中的过滤器Filter，用于处理器进行预处理和后处理。
     应用场景
	1、日志记录，可以记录请求信息的日志，以便进行信息监控、信息统计等。
	2、权限检查：如登陆检测，进入处理器检测是否登陆，如果没有直接返回到登陆页面。
	3、性能监控：典型的是慢日志。
 * @author Cherry
 * @date  2019年5月17日
 */
public class ControllerInterceptor extends HandlerInterceptorAdapter {
	/*
	 * 可在配置文件配置属性值
	 */
	private String propertyValue;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
		ShutMethod sm = ((HandlerMethod) handler).getMethodAnnotation(ShutMethod.class);
		if(sm != null){
			boolean flag = sm.isShunt();
			if(flag){
				throw new MethodException("方法不可用！");
			}
		}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}
}
