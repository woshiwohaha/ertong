package com.child.service;

import com.child.controller.LoginModel;
import com.child.model.JoinLog;

import java.util.Map;

public interface JoinLogService{
	/**
	分页查询参加记录数据总数
	*/
	public Map<String,Integer> getDataListCount(JoinLog queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询参加记录数据列表
	*/
	public Map<String,Object> getDataList(JoinLog queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装参加记录为前台展示的数据形式
	*/
	public Map<String,Object> getJoinLogModel(JoinLog model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
}
