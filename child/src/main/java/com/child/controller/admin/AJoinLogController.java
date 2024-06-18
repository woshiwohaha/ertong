package com.child.controller.admin;

import com.child.controller.LoginModel;
import com.child.dao.ActMsgMapper;
import com.child.dao.AdminMsgMapper;
import com.child.dao.JoinLogMapper;
import com.child.dao.UserMsgMapper;
import com.child.model.AdminMsg;
import com.child.model.JoinLog;
import com.child.service.ActMsgService;
import com.child.service.JoinLogService;
import com.child.util.CommonVal;
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
@RequestMapping("/admin/join_log")
public class AJoinLogController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	JoinLogService joinLogService;

	@Autowired
	ActMsgService actMsgService;
	@Autowired
	AdminMsgMapper adminMsgMapper;
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
		return joinLogService.getDataListCount(model,CommonVal.pageSize,login);//分页查询数据总数
	}
	/**
	* 返回参加记录列表jsp页面
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,Integer aid,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		AdminMsg adminMsg = adminMsgMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user",adminMsg);
		JoinLog model = new JoinLog();
		model.setAid(aid);
		modelMap.addAttribute("data",model);
		return "admin/join_log/list";
	}
	/**
	* 根据查询条件分页查询参加记录数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(JoinLog model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return joinLogService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	删除参加记录接口
	*/
	@RequestMapping("del")
	@ResponseBody
	public Object del(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		actMsgService.update2(id,login);
		joinLogService.delete(id);

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
			rs.put("msg","请选择参加记录");
			return rs;
		}
		String [] idsplit = ids.split(",");
		for(String id:idsplit){
			if(id==null||id.trim().equals("")){
				continue;
			}
			joinLogService.delete(Integer.parseInt(id));
			actMsgService.update2(Integer.parseInt(id),login);
		}
		rs.put("code", 1);
		rs.put("msg","批量删除成功");
		return rs;
	}
}
