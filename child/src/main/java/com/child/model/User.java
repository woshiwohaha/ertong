package com.child.model;

import com.child.util.ExcelImport;
import lombok.Data;

@Data
public class User {
    //返回第几行的数据 行数
    private Integer rowNum;
    @ExcelImport(value = "登录名",unique = true)
    private String loginName;//登录名
    @ExcelImport(value = "密码",required = true)
    private String password;//密码
    @ExcelImport(value = "昵称",required = true)
    private String realName;//昵称
    @ExcelImport(value = "联系电话",required = true)
    private String celPhone;//联系电话
    @ExcelImport(value = "地址",required = true)
    private String address;//地址
    @ExcelImport(value = "注册时间",required = true)
    private String createTime;//注册时间
    private String rowTips;//错误提示
}
