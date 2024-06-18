package com.child.controller.index;

import com.child.controller.LoginModel;
import com.child.dao.DonateLogMapper;
import com.child.dao.HelpMsgMapper;
import com.child.dao.UserMsgMapper;
import com.child.model.DonateLog;
import com.child.model.DonateLogExample;
import com.child.model.HelpMsg;
import com.child.model.UserMsg;
import com.child.util.CommonVal;
import com.child.util.DataListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("index/help_detail")
public class IndexHelpDetailController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	HelpMsgMapper helpMsgMapper;
	@Autowired
	DonateLogMapper donateLogMapper;
	//求助详情页面入口
	@RequestMapping("")
	public Object index(ModelMap modelMap,Integer id, HttpServletRequest request) {
		HelpMsg helpMsg = helpMsgMapper.selectByPrimaryKey(id);//查询求助信息
		if(helpMsg==null){
			helpMsg = new HelpMsg();
		}
		Map<String,Object> dataDetail = new HashMap<String,Object>();
		dataDetail.put("model",helpMsg);
		dataDetail.put("hsex",DataListUtils.getSexNameById(helpMsg.getHsex()+""));
		modelMap.addAttribute("helpMsgDetail",dataDetail);
		DonateLogExample de = new DonateLogExample();
		DonateLogExample.Criteria dc = de.createCriteria();
		dc.andHidEqualTo(id);
		de.setOrderByClause("id desc");
		List<DonateLog> dl=donateLogMapper.selectByExample(de);
		List<Map<String,Object>> dlList = new ArrayList<Map<String,Object>>();
		for(DonateLog tmp:dl){
			Map<String,Object> amap = new HashMap<String,Object>();
			//解释用户ID
			UserMsg uidT = userMsgMapper.selectByPrimaryKey(tmp.getUid());
			if(uidT==null){
				uidT = new UserMsg();
			}
			amap.put("uid",uidT.getLoginName());
			amap.put("model",tmp);
			dlList.add(amap);
		}
		modelMap.addAttribute("dl",dlList);
		return "index/help_detail";
	}
	//提交捐助记录接口
	@RequestMapping("submitDonateLog")
	@ResponseBody
	public Object submitDonateLog(HttpServletRequest request,DonateLog donateLog){
		Map<String,Object> rs = new HashMap<String,Object>();
		return addDonateLog(request,donateLog);
	}
	public Map<String,Object> addDonateLog(HttpServletRequest request,DonateLog donateLog){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		Map<String,Object> check1  = checkDonateLog(request,donateLog);
		if(check1.get("code").toString().equals("0")){
			return check1;
		}
		donateLog.setUid(login.getId());//登录id
		UserMsg usr = userMsgMapper.selectByPrimaryKey(login.getId());
		donateLog.setContactMsg(usr.getRealName()+" "+usr.getCelPhone()+" "+usr.getAddress());
		donateLog.setCreateTime(sdf1.format(new Date()));//当前时间格式
		donateLogMapper.insertSelective(donateLog);
		rs.put("code",1);
		rs.put("msg","提交捐助记录成功");
		return rs;
	}
	//数据校验
	public Map<String,Object> checkDonateLog(HttpServletRequest request,DonateLog donateLog){
		Map<String,Object> rs = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		if(login==null||login.getLoginType()!=2){
			rs.put("code",0);
			rs.put("msg","尚未登录");
			return rs;
		}
		donateLog.setUid(login.getId());
		rs.put("code",1);
		rs.put("msg","校验成功");
		return rs;
	}
}
