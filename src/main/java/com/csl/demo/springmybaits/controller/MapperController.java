package com.csl.demo.springmybaits.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csl.demo.springmybaits.annotation.ShutMethod;
import com.csl.demo.springmybaits.entity.User;
import com.csl.demo.springmybaits.service.MapperService;

/**
 * @author Cherry
 * @date  2019年5月22日
 */
@RestController
@RequestMapping("/mapper")
public class MapperController {
	@Autowired
	private MapperService mapperService;
	
	/*
	 * 一条数据使用一个map，取出的数据都放进list
	 */
	@RequestMapping(value="/getAllUser",method=RequestMethod.POST)
	@ShutMethod(isShunt=true)
	public ArrayList<HashMap<String, Object>> getAllUser(){
		return mapperService.getAllUser();
	}
	
	@RequestMapping(value="/getAllUserForEntity",method=RequestMethod.POST)
	@ShutMethod
	public ArrayList<User> getAllUserForEntity(){
		return mapperService.getAllUserForEntity();
	}
	
	/*
	 * 从数据库视图中获取用户及用户订单信息
	 */
	@RequestMapping(value="/showView",method=RequestMethod.POST)
	public ArrayList<HashMap<String, Object>> showView(int id){
		return mapperService.showView(id);
	}
	
	/*
	 * map作为查询参数,查询试图(map中的key值有：username,price)
	 */
	@RequestMapping(value="/queryViewForMap",method=RequestMethod.POST)
	public int queryViewForMap(HashMap<String, Object> map){
		return mapperService.queryViewForMap(map);
	}
}
