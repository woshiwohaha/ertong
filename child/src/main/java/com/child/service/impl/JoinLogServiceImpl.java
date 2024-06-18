package com.child.service.impl;

import com.child.controller.LoginModel;
import com.child.dao.ActMsgMapper;
import com.child.dao.JoinLogMapper;
import com.child.dao.UserMsgMapper;
import com.child.model.ActMsg;
import com.child.model.JoinLog;
import com.child.model.JoinLogExample;
import com.child.model.UserMsg;
import com.child.service.JoinLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JoinLogServiceImpl implements JoinLogService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	ActMsgMapper actMsgMapper;
	@Autowired
	JoinLogMapper joinLogMapper;
	/**
	*根据参数查询参加记录列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(JoinLog queryModel,Integer pageSize,LoginModel login) {
		JoinLogExample se = new JoinLogExample();
		JoinLogExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getAid()!=null){
			sc.andAidEqualTo(queryModel.getAid());
		}
		if(queryModel.getUrealName()!=null&&queryModel.getUrealName().equals("")==false){
			sc.andUrealNameLike("%"+queryModel.getUrealName()+"%");//模糊查询
		}
		if(queryModel.getUid()!=null){
			sc.andUidEqualTo(queryModel.getUid());
		}
		int count = (int)joinLogMapper.countByExample(se);
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
	*根据参数查询参加记录列表数据
	*/
	@Override
	public Map<String,Object> getDataList(JoinLog queryModel,Integer page,Integer pageSize,LoginModel login) {
		JoinLogExample se = new JoinLogExample();
		JoinLogExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getAid()!=null){
			sc.andAidEqualTo(queryModel.getAid());
		}
		if(queryModel.getUrealName()!=null&&queryModel.getUrealName().equals("")==false){
			sc.andUrealNameLike("%"+queryModel.getUrealName()+"%");//模糊查询
		}
		if(queryModel.getUid()!=null){
			sc.andUidEqualTo(queryModel.getUid());
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<JoinLog> list = joinLogMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(JoinLog model:list){
			list2.add(getJoinLogModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装参加记录为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getJoinLogModel(JoinLog model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("joinLog",model);
		if(model.getUid()!=null){
			UserMsg userMsg = userMsgMapper.selectByPrimaryKey(model.getUid());//用户ID为外接字段，需要关联用户来解释该字段
			if(userMsg!=null){
				map.put("uidStr",userMsg.getLoginName());
			}
		}
		if(model.getAid()!=null){
			ActMsg actMsg = actMsgMapper.selectByPrimaryKey(model.getAid());//志愿活动ID为外接字段，需要关联志愿活动来解释该字段
			if(actMsg!=null){
				map.put("aidStr",actMsg.getActName());
			}
		}
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		joinLogMapper.deleteByPrimaryKey(id);
	}
}
