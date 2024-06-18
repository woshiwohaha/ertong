package com.child.controller.user;

import com.child.controller.LoginModel;
import com.child.dao.UserMsgMapper;
import com.child.model.UserMsg;
import com.child.service.UserMsgService;
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
@RequestMapping("/user/user_msg")
public class UUserMsgController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	UserMsgService userMsgService;
	@Autowired
	UserMsgMapper userMsgMapper;
	/**
	进入用户详情页
	*/
	@RequestMapping("detail")
	public Object detail(ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		UserMsg model = new UserMsg();
		model.setId(login.getId());
		UserMsg preModel = userMsgMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("detail",userMsgService.getUserMsgModel(preModel,login));
		return "user/personal";
	}
	/**
	进入修改页面
	*/
	@RequestMapping("update1")
	public String update1(ModelMap modelMap,UserMsg model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		UserMsg data = userMsgMapper.selectByPrimaryKey(model.getId());
		modelMap.addAttribute("data",data);
		return "user/user_msg/update1_page";
	}
	/**
	修改提交信息接口
	*/
	@RequestMapping("update1_submit")
	@ResponseBody
	public Object update1_submit(UserMsg model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = userMsgService.update1(model,login);//执行修改操作
		if(msg.equals("")){
			rs.put("code",1);
			rs.put("msg","修改成功");
			return rs;
		}
		rs.put("code",0);
		rs.put("msg",msg);
		return rs;
	}
}
