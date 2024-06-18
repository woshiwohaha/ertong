package com.child.controller.index;

import com.child.dao.ActMsgMapper;
import com.child.model.ActMsg;
import com.child.model.ActMsgExample;
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
@RequestMapping("index/act_search")
public class IndexActSearchController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    DecimalFormat df = new DecimalFormat("#.00");

    @Autowired
    ActMsgMapper actMsgMapper;

    //志愿活动搜索页面入口
    @RequestMapping("")
    public Object index(ModelMap modelMap, HttpServletRequest request) {
        return "index/act_search";
    }

    //获取志愿活动列表数据
    @RequestMapping("queryActMsgList")
    @ResponseBody
    public Object queryActMsgList(HttpServletRequest request, Integer page, String actName) {
        ActMsgExample qe = new ActMsgExample();
        ActMsgExample.Criteria qc = qe.createCriteria();
        //查询通过的活动
        qc.andActStatusEqualTo(1);
        if (actName != null && actName.trim().equals("") == false) {
            qc.andActNameLike("%" + actName + "%");
        }
        qe.setOrderByClause("id desc");
        int pageSize = 10;
        int count = (int) actMsgMapper.countByExample(qe);
        int totalPage = 0;
        if (page != null) {
            if ((count > 0) && (count % pageSize) == 0) {
                totalPage = count / pageSize;
            } else {
                totalPage = (count / pageSize) + 1;
            }
            //设置每页的数量
            qe.setPageRows(pageSize);
            //设置第几页
            qe.setStartRow((page - 1) * pageSize);
        }
        List<ActMsg> ql = actMsgMapper.selectByExample(qe);
        List<Map<String, Object>> qlList = new ArrayList<>();
        for (ActMsg tmp : ql) {
            Map<String, Object> amap = new HashMap<>();
            amap.put("model", tmp);
            qlList.add(amap);
        }
        Map<String, Object> rs = new HashMap<>();
        rs.put("count", count);
        rs.put("totalPage", totalPage);
        rs.put("list", qlList);
        rs.put("pageSize", pageSize);

        return rs;
    }
}
