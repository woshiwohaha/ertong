package com.child.service;

import com.child.controller.LoginModel;
import com.child.model.ActMsg;

import java.util.Map;

public interface ActMsgService{
	/**
	分页查询志愿活动数据总数
	*/
	public Map<String,Integer> getDataListCount(ActMsg queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询志愿活动数据列表
	*/
	public Map<String,Object> getDataList(ActMsg queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装志愿活动为前台展示的数据形式
	*/
	public Map<String,Object> getActMsgModel(ActMsg model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(ActMsg model,LoginModel login);
	/**
	新增
	*/
	public String add1(ActMsg model,LoginModel login);
	/**
	修改
	*/
	public String update(ActMsg model,LoginModel login);
	/**
	修改
	*/
	public String update1(ActMsg model,LoginModel login);

	/**
	 *修改参加人数
	 */
	public String update2(int jid,LoginModel login);

}
