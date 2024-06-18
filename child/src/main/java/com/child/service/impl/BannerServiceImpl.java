package com.child.service.impl;

import com.child.controller.LoginModel;
import com.child.dao.BannerMapper;
import com.child.dao.HelpMsgMapper;
import com.child.model.Banner;
import com.child.model.BannerExample;
import com.child.model.HelpMsg;
import com.child.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BannerServiceImpl implements BannerService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	HelpMsgMapper helpMsgMapper;
	@Autowired
	BannerMapper bannerMapper;
	/**
	新增
	*/
	@Override
	public String add(Banner model,LoginModel login){
		if(model.getBimg()==null||model.getBimg().equals("")){
			return "轮播图为必填属性";
		}
		if(model.getBimg()!=null){
			String [] fileSplit = model.getBimg().split(";");
			if(fileSplit.length>1){
				return "轮播图的图片数量不能大于1";
			}
		}
		if(model.getHelpId()==null){
			return "求助ID为必填属性";
		}
		bannerMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(Banner model,LoginModel login){
		Banner preModel = bannerMapper.selectByPrimaryKey(model.getId());
		if(model.getBimg()==null||model.getBimg().equals("")){
			return "轮播图为必填属性";
		}
		if(model.getBimg()!=null){
			String [] fileSplit = model.getBimg().split(";");
			if(fileSplit.length>1){
				return "轮播图的图片数量不能大于1";
			}
		}
		if(model.getHelpId()==null){
			return "求助ID为必填属性";
		}
		preModel.setBimg(model.getBimg());
		preModel.setHelpId(model.getHelpId());
		bannerMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询轮播图列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(Banner queryModel,Integer pageSize,LoginModel login) {
		BannerExample se = new BannerExample();
		BannerExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getHelpId()!=null){
			sc.andHelpIdEqualTo(queryModel.getHelpId());//查询求助ID等于指定值
		}
		int count = (int)bannerMapper.countByExample(se);
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
	*根据参数查询轮播图列表数据
	*/
	@Override
	public Map<String,Object> getDataList(Banner queryModel,Integer page,Integer pageSize,LoginModel login) {
		BannerExample se = new BannerExample();
		BannerExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getHelpId()!=null){
			sc.andHelpIdEqualTo(queryModel.getHelpId());//查询求助ID等于指定值
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<Banner> list = bannerMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(Banner model:list){
			list2.add(getBannerModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装轮播图为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getBannerModel(Banner model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("banner",model);
		if(model.getHelpId()!=null){
			HelpMsg helpMsg = helpMsgMapper.selectByPrimaryKey(model.getHelpId());//求助ID为外接字段，需要关联求助信息来解释该字段
			if(helpMsg!=null){
				map.put("helpIdStr",helpMsg.getHname());
			}
		}
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		bannerMapper.deleteByPrimaryKey(id);
	}
}
