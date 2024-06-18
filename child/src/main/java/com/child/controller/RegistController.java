package com.child.controller;

import com.child.dao.UserMsgMapper;
import com.child.model.UserMsg;
import com.child.model.UserMsgExample;
import com.child.util.CommonVal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/regist")
public class RegistController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    UserMsgMapper userMsgMapper;

    /**
     * 进入注册页面接口
     */
    @RequestMapping(value = "user_msg_regist")
    public String user_msg_regist(ModelMap modelMap, String msg) {
        modelMap.addAttribute("msg", msg);
        return "user_msg_regist";
    }

    /**
     * 异步校验登录名
     * @param name
     * @param modelMap
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("checkUserName")
    @ResponseBody
    public Object chkUserName(String name, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> rs = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        //验证用户名是否存在
        UserMsgExample te = new UserMsgExample();
        UserMsgExample.Criteria tc = te.createCriteria();
        tc.andLoginNameEqualTo(name);
        int count = (int) userMsgMapper.countByExample(te);
        if (name == null || name.equals("")) {
            rs.put("code", 0);
            rs.put("msgname", "请填入登录名");
            return rs;
        }
        else if (count>0){
			rs.put("code", 0);
			rs.put("msgname", "该账号已存在");
			return rs;
		}else {
			rs.put("code", 1);
			rs.put("msgname", "√");
			return rs;
		}
    }

    /**
     * 异步校验密码
     * @param password
     * @param modelMap
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("checkPassword")
    @ResponseBody
    public Object checkPassword(String password, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> rs = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        if (password == null || password.equals("")) {
            rs.put("code", 0);
            rs.put("msgpassword", "请填入密码");
            return rs;
        }else {
            rs.put("code", 1);
            rs.put("msgpassword", "√");
            return rs;
        }
    }

    /**
     * 异步校验昵称
     * @param realName
     * @param modelMap
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("checkRealName")
    @ResponseBody
    public Object checkRealName(String realName, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> rs = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        if (realName == null || realName.equals("")) {
            rs.put("code", 0);
            rs.put("msgrealName", "请填入昵称");
            return rs;
        }else{
            rs.put("code", 1);
            rs.put("msgrealName", "√");
            return rs;
        }
    }

    /**
     * 异步校验电话
     * @param celPhone
     * @param modelMap
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("checkCelPhone")
    @ResponseBody
    public Object checkCelPhone(String celPhone, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> rs = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        if (celPhone == null || celPhone.equals("")) {
            rs.put("code", 0);
            rs.put("msgcelPhone", "请填入联系电话");
            return rs;
        }
        if (celPhone != null && celPhone.trim().equals("") == false) {
            Pattern p = Pattern.compile("^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
            Matcher m = p.matcher(celPhone);
            if (m.matches() == false) {
                ;
                rs.put("code", 0);
                rs.put("msgcelPhone", "请填入正确的联系电话");
                return rs;
            }
        }
        rs.put("code", 1);
        rs.put("msgcelPhone", "√");
        return rs;
    }


    @RequestMapping("checkAddress")
    @ResponseBody
    public Object checkAddress(String address, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> rs = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        if (address == null || address.equals("")) {
            rs.put("code", 0);
            rs.put("msgaddress", "请填入地址");
            return rs;
        }else{
            rs.put("code", 1);
            rs.put("msgaddress", "√");
            return rs;
        }
    }

    /**
     * 提交注册信息接口
     */
    @RequestMapping("userMsgRegistSubmit")
    @ResponseBody
    public Object userMsgRegistSubmit(String imgCode, String name, String password, String realName, String celPhone, String address, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> rs = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        if (imgCode != null && !imgCode.toLowerCase().equals(request.getSession().getAttribute(CommonVal.code).toString().toLowerCase())) {//当前验证码存储session的值是否和输入的值一致
            rs.put("code", 0);
            rs.put("msg", "图片验证码错误");
            return rs;
        }
        if (name == null || name.equals("")) {
            rs.put("code", 0);
            rs.put("msg", "请填入登录名");
            return rs;
        }
        if (name != null) {
            UserMsgExample te = new UserMsgExample();
            UserMsgExample.Criteria tc = te.createCriteria();
            tc.andLoginNameEqualTo(name);

            int count = (int) userMsgMapper.countByExample(te);
            if (count > 0) {
                rs.put("code", 0);
                rs.put("msg", "该账号已被注册，请用该账号登录");
                return rs;
            }
        }
        if (password == null || password.equals("")) {
            rs.put("code", 0);
            rs.put("msg", "请填入密码");
            return rs;
        }
        if (realName == null || realName.equals("")) {
            rs.put("code", 0);
            rs.put("msg", "请填入昵称");
            return rs;
        }
        if (celPhone == null || celPhone.equals("")) {
            rs.put("code", 0);
            rs.put("msg", "请填入联系电话");
            return rs;
        }
        if (celPhone != null && celPhone.trim().equals("") == false) {
            Pattern p = Pattern.compile("^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
            Matcher m = p.matcher(celPhone);
            if (m.matches() == false) {
                ;
                rs.put("code", 0);
                rs.put("msg", "请填入正确的联系电话");
                return rs;
            }
        }
        if (address == null || address.equals("")) {
            rs.put("code", 0);
            rs.put("msg", "请填入地址");
            return rs;
        }
        UserMsg model = new UserMsg();
        model.setLoginName(name);
        model.setPassword(password);
        model.setRealName(realName);
        model.setCelPhone(celPhone);
        model.setAddress(address);
        model.setCreateTime(sdf1.format(new Date()));//当前时间格式
        userMsgMapper.insertSelective(model);//注册成功，插入该账号进数据库，并返回提示
        rs.put("code", 1);
        rs.put("msg", "注册成功，请使用该账号密码登录");
        return rs;
    }
}
