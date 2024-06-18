package com.child.service;

import com.child.controller.LoginModel;
import com.child.model.DonateLog;

import java.util.Map;

public interface DonateLogService{
	/**
	分页查询捐助记录数据总数
	*/
	public Map<String,Integer> getDataListCount(DonateLog queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询捐助记录数据列表
	*/
	public Map<String,Object> getDataList(DonateLog queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装捐助记录为前台展示的数据形式
	*/
	public Map<String,Object> getDonateLogModel(DonateLog model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
}
