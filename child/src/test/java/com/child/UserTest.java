package com.child;

import com.child.controller.LoginModel;
import com.child.dao.UserMsgMapper;
import com.child.model.UserMsg;
import com.child.model.UserMsgExample;
import com.child.service.impl.UserMsgServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    UserMsgMapper userMsgMapper;

    @Test
    public void test1(){
        UserMsg model=new UserMsg();
        LoginModel loginModel=new LoginModel();
        model.setLoginName("user6");
        model.setPassword("123");
        model.setAddress("建安");
        model.setCelPhone("13267661676");
        model.setRealName("小花");
        if (model.getLoginName()==null||model.getLoginName().equals("")){
            System.out.println("登录名必填");
            return;
        }
        if (model.getLoginName()!=null) {
            UserMsgExample te = new UserMsgExample();
            UserMsgExample.Criteria tc = te.createCriteria();
            tc.andLoginNameEqualTo(model.getLoginName());
            int count = (int) userMsgMapper.countByExample(te);
            if (count > 0) {
                System.out.println("已存在登录名");
                return;
            }
        }
        if(model.getPassword()==null||model.getPassword().equals("")){
            System.out.println("密码为必填属性");
            return;
        }
        if(model.getRealName()==null||model.getRealName().equals("")){
            System.out.println("昵称为必填属性"); return ;
        }
        if(model.getCelPhone()==null||model.getCelPhone().equals("")){
            System.out.println("联系电话为必填属性");return ;
        }
        if(model.getCelPhone()!=null){
            Pattern p = Pattern.compile("^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
            Matcher m = p.matcher(model.getCelPhone());
            if( m.matches()==false){
                System.out.println("请输入正确的联系电话"); return ;
            }
        }
        if(model.getAddress()==null||model.getAddress().equals("")){
            System.out.println("地址为必填属性");return ;
        }
        model.setCreateTime(sdf1.format(new Date()));
        userMsgMapper.insertSelective(model);
        System.out.println("正确");

    }
}
