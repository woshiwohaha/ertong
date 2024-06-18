package com.child.model;
public class Banner {
	private Integer id;//ID
	private String bimg;//轮播图
	private Integer helpId;//求助ID
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getBimg(){
		return bimg;
	}
	public void setBimg(String bimg){
		this.bimg = bimg == null ? null : bimg.trim();
	}
	public Integer getHelpId(){
		return helpId;
	}
	public void setHelpId(Integer helpId){
		this.helpId = helpId;
	}
}
