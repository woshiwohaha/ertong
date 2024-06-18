package com.child.model;
public class HelpMsg {
	private Integer id;//ID
	private String hname;//姓名
	private Integer hage;//年龄
	private String hzp;//照片
	private Integer hsex;//性别
	private String hcel;//联系电话
	private String helpIntro;//具体情况
	private Integer amount;//需要金额
	private String createDate;//发布日期
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getHname(){
		return hname;
	}
	public void setHname(String hname){
		this.hname = hname == null ? null : hname.trim();
	}
	public Integer getHage(){
		return hage;
	}
	public void setHage(Integer hage){
		this.hage = hage;
	}
	public String getHzp(){
		return hzp;
	}
	public void setHzp(String hzp){
		this.hzp = hzp == null ? null : hzp.trim();
	}
	public Integer getHsex(){
		return hsex;
	}
	public void setHsex(Integer hsex){
		this.hsex = hsex;
	}
	public String getHcel(){
		return hcel;
	}
	public void setHcel(String hcel){
		this.hcel = hcel == null ? null : hcel.trim();
	}
	public String getHelpIntro(){
		return helpIntro;
	}
	public void setHelpIntro(String helpIntro){
		this.helpIntro = helpIntro == null ? null : helpIntro.trim();
	}
	public Integer getAmount(){
		return amount;
	}
	public void setAmount(Integer amount){
		this.amount = amount;
	}
	public String getCreateDate(){
		return createDate;
	}
	public void setCreateDate(String createDate){
		this.createDate = createDate == null ? null : createDate.trim();
	}
}
