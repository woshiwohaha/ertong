package com.child.service.impl;

import com.child.controller.LoginModel;
import com.child.dao.DonateLogMapper;
import com.child.dao.HelpMsgMapper;
import com.child.dao.UserMsgMapper;
import com.child.model.DonateLog;
import com.child.model.DonateLogExample;
import com.child.model.HelpMsg;
import com.child.model.UserMsg;
import com.child.service.DonateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DonateLogServiceImpl implements DonateLogService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	HelpMsgMapper helpMsgMapper;
	@Autowired
	DonateLogMapper donateLogMapper;
	/**
	*根据参数查询捐助记录列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(DonateLog queryModel,Integer pageSize,LoginModel login) {
		DonateLogExample se = new DonateLogExample();
		DonateLogExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getHid()!=null){
			sc.andHidEqualTo(queryModel.getHid());
		}
		if(queryModel.getContactMsg()!=null&&queryModel.getContactMsg().equals("")==false){
			sc.andContactMsgLike("%"+queryModel.getContactMsg()+"%");//模糊查询
		}
		if(queryModel.getUid()!=null){
			sc.andUidEqualTo(queryModel.getUid());
		}
		int count = (int)donateLogMapper.countByExample(se);
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
	*根据参数查询捐助记录列表数据
	*/
	@Override
	public Map<String,Object> getDataList(DonateLog queryModel,Integer page,Integer pageSize,LoginModel login) {
		DonateLogExample se = new DonateLogExample();
		DonateLogExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getHid()!=null){
			sc.andHidEqualTo(queryModel.getHid());
		}
		if(queryModel.getContactMsg()!=null&&queryModel.getContactMsg().equals("")==false){
			sc.andContactMsgLike("%"+queryModel.getContactMsg()+"%");//模糊查询
		}
		if(queryModel.getUid()!=null){
			sc.andUidEqualTo(queryModel.getUid());
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<DonateLog> list = donateLogMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(DonateLog model:list){
			list2.add(getDonateLogModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装捐助记录为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getDonateLogModel(DonateLog model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("donateLog",model);
		if(model.getUid()!=null){
			UserMsg userMsg = userMsgMapper.selectByPrimaryKey(model.getUid());//用户ID为外接字段，需要关联用户来解释该字段
			if(userMsg!=null){
				map.put("uidStr",userMsg.getLoginName());
			}
		}
		if(model.getHid()!=null){
			HelpMsg helpMsg = helpMsgMapper.selectByPrimaryKey(model.getHid());//求助ID为外接字段，需要关联求助信息来解释该字段
			if(helpMsg!=null){
				map.put("hidStr",helpMsg.getHname());
			}
		}
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		donateLogMapper.deleteByPrimaryKey(id);
	}
}
