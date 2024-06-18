package com.child.service.impl;

import com.child.controller.LoginModel;
import com.child.dao.NewsDisMapper;
import com.child.dao.NewsMsgMapper;
import com.child.dao.UserMsgMapper;
import com.child.model.NewsDis;
import com.child.model.NewsDisExample;
import com.child.model.NewsMsg;
import com.child.model.UserMsg;
import com.child.service.NewsDisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsDisServiceImpl implements NewsDisService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	NewsMsgMapper newsMsgMapper;
	@Autowired
	NewsDisMapper newsDisMapper;
	/**
	*根据参数查询新闻评论列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(NewsDis queryModel,Integer pageSize,LoginModel login) {
		NewsDisExample se = new NewsDisExample();
		NewsDisExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getContent()!=null&&queryModel.getContent().equals("")==false){
			sc.andContentLike("%"+queryModel.getContent()+"%");//模糊查询
		}
		if(queryModel.getUid()!=null){
			sc.andUidEqualTo(queryModel.getUid());
		}
		int count = (int)newsDisMapper.countByExample(se);
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
	*根据参数查询新闻评论列表数据
	*/
	@Override
	public Map<String,Object> getDataList(NewsDis queryModel,Integer page,Integer pageSize,LoginModel login) {
		NewsDisExample se = new NewsDisExample();
		NewsDisExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getContent()!=null&&queryModel.getContent().equals("")==false){
			sc.andContentLike("%"+queryModel.getContent()+"%");//模糊查询
		}
		if(queryModel.getUid()!=null){
			sc.andUidEqualTo(queryModel.getUid());
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<NewsDis> list = newsDisMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(NewsDis model:list){
			list2.add(getNewsDisModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装新闻评论为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getNewsDisModel(NewsDis model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("newsDis",model);
		if(model.getNid()!=null){
			NewsMsg newsMsg = newsMsgMapper.selectByPrimaryKey(model.getNid());//新闻ID为外接字段，需要关联新闻来解释该字段
			if(newsMsg!=null){
				map.put("nidStr",newsMsg.getNewsName());
			}
		}
		if(model.getUid()!=null){
			UserMsg userMsg = userMsgMapper.selectByPrimaryKey(model.getUid());//用户ID为外接字段，需要关联用户来解释该字段
			if(userMsg!=null){
				map.put("uidStr",userMsg.getLoginName());
			}
		}
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		newsDisMapper.deleteByPrimaryKey(id);
	}
}
