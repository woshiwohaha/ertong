package com.child.controller.index;

import com.child.controller.LoginModel;
import com.child.dao.AdminMsgMapper;
import com.child.dao.NewsDisMapper;
import com.child.dao.NewsMsgMapper;
import com.child.dao.UserMsgMapper;
import com.child.model.*;
import com.child.util.CommonVal;
import com.child.util.FileUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import toolgood.words.StringSearch;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("index/news_detail")
public class IndexNewsDetailController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	AdminMsgMapper adminMsgMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	NewsMsgMapper newsMsgMapper;
	@Autowired
	NewsDisMapper newsDisMapper;
	//新闻详情页面入口
	@RequestMapping("")
	public Object index(ModelMap modelMap,Integer id, HttpServletRequest request) {
		NewsMsg newsMsg = newsMsgMapper.selectByPrimaryKey(id);//查询新闻
		if(newsMsg==null){
			newsMsg = new NewsMsg();
		}
		Map<String,Object> dataDetail = new HashMap<String,Object>();
		dataDetail.put("model",newsMsg);
		//解释发布人
		AdminMsg aidT = adminMsgMapper.selectByPrimaryKey(newsMsg.getAid());
		if(aidT==null){
			aidT = new AdminMsg();
		}
		dataDetail.put("aidT",aidT);
		modelMap.addAttribute("newsMsgDetail",dataDetail);
		return "index/news_detail";
	}
	//分页查询新闻评论列表接口
	@RequestMapping("getNewsDis")
	@ResponseBody
	public Object getNewsDis(HttpServletRequest request,Integer page,Integer id){
		Map<String,Object> rs  = new HashMap<String,Object>();
		Integer pageSize=8;
		NewsDisExample te = new NewsDisExample();
		NewsDisExample.Criteria tc = te.createCriteria();
		tc.andNidEqualTo(id);
		te.setOrderByClause("id desc");
		int count = (int)newsDisMapper.countByExample(te);
		int totalPage = 0;
		if ((page != null) && (pageSize != null)) { //分页
			if ((count > 0) && ((count % pageSize) == 0)) {
				totalPage = count / pageSize;
			} else {
				totalPage = (count / pageSize) + 1;
			}
			te.setPageRows(pageSize);//设置每页数量
			te.setStartRow((page - 1) * pageSize);//设置当前第几页
		}
		List<NewsDis> tl = newsDisMapper.selectByExample(te);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(NewsDis t:tl){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("model",t);
			UserMsg uidT=userMsgMapper.selectByPrimaryKey(t.getUid());
			map.put("uidT",uidT);
			list.add(map);
		}
		rs.put("list",list);
		rs.put("count",count);
		rs.put("totalPage",totalPage);
		rs.put("pageSize",pageSize);
		return rs;
	}
	//提交新闻评论接口
	@RequestMapping("submitNewsDis")
	@ResponseBody
	public Object submitNewsDis(HttpServletRequest request,Integer id,String ccontent){
		Map<String,Object> rs  = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		if(login==null||login.getLoginType()!=2){
			rs.put("code",0);
			rs.put("msg","尚未登录");
			return rs;
		}
		if(ccontent==null||ccontent.trim().equals("")){
			rs.put("code",0);
			rs.put("msg","请输入新闻评论内容");
			return rs;
		}

		//敏感词屏蔽
		String path = Thread.currentThread().getContextClassLoader().getResource("static/mgc.txt").getPath();
		List<String> readTxt = FileUntil.readTxt(path);
		StringSearch search =new StringSearch();
		search.SetKeywords(readTxt);
		ccontent=search.Replace(ccontent);
		System.out.println("a的结果为:"+ccontent);

		NewsDis newsDis = new NewsDis();
		newsDis.setContent(ccontent);
		newsDis.setNid(id);//新闻id
		newsDis.setUid(login.getId());//登录id
		newsDis.setCreateTime(sdf1.format(new Date()));//当前时间格式
		newsDisMapper.insertSelective(newsDis);
		rs.put("code",1);
		rs.put("msg","新闻评论成功");
		return rs;
	}
}
