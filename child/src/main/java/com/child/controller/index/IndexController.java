package com.child.controller.index;

import com.child.controller.LoginModel;
import com.child.util.CommonVal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("index")
public class IndexController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	//留守儿童爱心成长守护平台入口
	@RequestMapping(value = "")
	public String index(ModelMap modelMap, String childPageUrl,  HttpServletRequest request) {

		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		modelMap.addAttribute("childPageUrl",childPageUrl);
		modelMap.addAttribute("login",login);
		return "index";
	}
}
