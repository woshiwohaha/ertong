package com.child.controller.user;

import com.child.controller.LoginModel;
import com.child.dao.ActMsgMapper;
import com.child.dao.UserMsgMapper;
import com.child.model.ActMsg;
import com.child.model.UserMsg;
import com.child.service.ActMsgService;
import com.child.util.CommonVal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user/act_msg")
public class UActMsgController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	ActMsgService actMsgService;
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	ActMsgMapper actMsgMapper;
	/**
	* 根据查询条件分页查询志愿活动数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(ActMsg model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		model.setUserId(login.getId());//发布用户等于当前登录id
		return actMsgService.getDataListCount(model,CommonVal.pageSize,login);//分页查询数据总数
	}
	@RequestMapping(value = "queryDataDetail")
	@ResponseBody
	public Object queryDataDetail(Integer id, HttpServletRequest request) {
		ActMsg actMsg = actMsgMapper.selectByPrimaryKey(id);
		return actMsg;
	}
	/**
	* 返回志愿活动列表jsp页面
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		UserMsg userMsg = userMsgMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user",userMsg);
		return "user/act_msg/list";
	}
	/**
	* 根据查询条件分页查询志愿活动数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(ActMsg model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		model.setUserId(login.getId());//发布用户等于当前登录id
		return actMsgService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	查看详情接口
	*/
	@RequestMapping("detail2")
	public Object detail2(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		ActMsg model = new ActMsg();
		model.setId(id);
		ActMsg preModel = actMsgMapper.selectByPrimaryKey(id);
		modelMap.addAttribute("detail", actMsgService.getActMsgModel(preModel,login));
		return "user/act_msg/detail";
	}
	/**
	进入新增页面
	*/
	@RequestMapping("add1")
	public String add1(ModelMap modelMap,ActMsg model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		modelMap.addAttribute("data",model);
		return "user/act_msg/add1_page";
	}
	/**
	新增提交信息接口
	*/
	@RequestMapping("add1_submit")
	@ResponseBody
	public Object add1_submit(ActMsg model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = actMsgService.add1(model,login);//执行添加操作
		if(msg.equals("")){
			rs.put("code",1);
			rs.put("msg","新增成功");
			return rs;
		}
		rs.put("code",0);
		rs.put("msg",msg);
		return rs;
	}
	/**
	进入修改页面
	*/
	@RequestMapping("update1")
	public String update1(ModelMap modelMap,ActMsg model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		ActMsg data = actMsgMapper.selectByPrimaryKey(model.getId());
		if(data.getActDetail()!=null){
			data.setActDetail(data.getActDetail().replaceAll("'","\\\\'"));//wangeditor需要过滤掉'符号，否则初始化可能报错
		}
		modelMap.addAttribute("data",data);
		return "user/act_msg/update1_page";
	}
	/**
	修改提交信息接口
	*/
	@RequestMapping("update1_submit")
	@ResponseBody
	public Object update1_submit(ActMsg model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = actMsgService.update1(model,login);//执行修改操作
		if(msg.equals("")){
			rs.put("code",1);
			rs.put("msg","修改成功");
			return rs;
		}
		rs.put("code",0);
		rs.put("msg",msg);
		return rs;
	}
	/**
	删除志愿活动接口
	*/
	@RequestMapping("del1")
	@ResponseBody
	public Object del1(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		actMsgService.delete(id);
		rs.put("code",1);
		rs.put("msg","删除成功");
		return rs;
	}
}
