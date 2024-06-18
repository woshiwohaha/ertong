package com.child.service;

import com.child.controller.LoginModel;
import com.child.model.HelpMsg;

import java.util.Map;

public interface HelpMsgService{
	/**
	分页查询求助信息数据总数
	*/
	public Map<String,Integer> getDataListCount(HelpMsg queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询求助信息数据列表
	*/
	public Map<String,Object> getDataList(HelpMsg queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装求助信息为前台展示的数据形式
	*/
	public Map<String,Object> getHelpMsgModel(HelpMsg model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(HelpMsg model,LoginModel login);
	/**
	修改
	*/
	public String update(HelpMsg model,LoginModel login);
}
