package com.child.controller.user;

import com.child.controller.LoginModel;
import com.child.dao.UserMsgMapper;
import com.child.model.UserMsg;
import com.child.util.CommonVal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/user/index")
public class UIndexController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	@Autowired
	UserMsgMapper userMsgMapper;
	/**
	用户角色进入管理首页接口
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		UserMsg user = userMsgMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user", user);
		modelMap.addAttribute("roleName", "用户");
		modelMap.addAttribute("login", login);
		return "user/index";
	}
}
