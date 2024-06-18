package com.child.model;
public class NewsMsg {
	private Integer id;//ID
	private String newsName;//标题
	private String noticeImg;//图片
	private String newsDetail;//新闻详情
	private Integer aid;//发布人
	private String createTime;//发布时间
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getNewsName(){
		return newsName;
	}
	public void setNewsName(String newsName){
		this.newsName = newsName == null ? null : newsName.trim();
	}
	public String getNoticeImg(){
		return noticeImg;
	}
	public void setNoticeImg(String noticeImg){
		this.noticeImg = noticeImg == null ? null : noticeImg.trim();
	}
	public String getNewsDetail(){
		return newsDetail;
	}
	public void setNewsDetail(String newsDetail){
		this.newsDetail = newsDetail == null ? null : newsDetail.trim();
	}
	public Integer getAid(){
		return aid;
	}
	public void setAid(Integer aid){
		this.aid = aid;
	}
	public String getCreateTime(){
		return createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime == null ? null : createTime.trim();
	}
}
