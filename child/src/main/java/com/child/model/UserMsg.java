package com.child.model;
public class UserMsg {
	private Integer id;//ID
	private String loginName;//登录名
	private String password;//密码
	private String realName;//昵称
	private String celPhone;//联系电话
	private String address;//地址
	private String createTime;//注册时间
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getLoginName(){
		return loginName;
	}
	public void setLoginName(String loginName){
		this.loginName = loginName == null ? null : loginName.trim();
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password == null ? null : password.trim();
	}
	public String getRealName(){
		return realName;
	}
	public void setRealName(String realName){
		this.realName = realName == null ? null : realName.trim();
	}
	public String getCelPhone(){
		return celPhone;
	}
	public void setCelPhone(String celPhone){
		this.celPhone = celPhone == null ? null : celPhone.trim();
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address == null ? null : address.trim();
	}
	public String getCreateTime(){
		return createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime == null ? null : createTime.trim();
	}
}
