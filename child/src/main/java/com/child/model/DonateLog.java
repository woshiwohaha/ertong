package com.child.model;
public class DonateLog {
	private Integer id;//ID
	private Integer uid;//用户ID
	private Integer hid;//求助ID
	private String donateGoods;//捐助物品
	private String donateAmount;//捐助金额
	private String createTime;//创建时间
	private String contactMsg;//联系方式
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
	public Integer getHid(){
		return hid;
	}
	public void setHid(Integer hid){
		this.hid = hid;
	}
	public String getDonateGoods(){
		return donateGoods;
	}
	public void setDonateGoods(String donateGoods){
		this.donateGoods = donateGoods == null ? null : donateGoods.trim();
	}
	public String getDonateAmount(){
		return donateAmount;
	}
	public void setDonateAmount(String donateAmount){
		this.donateAmount = donateAmount == null ? null : donateAmount.trim();
	}
	public String getCreateTime(){
		return createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime == null ? null : createTime.trim();
	}
	public String getContactMsg(){
		return contactMsg;
	}
	public void setContactMsg(String contactMsg){
		this.contactMsg = contactMsg == null ? null : contactMsg.trim();
	}
}
