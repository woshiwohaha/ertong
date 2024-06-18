package com.child.controller.index;

import com.child.dao.ActMsgMapper;
import com.child.dao.BannerMapper;
import com.child.dao.HelpMsgMapper;
import com.child.dao.NewsMsgMapper;
import com.child.model.*;
import com.child.util.DataListUtils;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("index/index")
public class IndexIndexController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	NewsMsgMapper newsMsgMapper;
	@Autowired
	ActMsgMapper actMsgMapper;
	@Autowired
	HelpMsgMapper helpMsgMapper;
	@Autowired
	BannerMapper bannerMapper;
	//首页页面入口
	@RequestMapping("")
	public Object index(ModelMap modelMap, HttpServletRequest request) {
		NewsMsgExample ne = new NewsMsgExample();
		NewsMsgExample.Criteria nc = ne.createCriteria();
		ne.setOrderByClause("id desc");
		int nlSize=8;
		ne.setPageRows(nlSize);//每页数量
		ne.setStartRow(0);//第一页
		List<NewsMsg> nl=newsMsgMapper.selectByExample(ne);
		List<Map<String,Object>> nlList = new ArrayList<Map<String,Object>>();
		for(NewsMsg tmp:nl){
			Map<String,Object> amap = new HashMap<String,Object>();
			amap.put("model",tmp);
			nlList.add(amap);
		}
		modelMap.addAttribute("nl",nlList);
		ActMsgExample ae = new ActMsgExample();
		ActMsgExample.Criteria ac = ae.createCriteria();
		ac.andActStatusEqualTo(1);//状态等于通过
		ae.setOrderByClause("id desc");
		int alSize=8;
		ae.setPageRows(alSize);//每页数量
		ae.setStartRow(0);//第一页
		List<ActMsg> al=actMsgMapper.selectByExample(ae);
		List<Map<String,Object>> alList = new ArrayList<Map<String,Object>>();
		for(ActMsg tmp:al){
			Map<String,Object> amap = new HashMap<String,Object>();
			amap.put("actStatus",DataListUtils.getActStatusNameById(tmp.getActStatus()+""));
			amap.put("model",tmp);
			alList.add(amap);
		}
		modelMap.addAttribute("al",alList);
		HelpMsgExample he = new HelpMsgExample();
		HelpMsgExample.Criteria hc = he.createCriteria();
		he.setOrderByClause("id desc");
		int hlSize=8;
		he.setPageRows(hlSize);//每页数量
		he.setStartRow(0);//第一页
		List<HelpMsg> hl=helpMsgMapper.selectByExample(he);
		List<Map<String,Object>> hlList = new ArrayList<Map<String,Object>>();
		for(HelpMsg tmp:hl){
			Map<String,Object> amap = new HashMap<String,Object>();
			amap.put("hsex",DataListUtils.getSexNameById(tmp.getHsex()+""));
			amap.put("model",tmp);
			hlList.add(amap);
		}
		modelMap.addAttribute("hl",hlList);

		BannerExample be=new BannerExample();
		BannerExample.Criteria bc= be.createCriteria();
		be.setOrderByClause("id desc");
		int blSize=8;
		be.setPageRows(blSize);
		be.setStartRow(0);
		List<Banner> bl=bannerMapper.selectByExample(be);
		List<Map<String,Object>> blList=new ArrayList<>();
		for (Banner tmp:bl){
			Map<String,Object> amap=new HashMap<>();
			amap.put("model",tmp);
			blList.add(amap);
		}
		System.out.println(blList);
		modelMap.addAttribute("bl",blList);
		return "index/index";


//		BannerExample be = new BannerExample();
//		BannerExample.Criteria bc = be.createCriteria();
//		be.setOrderByClause("id desc");
//		int blSize=8;
//		be.setPageRows(blSize);//每页数量
//		be.setStartRow(0);//第一页
//		List<Banner> bl=bannerMapper.selectByExample(be);
//		List<Map<String,Object>> blList = new ArrayList<Map<String,Object>>();
//		for(Banner tmp:bl){
//			Map<String,Object> amap = new HashMap<String,Object>();
//			amap.put("model",tmp);
//			blList.add(amap);
//		}
//		modelMap.addAttribute("bl",blList);
//		return "index/index";
	}
}
