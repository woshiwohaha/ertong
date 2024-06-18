package com.child.controller.index;

import com.child.dao.NewsMsgMapper;
import com.child.model.NewsMsg;
import com.child.model.NewsMsgExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("index/news_search")
public class IndexNewsSearchController {

    @Autowired
    NewsMsgMapper newsMsgMapper;

    @RequestMapping("")
    public Object index(ModelMap modelMap, HttpServletRequest request){
        return "index/news_search";}

    //获取新闻列表数据
    @RequestMapping("queryNewsMsgList")
    @ResponseBody
    public Object queryNewsMsgList(HttpServletRequest request,Integer page,String newsName){
        NewsMsgExample qe=new NewsMsgExample();
        NewsMsgExample.Criteria qc= qe.createCriteria();
        if (newsName!=null && newsName.trim().equals("")==false){
            qc.andNewsNameLike("%"+newsName+"%");
        }
        qe.setOrderByClause("id desc");
        int pageSize=6;
        int count = (int) newsMsgMapper.countByExample(qe);
        int totalPage = 0;
        if (page != null){
            if((count>0)&&(count % pageSize) == 0){
                totalPage=count / pageSize;
            }else {
                totalPage=(count / pageSize)+1;
            }
            qe.setPageRows(pageSize);
            qe.setStartRow((page-1)*pageSize);
        }
        List<NewsMsg> ql=newsMsgMapper.selectByExample(qe);
        List<Map<String,Object>> qlist=new ArrayList<>();
        for (NewsMsg tmp:ql){
            Map<String,Object> amap=new HashMap<>();
            amap.put("model",tmp);
            qlist.add(amap);
        }
        Map<String,Object> rs=new HashMap<>();
        rs.put("count",count);
        rs.put("totalPage",totalPage);
        rs.put("list",qlist);
        rs.put("pageSize",pageSize);
        return rs;
    }
}
