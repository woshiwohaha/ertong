package com.child.controller.admin;

import com.child.controller.LoginModel;
import com.child.dao.AdminMsgMapper;
import com.child.dao.UserMsgMapper;
import com.child.model.AdminMsg;
import com.child.model.User;
import com.child.model.UserMsg;
import com.child.model.UserMsgExample;
import com.child.service.UserMsgService;
import com.child.util.CommonVal;
import com.child.util.ExcelUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/admin/user_msg")
public class AUserMsgController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	UserMsgService userMsgService;
	@Autowired
	AdminMsgMapper adminMsgMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	/**
	* 根据查询条件分页查询用户数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(UserMsg model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return userMsgService.getDataListCount(model,CommonVal.pageSize,login);//分页查询数据总数
	}
	/**
	* 返回用户列表jsp页面
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		AdminMsg adminMsg = adminMsgMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user",adminMsg);
		return "admin/user_msg/list";
	}
	/**
	* 根据查询条件分页查询用户数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(UserMsg model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return userMsgService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	进入新增页面
	*/
	@RequestMapping("add")
	public String add(ModelMap modelMap,UserMsg model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		modelMap.addAttribute("data",model);
		return "admin/user_msg/add_page";
	}

	

	/**
	新增提交信息接口
	*/
	@RequestMapping("add_submit")
	@ResponseBody
	public Object add_submit(UserMsg model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = userMsgService.add(model,login);//执行添加操作
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
	public String update(ModelMap modelMap,UserMsg model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		UserMsg data = userMsgMapper.selectByPrimaryKey(model.getId());
		modelMap.addAttribute("data",data);
		return "admin/user_msg/update_page";
	}
	/**
	修改提交信息接口
	*/
	@RequestMapping("update_submit")
	@ResponseBody
	public Object update_submit(UserMsg model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = userMsgService.update(model,login);//执行修改操作
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
	 一键导出
	 */
	@RequestMapping("export")
	@ResponseBody
	public Object export(HttpServletResponse response){
		UserMsgExample se = new UserMsgExample();
		UserMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		List<UserMsg> userMsgs = userMsgMapper.selectByExample(se);
		System.out.println(userMsgs);
		List<Object> head = Arrays.asList("登录名", "密码", "昵称", "电话","地址","创建时间");
		ArrayList<List<Object>> data = new ArrayList<>();
		data.add(head);
		for (UserMsg u:userMsgs){
			ArrayList<Object> user1 = new ArrayList<>();
			user1.add(u.getLoginName());
			user1.add(u.getPassword());
			user1.add(u.getRealName());
			user1.add(u.getCelPhone());
			user1.add(u.getAddress());
			user1.add(u.getCreateTime());
			data.add(user1);
		}
		ExcelUtils.export(response,"user",data);
		return null;
	}

	/**
	 * 一键导入
	 * @param file
	 * @throws Exception
	 */
	@RequestMapping("/import")
	@ResponseBody
	public Object import1(@RequestPart("file") MultipartFile file,HttpServletRequest request) throws Exception {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		List<User> users = ExcelUtils.readMultipartFile(file, User.class);

		Map<String,Object> rs = new HashMap<String,Object>();
		int count=0;
		for (User u:users){
			//验证用户名是否存在
			UserMsgExample se = new UserMsgExample();
			UserMsgExample.Criteria sc = se.createCriteria();
			sc.andLoginNameEqualTo(u.getLoginName());
			int count1 = (int) userMsgMapper.countByExample(se);
			if (!(count1>0)){
				if (StringUtils.isBlank(u.getRowTips())){
					UserMsg model=new UserMsg();
					model.setLoginName(u.getLoginName());
					model.setPassword(u.getPassword());
					model.setRealName(u.getRealName());
					model.setCelPhone(u.getCelPhone());
					model.setAddress(u.getAddress());
					model.setCreateTime(u.getCreateTime());
					System.out.println(model);
					String msg = userMsgService.add(model,login);//执行添加操作
					System.out.println(msg);
					count++;
				}
			}
		}
		System.out.println(count);
		String msg="成功导入数据"+count+"条";
		rs.put("code",1);
		rs.put("msg",msg);
		return rs;
	}
	/**
	删除用户接口
	*/
	@RequestMapping("del")
	@ResponseBody
	public Object del(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		userMsgService.delete(id);
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
			rs.put("msg","请选择用户");
			return rs;
		}
		String [] idsplit = ids.split(",");
		for(String id:idsplit){
			if(id==null||id.trim().equals("")){
				continue;
			}
			userMsgService.delete(Integer.parseInt(id));
		}
		rs.put("code", 1);
		rs.put("msg","批量删除成功");
		return rs;
	}
}
