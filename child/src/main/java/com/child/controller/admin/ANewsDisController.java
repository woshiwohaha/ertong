package com.child.controller.admin;

import com.child.controller.LoginModel;
import com.child.dao.AdminMsgMapper;
import com.child.dao.NewsDisMapper;
import com.child.dao.NewsMsgMapper;
import com.child.dao.UserMsgMapper;
import com.child.model.AdminMsg;
import com.child.model.NewsDis;
import com.child.service.NewsDisService;
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
@RequestMapping("/admin/news_dis")
public class ANewsDisController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	NewsDisService newsDisService;
	@Autowired
	AdminMsgMapper adminMsgMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	NewsMsgMapper newsMsgMapper;
	@Autowired
	NewsDisMapper newsDisMapper;
	/**
	* 根据查询条件分页查询新闻评论数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(NewsDis model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return newsDisService.getDataListCount(model,CommonVal.pageSize,login);//分页查询数据总数
	}
	/**
	* 返回新闻评论列表jsp页面
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		AdminMsg adminMsg = adminMsgMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user",adminMsg);
		return "admin/news_dis/list";
	}
	/**
	* 根据查询条件分页查询新闻评论数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(NewsDis model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return newsDisService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	删除新闻评论接口
	*/
	@RequestMapping("del")
	@ResponseBody
	public Object del(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		newsDisService.delete(id);
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
			rs.put("msg","请选择新闻评论");
			return rs;
		}
		String [] idsplit = ids.split(",");
		for(String id:idsplit){
			if(id==null||id.trim().equals("")){
				continue;
			}
			newsDisService.delete(Integer.parseInt(id));
		}
		rs.put("code", 1);
		rs.put("msg","批量删除成功");
		return rs;
	}
}
