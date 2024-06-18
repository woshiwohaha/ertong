package com.child.service;

import com.child.controller.LoginModel;
import com.child.model.UserMsg;

import java.util.Map;

public interface UserMsgService{
	/**
	分页查询用户数据总数
	*/
	public Map<String,Integer> getDataListCount(UserMsg queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询用户数据列表
	*/
	public Map<String,Object> getDataList(UserMsg queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装用户为前台展示的数据形式
	*/
	public Map<String,Object> getUserMsgModel(UserMsg model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(UserMsg model,LoginModel login);
	/**
	修改
	*/
	public String update(UserMsg model,LoginModel login);
	/**
	修改
	*/
	public String update1(UserMsg model,LoginModel login);
}
