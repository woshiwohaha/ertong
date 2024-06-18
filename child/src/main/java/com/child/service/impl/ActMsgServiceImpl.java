package com.child.service.impl;

import com.child.controller.LoginModel;
import com.child.dao.ActMsgMapper;
import com.child.dao.JoinLogMapper;
import com.child.dao.UserMsgMapper;
import com.child.model.ActMsg;
import com.child.model.ActMsgExample;
import com.child.model.JoinLog;
import com.child.model.UserMsg;
import com.child.service.ActMsgService;
import com.child.util.DataListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ActMsgServiceImpl implements ActMsgService{
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
	新增
	*/
	@Override
	public String add(ActMsg model,LoginModel login){
		if(model.getActName()==null||model.getActName().equals("")){
			return "活动名为必填属性";
		}
		if(model.getActImg()==null||model.getActImg().equals("")){
			return "图片为必填属性";
		}
		if(model.getActImg()!=null){
			String [] fileSplit = model.getActImg().split(";");
			if(fileSplit.length>1){
				return "图片的图片数量不能大于1";
			}
		}
		if(model.getActTime()==null||model.getActTime().equals("")){
			return "活动时间为必填属性";
		}
		if(model.getAddress()==null||model.getAddress().equals("")){
			return "活动地点为必填属性";
		}
		if(model.getContactMsg()==null||model.getContactMsg().equals("")){
			return "联系方式为必填属性";
		}
		if(model.getActDetail()==null||model.getActDetail().equals("")){
			return "活动详情为必填属性";
		}
		if(model.getActStatus()==null){
			return "状态为必填属性";
		}
		model.setJoinNum(0);//默认0
		model.setCreateTime(sdf1.format(new Date()));//当前时间格式
		actMsgMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	新增
	*/
	@Override
	public String add1(ActMsg model,LoginModel login){
		if(model.getActName()==null||model.getActName().equals("")){
			return "活动名为必填属性";
		}
		if(model.getActImg()==null||model.getActImg().equals("")){
			return "图片为必填属性";
		}
		if(model.getActImg()!=null){
			String [] fileSplit = model.getActImg().split(";");
			if(fileSplit.length>1){
				return "图片的图片数量不能大于1";
			}
		}
		if(model.getActTime()==null||model.getActTime().equals("")){
			return "活动时间为必填属性";
		}
		if(model.getAddress()==null||model.getAddress().equals("")){
			return "活动地点为必填属性";
		}
		if(model.getContactMsg()==null||model.getContactMsg().equals("")){
			return "联系方式为必填属性";
		}
		if(model.getActDetail()==null||model.getActDetail().equals("")){
			return "活动详情为必填属性";
		}
		model.setJoinNum(0);//默认0
		model.setCreateTime(sdf1.format(new Date()));//当前时间格式
		model.setActStatus(3);
		model.setUserId(login.getId());//登录id
		actMsgMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(ActMsg model,LoginModel login){
		ActMsg preModel = actMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getActName()==null||model.getActName().equals("")){
			return "活动名为必填属性";
		}
		if(model.getActImg()==null||model.getActImg().equals("")){
			return "图片为必填属性";
		}
		if(model.getActImg()!=null){
			String [] fileSplit = model.getActImg().split(";");
			if(fileSplit.length>1){
				return "图片的图片数量不能大于1";
			}
		}
		if(model.getActTime()==null||model.getActTime().equals("")){
			return "活动时间为必填属性";
		}
		if(model.getAddress()==null||model.getAddress().equals("")){
			return "活动地点为必填属性";
		}
		if(model.getContactMsg()==null||model.getContactMsg().equals("")){
			return "联系方式为必填属性";
		}
		if(model.getActDetail()==null||model.getActDetail().equals("")){
			return "活动详情为必填属性";
		}
		if(model.getActStatus()==null){
			return "状态为必填属性";
		}
		preModel.setActName(model.getActName());
		preModel.setActImg(model.getActImg());
		preModel.setActTime(model.getActTime());
		preModel.setAddress(model.getAddress());
		preModel.setContactMsg(model.getContactMsg());
		preModel.setActDetail(model.getActDetail());
		preModel.setActStatus(model.getActStatus());
		actMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update1(ActMsg model,LoginModel login){
		ActMsg preModel = actMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getActName()==null||model.getActName().equals("")){
			return "活动名为必填属性";
		}
		if(model.getActImg()==null||model.getActImg().equals("")){
			return "图片为必填属性";
		}
		if(model.getActImg()!=null){
			String [] fileSplit = model.getActImg().split(";");
			if(fileSplit.length>1){
				return "图片的图片数量不能大于1";
			}
		}
		if(model.getActTime()==null||model.getActTime().equals("")){
			return "活动时间为必填属性";
		}
		if(model.getAddress()==null||model.getAddress().equals("")){
			return "活动地点为必填属性";
		}
		if(model.getContactMsg()==null||model.getContactMsg().equals("")){
			return "联系方式为必填属性";
		}
		if(model.getActDetail()==null||model.getActDetail().equals("")){
			return "活动详情为必填属性";
		}
		preModel.setActName(model.getActName());
		preModel.setActImg(model.getActImg());
		preModel.setActTime(model.getActTime());
		preModel.setAddress(model.getAddress());
		preModel.setContactMsg(model.getContactMsg());
		preModel.setActDetail(model.getActDetail());
		actMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}

	/**
	 * 修改参加人数
	 */
	@Override
	public String update2(int jid,LoginModel login){
		JoinLog joinLog = joinLogMapper.selectByPrimaryKey(jid);
		if (joinLog!=null){
			System.out.println(joinLog);
			Integer aid = joinLog.getAid();
			ActMsg actMsg = actMsgMapper.selectByPrimaryKey(aid);
			actMsg.setJoinNum(actMsg.getJoinNum()-1);
			System.out.println(actMsg.getJoinNum());
			actMsgMapper.updateByPrimaryKey(actMsg);
		}

		return "";
	}
	/**
	*根据参数查询志愿活动列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(ActMsg queryModel,Integer pageSize,LoginModel login) {
		ActMsgExample se = new ActMsgExample();
		ActMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getActName()!=null&&queryModel.getActName().equals("")==false){
			sc.andActNameLike("%"+queryModel.getActName()+"%");//模糊查询
		}
		if(queryModel.getActStatus()!=null){
			sc.andActStatusEqualTo(queryModel.getActStatus());//查询状态等于指定值
		}
		if(queryModel.getUserId()!=null){
			sc.andUserIdEqualTo(queryModel.getUserId());
		}
		int count = (int)actMsgMapper.countByExample(se);
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
	*根据参数查询志愿活动列表数据
	*/
	@Override
	public Map<String,Object> getDataList(ActMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		ActMsgExample se = new ActMsgExample();
		ActMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getActName()!=null&&queryModel.getActName().equals("")==false){
			sc.andActNameLike("%"+queryModel.getActName()+"%");//模糊查询
		}
		if(queryModel.getActStatus()!=null){
			sc.andActStatusEqualTo(queryModel.getActStatus());//查询状态等于指定值
		}
		if(queryModel.getUserId()!=null){
			sc.andUserIdEqualTo(queryModel.getUserId());
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<ActMsg> list = actMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(ActMsg model:list){
			list2.add(getActMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装志愿活动为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getActMsgModel(ActMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("actMsg",model);
		map.put("actStatusStr", DataListUtils.getActStatusNameById(model.getActStatus()+""));//解释状态字段
		if(model.getUserId()!=null){
			UserMsg userMsg = userMsgMapper.selectByPrimaryKey(model.getUserId());//发布用户为外接字段，需要关联用户来解释该字段
			if(userMsg!=null){
				map.put("userIdStr",userMsg.getLoginName());
			}
		}
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		actMsgMapper.deleteByPrimaryKey(id);
	}
}
