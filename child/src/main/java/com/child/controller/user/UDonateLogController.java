package com.child.controller.user;

import com.child.controller.LoginModel;
import com.child.dao.DonateLogMapper;
import com.child.dao.HelpMsgMapper;
import com.child.dao.UserMsgMapper;
import com.child.model.DonateLog;
import com.child.model.UserMsg;
import com.child.service.DonateLogService;
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
@RequestMapping("/user/donate_log")
public class UDonateLogController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	DonateLogService donateLogService;
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	HelpMsgMapper helpMsgMapper;
	@Autowired
	DonateLogMapper donateLogMapper;
	/**
	* 根据查询条件分页查询捐助记录数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(DonateLog model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		model.setUid(login.getId());//用户ID等于当前登录id
		return donateLogService.getDataListCount(model,CommonVal.pageSize,login);//分页查询数据总数
	}
	/**
	* 返回捐助记录列表jsp页面
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		UserMsg userMsg = userMsgMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user",userMsg);
		return "user/donate_log/list";
	}
	/**
	* 根据查询条件分页查询捐助记录数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(DonateLog model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		model.setUid(login.getId());//用户ID等于当前登录id
		return donateLogService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	删除捐助记录接口
	*/
	@RequestMapping("del1")
	@ResponseBody
	public Object del1(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		donateLogService.delete(id);
		rs.put("code",1);
		rs.put("msg","删除成功");
		return rs;
	}
}
