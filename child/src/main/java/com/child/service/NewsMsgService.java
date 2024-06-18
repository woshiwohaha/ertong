package com.child.service;

import com.child.controller.LoginModel;
import com.child.model.NewsMsg;

import java.util.Map;

public interface NewsMsgService{
	/**
	分页查询新闻数据总数
	*/
	public Map<String,Integer> getDataListCount(NewsMsg queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询新闻数据列表
	*/
	public Map<String,Object> getDataList(NewsMsg queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装新闻为前台展示的数据形式
	*/
	public Map<String,Object> getNewsMsgModel(NewsMsg model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(NewsMsg model,LoginModel login);
	/**
	修改
	*/
	public String update(NewsMsg model,LoginModel login);
}
