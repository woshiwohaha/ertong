package com.child.model;
public class NewsDis {
	private Integer id;//ID
	private String content;//评论内容
	private Integer nid;//新闻ID
	private Integer uid;//用户ID
	private String createTime;//创建时间
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getContent(){
		return content;
	}
	public void setContent(String content){
		this.content = content == null ? null : content.trim();
	}
	public Integer getNid(){
		return nid;
	}
	public void setNid(Integer nid){
		this.nid = nid;
	}
	public Integer getUid(){
		return uid;
	}
	public void setUid(Integer uid){
		this.uid = uid;
	}
	public String getCreateTime(){
		return createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime == null ? null : createTime.trim();
	}
}
