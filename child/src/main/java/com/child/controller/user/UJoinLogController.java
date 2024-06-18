package com.child.controller.user;

import com.child.controller.LoginModel;
import com.child.dao.ActMsgMapper;
import com.child.dao.JoinLogMapper;
import com.child.dao.UserMsgMapper;
import com.child.model.JoinLog;
import com.child.model.UserMsg;
import com.child.service.JoinLogService;
import com.child.util.CommonVal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/user/join_log")
public class UJoinLogController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	JoinLogService joinLogService;
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	ActMsgMapper actMsgMapper;
	@Autowired
	JoinLogMapper joinLogMapper;
	/**
	* 根据查询条件分页查询参加记录数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(JoinLog model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		model.setUid(login.getId());//用户ID等于当前登录id
		return joinLogService.getDataListCount(model,CommonVal.pageSize,login);//分页查询数据总数
	}
	/**
	* 返回参加记录列表jsp页面
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		UserMsg userMsg = userMsgMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user",userMsg);
		return "user/join_log/list";
	}
	/**
	* 根据查询条件分页查询参加记录数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(JoinLog model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		model.setUid(login.getId());//用户ID等于当前登录id
		return joinLogService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
}
