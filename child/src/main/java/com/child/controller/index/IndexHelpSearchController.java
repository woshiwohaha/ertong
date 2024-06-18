package com.child.controller.index;

import com.child.dao.HelpMsgMapper;
import com.child.model.HelpMsg;
import com.child.model.HelpMsgExample;
import com.child.util.DataListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("index/help_search")
public class IndexHelpSearchController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	HelpMsgMapper helpMsgMapper;
	//求助搜索页面入口
	@RequestMapping("")
	public Object index(ModelMap modelMap, HttpServletRequest request) {
		modelMap.addAttribute("dataSexList",DataListUtils.getSexList());
		return "index/help_search";
	}
	//获取求助信息列表数据
	@RequestMapping("queryHelpMsgList")
	@ResponseBody
	public Object queryHelpMsgList(HttpServletRequest request,Integer page,String hname,Integer hsex){
		HelpMsgExample qe = new HelpMsgExample();
		HelpMsgExample.Criteria qc = qe.createCriteria();
		if(hname!=null&&hname.trim().equals("")==false){
			qc.andHnameLike("%"+hname+"%");
		}
		if(hsex!=null){
			qc.andHsexEqualTo(hsex);
		}
		qe.setOrderByClause("id desc");
		int pageSize=10;
		int count = (int) helpMsgMapper.countByExample(qe);
		int totalPage = 0;
		if (page != null) {
			if ((count > 0) && ((count % pageSize) == 0)) {
				totalPage = count / pageSize;
			} else {
				totalPage = (count / pageSize) + 1;
			}
			qe.setPageRows(pageSize);//每页数量
			qe.setStartRow((page - 1) * pageSize);//第几页
		}
		List<HelpMsg> ql=helpMsgMapper.selectByExample(qe);
		List<Map<String,Object>> qlList = new ArrayList<Map<String,Object>>();
		for(HelpMsg tmp:ql){
			Map<String,Object> amap = new HashMap<String,Object>();
			amap.put("hsex",DataListUtils.getSexNameById(tmp.getHsex()+""));
			amap.put("model",tmp);
			qlList.add(amap);
		}
		Map<String,Object> rs = new HashMap<String,Object>();
		rs.put("count",count);
		rs.put("totalPage",totalPage);
		rs.put("list",qlList);
		rs.put("pageSize",pageSize);
		return rs;
	}
}
