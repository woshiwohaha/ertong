package com.child.service.impl;

import com.child.controller.LoginModel;
import com.child.dao.AdminMsgMapper;
import com.child.model.AdminMsg;
import com.child.model.AdminMsgExample;
import com.child.service.AdminMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminMsgServiceImpl implements AdminMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	AdminMsgMapper adminMsgMapper;
	/**
	*根据参数查询管理员列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(AdminMsg queryModel,Integer pageSize,LoginModel login) {
		AdminMsgExample se = new AdminMsgExample();
		AdminMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getLoginName()!=null&&queryModel.getLoginName().equals("")==false){
			sc.andLoginNameLike("%"+queryModel.getLoginName()+"%");//模糊查询
		}
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		int count = (int)adminMsgMapper.countByExample(se);
		int totalPage = 0;
		if ((count > 0) && ((count % pageSize) == 0)) {
			totalPage = count / pageSize;
		} else {
			totalPage = (count / pageSize) + 1;
		}
		Map<String,Integer> rs = new HashMap<String,Integer>();
		rs.put("count",count);//数据总数
		rs.put("totalPage",totalPage);//总页数
		return rs;
	}
	/**
	*根据参数查询管理员列表数据
	*/
	@Override
	public Map<String,Object> getDataList(AdminMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		AdminMsgExample se = new AdminMsgExample();
		AdminMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getLoginName()!=null&&queryModel.getLoginName().equals("")==false){
			sc.andLoginNameLike("%"+queryModel.getLoginName()+"%");//模糊查询
		}
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<AdminMsg> list = adminMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(AdminMsg model:list){
			list2.add(getAdminMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装管理员为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getAdminMsgModel(AdminMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("adminMsg",model);
		return map;
	}
}
