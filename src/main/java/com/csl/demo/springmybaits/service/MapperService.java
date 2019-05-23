package com.csl.demo.springmybaits.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csl.demo.springmybaits.dao.Mapper;
import com.csl.demo.springmybaits.entity.User;
/**
 * @author Cherry
 * @date  2019年5月22日
 */
@Service
public class MapperService {
	@Autowired
	private Mapper mapper;
	
	/*
	 * 一条数据使用一个map，取出的数据都放进list
	 */
	public ArrayList<HashMap<String, Object>> getAllUser(){
		return mapper.getAllUser();
	}
	
	public ArrayList<User> getAllUserForEntity(){
		return mapper.getAllUserForEntity();
	}
	
	/*
	 * 从数据库视图中获取用户及用户订单信息
	 */
	public ArrayList<HashMap<String, Object>> showView(int id){
		return mapper.showView(id);
	}
	
	/*
	 * map作为查询参数,查询试图(map中的key值有：username,price)
	 */
	public int queryViewForMap(HashMap<String,Object> map){
		return mapper.queryViewForMap(map);
	}
}
