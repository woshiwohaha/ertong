package com.child.controller.admin;

import com.child.controller.LoginModel;
import com.child.dao.ActMsgMapper;
import com.child.dao.AdminMsgMapper;
import com.child.dao.UserMsgMapper;
import com.child.model.ActMsg;
import com.child.model.AdminMsg;
import com.child.service.ActMsgService;
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
@RequestMapping("/admin/act_msg")
public class AActMsgController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	ActMsgService actMsgService;
	@Autowired
	AdminMsgMapper adminMsgMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	ActMsgMapper actMsgMapper;
	public void getList(ModelMap modelMap,LoginModel login){
		modelMap.addAttribute("actStatusList",DataListUtils.getActStatusList());//返回act_status列表
	}
	/**
	* 根据查询条件分页查询志愿活动数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(ActMsg model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
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
		AdminMsg adminMsg = adminMsgMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user",adminMsg);
		getList( modelMap,login);//获取数据列表并返回给前台
		return "admin/act_msg/list";
	}
	/**
	* 根据查询条件分页查询志愿活动数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(ActMsg model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return actMsgService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	查看详情接口
	*/
	@RequestMapping("detail1")
	public Object detail1(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		ActMsg model = new ActMsg();
		model.setId(id);
		ActMsg preModel = actMsgMapper.selectByPrimaryKey(id);
		modelMap.addAttribute("detail", actMsgService.getActMsgModel(preModel,login));
		return "admin/act_msg/detail";
	}
	/**
	进入新增页面
	*/
	@RequestMapping("add")
	public String add(ModelMap modelMap,ActMsg model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		getList( modelMap,login);//获取前台需要用到的数据列表并返回给前台
		modelMap.addAttribute("data",model);
		return "admin/act_msg/add_page";
	}
	/**
	新增提交信息接口
	*/
	@RequestMapping("add_submit")
	@ResponseBody
	public Object add_submit(ActMsg model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = actMsgService.add(model,login);//执行添加操作
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
	public String update(ModelMap modelMap,ActMsg model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		getList( modelMap,login);//获取前台需要用到的数据列表并返回给前台
		ActMsg data = actMsgMapper.selectByPrimaryKey(model.getId());
		if(data.getActDetail()!=null){
			data.setActDetail(data.getActDetail().replaceAll("'","\\\\'"));//wangeditor需要过滤掉'符号，否则初始化可能报错
		}
		modelMap.addAttribute("data",data);
		return "admin/act_msg/update_page";
	}
	/**
	修改提交信息接口
	*/
	@RequestMapping("update_submit")
	@ResponseBody
	public Object update_submit(ActMsg model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = actMsgService.update(model,login);//执行修改操作
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
	@RequestMapping("del")
	@ResponseBody
	public Object del(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		actMsgService.delete(id);
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
			rs.put("msg","请选择志愿活动");
			return rs;
		}
		String [] idsplit = ids.split(",");
		for(String id:idsplit){
			if(id==null||id.trim().equals("")){
				continue;
			}
			actMsgService.delete(Integer.parseInt(id));
		}
		rs.put("code", 1);
		rs.put("msg","批量删除成功");
		return rs;
	}
	@RequestMapping(value = "batch_update1")
	@ResponseBody
	public Object batch_update1(String ids, ModelMap modelMap,
	HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> rs = new HashMap<String, Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		if(ids==null||ids.trim().equals("")){
			rs.put("code", 0);
			rs.put("msg","请选择志愿活动");
			return rs;
		}
		String [] idsplit = ids.split(",");
		for(String id:idsplit){
			if(id==null||id.trim().equals("")){
				continue;
			}
			ActMsg model = actMsgMapper.selectByPrimaryKey(Integer.parseInt(id));
			if(model==null){
				rs.put("code", 0);
				rs.put("msg","该志愿活动已不存在");
				return rs;
			}
			model.setActStatus(1);
			actMsgMapper.updateByPrimaryKey(model);
		}
		rs.put("code", 1);
		rs.put("msg","批量通过成功");
		return rs;
	}
	@RequestMapping(value = "batch_update2")
	@ResponseBody
	public Object batch_update2(String ids, ModelMap modelMap,
	HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> rs = new HashMap<String, Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		if(ids==null||ids.trim().equals("")){
			rs.put("code", 0);
			rs.put("msg","请选择志愿活动");
			return rs;
		}
		String [] idsplit = ids.split(",");
		for(String id:idsplit){
			if(id==null||id.trim().equals("")){
				continue;
			}
			ActMsg model = actMsgMapper.selectByPrimaryKey(Integer.parseInt(id));
			if(model==null){
				rs.put("code", 0);
				rs.put("msg","该志愿活动已不存在");
				return rs;
			}
			model.setActStatus(2);
			actMsgMapper.updateByPrimaryKey(model);
		}
		rs.put("code", 1);
		rs.put("msg","批量不通过成功");
		return rs;
	}
}
