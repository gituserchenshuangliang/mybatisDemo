package com.csl.demo.springmybaits.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.csl.demo.springmybaits.annotation.ShutMethod;
import com.csl.demo.springmybaits.entity.User;
import com.csl.demo.springmybaits.service.MapperService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Cherry
 * @date  2019年5月22日
 */
@RestController
@RequestMapping("/mapper")
@Api(tags="MapperController测试接口")
public class MapperController {
	@Autowired
	private MapperService mapperService;
	
	/*
	 * 一条数据使用一个map，取出的数据都放进list
	 */
	@RequestMapping(value="/getAllUser",method=RequestMethod.POST)
	@ShutMethod(isShunt=true)
	@ApiOperation(value = "获取所以用户")
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
	 * {'username':'chen','price':'4000'}
	 */
	@RequestMapping(value="/queryViewForMap",method=RequestMethod.POST)
	public int queryViewForMap(String maps){
		JSONObject mapa = JSONObject.parseObject(maps);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("username", mapa.getString("username"));
		map.put("price", mapa.getInteger("price"));
		return mapperService.queryViewForMap(map);
	}
}
