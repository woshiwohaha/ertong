package com.child.model;
public class ActMsg {
	private Integer id;//ID
	private String actName;//活动名
	private String actTime;//活动时间
	private String address;//活动地点
	private String actImg;//图片
	private String contactMsg;//联系方式
	private Integer joinNum;//已参加的人数
	private String actDetail;//活动详情
	private String createTime;//发布时间
	private Integer actStatus;//状态
	private Integer userId;//发布用户
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getActName(){
		return actName;
	}
	public void setActName(String actName){
		this.actName = actName == null ? null : actName.trim();
	}
	public String getActTime(){
		return actTime;
	}
	public void setActTime(String actTime){
		this.actTime = actTime == null ? null : actTime.trim();
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address == null ? null : address.trim();
	}
	public String getActImg(){
		return actImg;
	}
	public void setActImg(String actImg){
		this.actImg = actImg == null ? null : actImg.trim();
	}
	public String getContactMsg(){
		return contactMsg;
	}
	public void setContactMsg(String contactMsg){
		this.contactMsg = contactMsg == null ? null : contactMsg.trim();
	}
	public Integer getJoinNum(){
		return joinNum;
	}
	public void setJoinNum(Integer joinNum){
		this.joinNum = joinNum;
	}
	public String getActDetail(){
		return actDetail;
	}
	public void setActDetail(String actDetail){
		this.actDetail = actDetail == null ? null : actDetail.trim();
	}
	public String getCreateTime(){
		return createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime == null ? null : createTime.trim();
	}
	public Integer getActStatus(){
		return actStatus;
	}
	public void setActStatus(Integer actStatus){
		this.actStatus = actStatus;
	}
	public Integer getUserId(){
		return userId;
	}
	public void setUserId(Integer userId){
		this.userId = userId;
	}
}
