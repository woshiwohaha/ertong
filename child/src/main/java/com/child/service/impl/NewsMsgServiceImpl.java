package com.child.service.impl;

import com.child.controller.LoginModel;
import com.child.dao.AdminMsgMapper;
import com.child.dao.NewsMsgMapper;
import com.child.model.AdminMsg;
import com.child.model.NewsMsg;
import com.child.model.NewsMsgExample;
import com.child.service.NewsMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class NewsMsgServiceImpl implements NewsMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	AdminMsgMapper adminMsgMapper;
	@Autowired
	NewsMsgMapper newsMsgMapper;
	/**
	新增
	*/
	@Override
	public String add(NewsMsg model,LoginModel login){
		if(model.getNewsName()==null||model.getNewsName().equals("")){
			return "标题为必填属性";
		}
		if(model.getNoticeImg()==null||model.getNoticeImg().equals("")){
			return "图片为必填属性";
		}
		if(model.getNoticeImg()!=null){
			String [] fileSplit = model.getNoticeImg().split(";");
			if(fileSplit.length>1){
				return "图片的图片数量不能大于1";
			}
		}
		if(model.getNewsDetail()==null||model.getNewsDetail().equals("")){
			return "新闻详情为必填属性";
		}
		model.setAid(login.getId());//登录id
		model.setCreateTime(sdf1.format(new Date()));//当前时间格式
		newsMsgMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(NewsMsg model,LoginModel login){
		NewsMsg preModel = newsMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getNewsName()==null||model.getNewsName().equals("")){
			return "标题为必填属性";
		}
		if(model.getNoticeImg()==null||model.getNoticeImg().equals("")){
			return "图片为必填属性";
		}
		if(model.getNoticeImg()!=null){
			String [] fileSplit = model.getNoticeImg().split(";");
			if(fileSplit.length>1){
				return "图片的图片数量不能大于1";
			}
		}
		if(model.getNewsDetail()==null||model.getNewsDetail().equals("")){
			return "新闻详情为必填属性";
		}
		preModel.setNewsName(model.getNewsName());
		preModel.setNoticeImg(model.getNoticeImg());
		preModel.setNewsDetail(model.getNewsDetail());
		newsMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询新闻列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(NewsMsg queryModel,Integer pageSize,LoginModel login) {
		NewsMsgExample se = new NewsMsgExample();
		NewsMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getNewsName()!=null&&queryModel.getNewsName().equals("")==false){
			sc.andNewsNameLike("%"+queryModel.getNewsName()+"%");//模糊查询
		}
		if(queryModel.getAid()!=null){
			sc.andAidEqualTo(queryModel.getAid());
		}
		int count = (int)newsMsgMapper.countByExample(se);
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
	*根据参数查询新闻列表数据
	*/
	@Override
	public Map<String,Object> getDataList(NewsMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		NewsMsgExample se = new NewsMsgExample();
		NewsMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getNewsName()!=null&&queryModel.getNewsName().equals("")==false){
			sc.andNewsNameLike("%"+queryModel.getNewsName()+"%");//模糊查询
		}
		if(queryModel.getAid()!=null){
			sc.andAidEqualTo(queryModel.getAid());
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<NewsMsg> list = newsMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(NewsMsg model:list){
			list2.add(getNewsMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装新闻为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getNewsMsgModel(NewsMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("newsMsg",model);
		if(model.getAid()!=null){
			AdminMsg adminMsg = adminMsgMapper.selectByPrimaryKey(model.getAid());//发布人为外接字段，需要关联管理员来解释该字段
			if(adminMsg!=null){
				map.put("aidStr",adminMsg.getLoginName());
			}
		}
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		newsMsgMapper.deleteByPrimaryKey(id);
	}
}
