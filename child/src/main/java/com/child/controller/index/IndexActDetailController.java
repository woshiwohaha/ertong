package com.child.controller.index;

import com.child.controller.LoginModel;
import com.child.dao.ActMsgMapper;
import com.child.dao.JoinLogMapper;
import com.child.dao.UserMsgMapper;
import com.child.model.*;
import com.child.util.CommonVal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("index/act_detail")
public class IndexActDetailController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    DecimalFormat df = new DecimalFormat("#.00");
    @Autowired
    UserMsgMapper userMsgMapper;
    @Autowired
    ActMsgMapper actMsgMapper;
    @Autowired
    JoinLogMapper joinLogMapper;

    //志愿活动详情入口
    @RequestMapping("")
    public Object index(ModelMap modelMap, Integer id, HttpServletRequest request){
        ActMsg actMsg=actMsgMapper.selectByPrimaryKey(id);
        if (actMsg==null){
            actMsg=new ActMsg();
        }


        Map<String,Object> dataDetail=new HashMap<>();
        dataDetail.put("model",actMsg);
        modelMap.addAttribute("actMsgDetail",dataDetail);
        LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);


        if (login==null||login.getLoginType()!=2){
            modelMap.addAttribute("user",0);
        }else {
            //判断是否为自己发布的活动
            ActMsgExample ae=new ActMsgExample();
            ActMsgExample.Criteria ac= ae.createCriteria();
            ac.andIdEqualTo(id);
            ac.andUserIdEqualTo(login.getId());
            int count1= (int) actMsgMapper.countByExample(ae);
            //判断是否已参加
            JoinLogExample je = new 	JoinLogExample();
            JoinLogExample.Criteria jc = je.createCriteria();
            jc.andAidEqualTo(id);
            jc.andUidEqualTo(login.getId());
            int count = (int) joinLogMapper.countByExample(je);
            if(count1>0){
                modelMap.addAttribute("user",3);
            }else {
                if(count>0){
                    modelMap.addAttribute("user",1);
                }else{
                    modelMap.addAttribute("user",0);
                }
            }


        }


        return "index/act_detail";
    }

    //提交参加记录接口
    @RequestMapping("submitJoinLog")
    @ResponseBody
    public Object submitJoinLog(HttpServletRequest request, JoinLog joinLog){
        Map<String,Object> rs = new HashMap<String,Object>();
        return addJoinLog(request,joinLog);
    }

    //参加活动具体方法
    public Map<String,Object> addJoinLog(HttpServletRequest request,JoinLog joinLog) {
        LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
        Map<String,Object> rs = new HashMap<String,Object>();
        Map<String,Object> check1  = checkJoinLog(request,joinLog);
        if(check1.get("code").toString().equals("0")){
            return check1;
        }
        ActMsg actMsg = actMsgMapper.selectByPrimaryKey(joinLog.getAid());
        actMsg.setJoinNum(actMsg.getJoinNum()+1);
        actMsgMapper.updateByPrimaryKeySelective(actMsg);
        UserMsg uidT = userMsgMapper.selectByPrimaryKey(joinLog.getUid());//查询用户
        ActMsg aidT = actMsgMapper.selectByPrimaryKey(joinLog.getAid());//查询志愿活动
        if(uidT!=null){
            joinLog.setUrealName(uidT.getRealName());//赋值uidT的昵称
        }
        if(uidT!=null){
            joinLog.setUcelPhone(uidT.getCelPhone());//赋值uidT的联系电话
        }
        if(aidT!=null){
            joinLog.setAactTime(aidT.getActTime());//赋值aidT的活动时间
        }
        if(aidT!=null){
            joinLog.setAaddress(aidT.getAddress());//赋值aidT的活动地点
        }
        if(actMsg.getUserId()!=null&&actMsg.getUserId().equals(uidT.getId())){
            rs.put("code",0);
            rs.put("msg","不能参加自己发布的活动");
            return rs;
        }

        JoinLogExample je = new 	JoinLogExample();
        JoinLogExample.Criteria jc = je.createCriteria();
        jc.andAidEqualTo(aidT.getId());
        jc.andUidEqualTo(login.getId());
        int count = (int) joinLogMapper.countByExample(je);
        if(count>0){
            rs.put("code",0);
            rs.put("msg","您已参加过该活动");
            return rs;
        }
        joinLog.setUid(login.getId());//登录id
        joinLog.setCreateTime(sdf1.format(new Date()));//当前时间格式
        joinLogMapper.insertSelective(joinLog);
        rs.put("code",1);
        rs.put("msg","提交参加记录成功");
        return rs;
    }

        //数据校验
    public Map<String,Object> checkJoinLog(HttpServletRequest request,JoinLog joinLog) {
        Map<String,Object> rs=new HashMap<>();
        LoginModel login= (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
        if (login==null||login.getLoginType()!=2){
            rs.put("code",0);
            rs.put("msg","您尚未登录");
            return rs;
        }
        joinLog.setUid(login.getId());
        ActMsg actMsg= actMsgMapper.selectByPrimaryKey(joinLog.getAid());
        rs.put("code",1);
        rs.put("msg","成功");
        return rs;
    }
    }
