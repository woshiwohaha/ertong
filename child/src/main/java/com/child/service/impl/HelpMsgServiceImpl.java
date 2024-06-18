package com.child.service.impl;

import com.child.controller.LoginModel;
import com.child.dao.HelpMsgMapper;
import com.child.model.HelpMsg;
import com.child.model.HelpMsgExample;
import com.child.service.HelpMsgService;
import com.child.util.DataListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class HelpMsgServiceImpl implements HelpMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	HelpMsgMapper helpMsgMapper;
	/**
	新增
	*/
	@Override
	public String add(HelpMsg model,LoginModel login){
		if(model.getHname()==null||model.getHname().equals("")){
			return "姓名为必填属性";
		}
		if(model.getHage()==null){
			return "年龄为必填属性";
		}
		if(model.getHzp()==null||model.getHzp().equals("")){
			return "照片为必填属性";
		}
		if(model.getHzp()!=null){
			String [] fileSplit = model.getHzp().split(";");
			if(fileSplit.length>1){
				return "照片的图片数量不能大于1";
			}
		}
		if(model.getHsex()==null){
			return "性别为必填属性";
		}
		if(model.getHcel()==null||model.getHcel().equals("")){
			return "联系电话为必填属性";
		}
		if(model.getHcel()!=null){
		Pattern p = Pattern.compile("^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
			Matcher m = p.matcher(model.getHcel());
			if( m.matches()==false){
				return "请输入正确的联系电话";
			}
		}
		if(model.getHelpIntro()==null||model.getHelpIntro().equals("")){
			return "具体情况为必填属性";
		}
		if(model.getAmount()==null){
			return "需要金额为必填属性";
		}
		model.setCreateDate(sdf2.format(new Date()));//当前日期格式
		helpMsgMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(HelpMsg model,LoginModel login){
		HelpMsg preModel = helpMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getHname()==null||model.getHname().equals("")){
			return "姓名为必填属性";
		}
		if(model.getHage()==null){
			return "年龄为必填属性";
		}
		if(model.getHzp()==null||model.getHzp().equals("")){
			return "照片为必填属性";
		}
		if(model.getHzp()!=null){
			String [] fileSplit = model.getHzp().split(";");
			if(fileSplit.length>1){
				return "照片的图片数量不能大于1";
			}
		}
		if(model.getHsex()==null){
			return "性别为必填属性";
		}
		if(model.getHcel()==null||model.getHcel().equals("")){
			return "联系电话为必填属性";
		}
		if(model.getHcel()!=null){
		Pattern p = Pattern.compile("^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
			Matcher m = p.matcher(model.getHcel());
			if( m.matches()==false){
				return "请输入正确的联系电话";
			}
		}
		if(model.getHelpIntro()==null||model.getHelpIntro().equals("")){
			return "具体情况为必填属性";
		}
		if(model.getAmount()==null){
			return "需要金额为必填属性";
		}
		preModel.setHname(model.getHname());
		preModel.setHage(model.getHage());
		preModel.setHzp(model.getHzp());
		preModel.setHsex(model.getHsex());
		preModel.setHcel(model.getHcel());
		preModel.setHelpIntro(model.getHelpIntro());
		preModel.setAmount(model.getAmount());
		helpMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询求助信息列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(HelpMsg queryModel,Integer pageSize,LoginModel login) {
		HelpMsgExample se = new HelpMsgExample();
		HelpMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getHname()!=null&&queryModel.getHname().equals("")==false){
			sc.andHnameLike("%"+queryModel.getHname()+"%");//模糊查询
		}
		if(queryModel.getHsex()!=null){
			sc.andHsexEqualTo(queryModel.getHsex());//查询性别等于指定值
		}
		int count = (int)helpMsgMapper.countByExample(se);
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
	*根据参数查询求助信息列表数据
	*/
	@Override
	public Map<String,Object> getDataList(HelpMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		HelpMsgExample se = new HelpMsgExample();
		HelpMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getHname()!=null&&queryModel.getHname().equals("")==false){
			sc.andHnameLike("%"+queryModel.getHname()+"%");//模糊查询
		}
		if(queryModel.getHsex()!=null){
			sc.andHsexEqualTo(queryModel.getHsex());//查询性别等于指定值
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<HelpMsg> list = helpMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(HelpMsg model:list){
			list2.add(getHelpMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装求助信息为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getHelpMsgModel(HelpMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("helpMsg",model);
		map.put("hsexStr", DataListUtils.getSexNameById(model.getHsex()+""));//解释性别字段
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		helpMsgMapper.deleteByPrimaryKey(id);
	}
}
