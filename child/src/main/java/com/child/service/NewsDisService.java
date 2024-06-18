package com.child.service;

import com.child.controller.LoginModel;
import com.child.model.NewsDis;

import java.util.Map;

public interface NewsDisService{
	/**
	分页查询新闻评论数据总数
	*/
	public Map<String,Integer> getDataListCount(NewsDis queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询新闻评论数据列表
	*/
	public Map<String,Object> getDataList(NewsDis queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装新闻评论为前台展示的数据形式
	*/
	public Map<String,Object> getNewsDisModel(NewsDis model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
}
