package com.child.model;
public class JoinLog {
	private Integer id;//ID
	private Integer uid;//用户ID
	private String urealName;//用户昵称
	private String ucelPhone;//联系电话
	private Integer aid;//志愿活动ID
	private String aactTime;//活动时间
	private String aaddress;//活动地点
	private String createTime;//创建时间
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getUid(){
		return uid;
	}
	public void setUid(Integer uid){
		this.uid = uid;
	}
	public String getUrealName(){
		return urealName;
	}
	public void setUrealName(String urealName){
		this.urealName = urealName == null ? null : urealName.trim();
	}
	public String getUcelPhone(){
		return ucelPhone;
	}
	public void setUcelPhone(String ucelPhone){
		this.ucelPhone = ucelPhone == null ? null : ucelPhone.trim();
	}
	public Integer getAid(){
		return aid;
	}
	public void setAid(Integer aid){
		this.aid = aid;
	}
	public String getAactTime(){
		return aactTime;
	}
	public void setAactTime(String aactTime){
		this.aactTime = aactTime == null ? null : aactTime.trim();
	}
	public String getAaddress(){
		return aaddress;
	}
	public void setAaddress(String aaddress){
		this.aaddress = aaddress == null ? null : aaddress.trim();
	}
	public String getCreateTime(){
		return createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime == null ? null : createTime.trim();
	}
}
