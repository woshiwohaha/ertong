package com.child.controller.admin;

import com.child.controller.LoginModel;
import com.child.dao.AdminMsgMapper;
import com.child.model.AdminMsg;
import com.child.util.CommonVal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/admin/index")
public class AIndexController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	@Autowired
	AdminMsgMapper adminMsgMapper;
	/**
	管理员角色进入管理首页接口
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		AdminMsg user = adminMsgMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user", user);
		modelMap.addAttribute("roleName", "管理员");
		modelMap.addAttribute("login", login);
		return "admin/index";
	}
}
