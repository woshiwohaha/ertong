package com.child.controller.admin;

import com.child.controller.LoginModel;
import com.child.dao.AdminMsgMapper;
import com.child.dao.HelpMsgMapper;
import com.child.model.AdminMsg;
import com.child.model.HelpMsg;
import com.child.service.HelpMsgService;
import com.child.util.CommonVal;
import com.child.util.DataListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping("/admin/help_msg")
public class AHelpMsgController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	HelpMsgService helpMsgService;
	@Autowired
	AdminMsgMapper adminMsgMapper;
	@Autowired
	HelpMsgMapper helpMsgMapper;
	public void getList(ModelMap modelMap,LoginModel login){
		modelMap.addAttribute("sexList",DataListUtils.getSexList());//返回sex列表
	}
	/**
	* 根据查询条件分页查询求助信息数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(HelpMsg model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return helpMsgService.getDataListCount(model,CommonVal.pageSize,login);//分页查询数据总数
	}
	/**
	* 返回求助信息列表jsp页面
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		AdminMsg adminMsg = adminMsgMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user",adminMsg);
		getList( modelMap,login);//获取数据列表并返回给前台
		return "admin/help_msg/list";
	}
	/**
	* 根据查询条件分页查询求助信息数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(HelpMsg model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return helpMsgService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	进入新增页面
	*/
	@RequestMapping("add")
	public String add(ModelMap modelMap,HelpMsg model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		getList( modelMap,login);//获取前台需要用到的数据列表并返回给前台
		modelMap.addAttribute("data",model);
		return "admin/help_msg/add_page";
	}
	/**
	新增提交信息接口
	*/
	@RequestMapping("add_submit")
	@ResponseBody
	public Object add_submit(HelpMsg model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = helpMsgService.add(model,login);//执行添加操作
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
	@RequestMapping("update")
	public String update(ModelMap modelMap,HelpMsg model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		getList( modelMap,login);//获取前台需要用到的数据列表并返回给前台
		HelpMsg data = helpMsgMapper.selectByPrimaryKey(model.getId());
		modelMap.addAttribute("data",data);
		return "admin/help_msg/update_page";
	}
	/**
	修改提交信息接口
	*/
	@RequestMapping("update_submit")
	@ResponseBody
	public Object update_submit(HelpMsg model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = helpMsgService.update(model,login);//执行修改操作
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
	删除求助信息接口
	*/
	@RequestMapping("del")
	@ResponseBody
	public Object del(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		helpMsgService.delete(id);
		rs.put("code",1);
		rs.put("msg","删除成功");
		return rs;
	}
	@RequestMapping(value = "batch_delete")
	@ResponseBody
	public Object batch_delete(String ids, ModelMap modelMap,
	HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> rs = new HashMap<String, Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		if(ids==null||ids.trim().equals("")){
			rs.put("code", 0);
			rs.put("msg","请选择求助信息");
			return rs;
		}
		String [] idsplit = ids.split(",");
		for(String id:idsplit){
			if(id==null||id.trim().equals("")){
				continue;
			}
			helpMsgService.delete(Integer.parseInt(id));
		}
		rs.put("code", 1);
		rs.put("msg","批量删除成功");
		return rs;
	}
}
