<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>留守儿童爱心守护成长平台</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="keywords" content="留守儿童爱心成长守护平台">
<meta name="description" content="留守儿童爱心成长守护平台">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/index/res/layui/css/layui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/index/res/css/global.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/page/myPagination.css" />
</head>
<body>

<div class="layui-container"  style="width:85%">
	<div class="layui-row layui-col-space15">
		<div class="layui-col-md9" style="width:100%">
			<div class="layui-carousel" id="lbTest" align="center">
				<div carousel-item="" id="bl" >
					<c:forEach var="item" items="${bl}">
						<a href="${pageContext.request.contextPath}/index/help_detail?id=${item.model.helpId}"><div><img align="center" src="${item.model.bimg}" style="width:90%;height:450px;"></div></a>
						</c:forEach>
						<c:if test="${bl.size()==0}">
						</c:if>
					</div>
				</div>
				<div class="fly-panel" style="margin-bottom: 20px;">
					<div class="fly-panel-title fly-filter">
						<a href="javascript:void(0)"  class="layui-this">志愿活动</a>
						<span class="fly-filter-right layui-hide-xs"  style="float:right">
							<a href="${pageContext.request.contextPath}/index/act_search">查看更多</a>
						</span>
					</div>
					<ul  class="fly-case-list"   id="al"  style="margin-left:30px;">
						<c:forEach begin="1" end="5" step="1" var="item" items="${al}">
							<li data-id="123"  style="border:1px solid black;">
								<a class="fly-case-img" href="${pageContext.request.contextPath}/index/act_detail?id=${item.model.id}">
									<img src="${item.model.actImg}" alt="">
									</a>
									<h2><a href="${pageContext.request.contextPath}/index/act_detail?id=${item.model.id}">${item.model.actName}</a></h2>
									<span style="float:right;color:gray;">${item.model.createTime}</span>
								</li>
							</c:forEach>
							<c:if test="${al.size()==0}">
								<li style="width:82%;height:200px;;margin-left:4%">
									<h3 style="margin-left:45%;margin-top:100px;">暂无志愿活动数据</h3>
								</li>
							</c:if>
						</ul>
						<div style="text-align:center"></div>
						<div style="height:40px;"></div>
					</div>
					<div class="fly-panel" style="margin-bottom: 20px;">
						<div class="fly-panel-title fly-filter">
							<a href="javascript:void(0)"  class="layui-this">求助</a>
							<span class="fly-filter-right layui-hide-xs"  style="float:right">
								<a href="${pageContext.request.contextPath}/index/help_search">查看更多</a>
							</span>
						</div>
						<ul  class="fly-case-list"   id="hl"  style="margin-left:30px;">
							<c:forEach begin="1" end="5" step="1" var="item" items="${hl}">
								<li data-id="123"  style="border:1px solid black;">
									<a class="fly-case-img" href="${pageContext.request.contextPath}/index/help_detail?id=${item.model.id}">
										<img src="${item.model.hzp}" alt="">
										</a>
										<h2><a href="${pageContext.request.contextPath}/index/help_detail?id=${item.model.id}">${item.model.hname}</a></h2>
										<div class="fly-case-info" style="padding:0px;">
											<p class="layui-elip" style="font-size: 16px;text-align:center;color:#f78b05;font-weight: bold;">${item.hsex}</p>
										</div>
										<span style="float:right;color:gray;">${item.model.createDate}</span>
									</li>
								</c:forEach>
								<c:if test="${hl.size()==0}">
									<li style="width:82%;height:200px;;margin-left:4%">
										<h3 style="margin-left:45%;margin-top:100px;">暂无求助信息数据</h3>
									</li>
								</c:if>
							</ul>
							<div style="text-align:center"></div>
							<div style="height:40px;"></div>
						</div>
						<div class="fly-panel" >
							<div class="fly-panel-title fly-filter">
								<a href="javascript:void(0)"  class="layui-this" >新闻</a>
								<span class="fly-filter-rig0ht layui-hide-xs" style="float:right">
									<a href="${pageContext.request.contextPath}/index/news_search">查看更多</a>
								</span>
							</div>
							<ul class="fly-list"   id="nl"  style="margin-left:30px;">
								<c:forEach begin="1" end="5" step="1" var="item" items="${nl}">
									<li>
										<a href="${pageContext.request.contextPath}/index/news_detail?id=${item.model.id}" class="fly-avatar">
											<img src="${item.model.noticeImg}" alt="">
											</a>
											<h2>
												<a href="${pageContext.request.contextPath}/index/news_detail?id=${item.model.id}">${item.model.newsName}</a>
											</h2>
											<div style="float:right;margin-right:50px;">
											</div>
											<div class="fly-list-info">
												<span style="">${item.model.createTime}</span>
											</div>
											<div class="fly-list-badge">
											</div>
										</li>
									</c:forEach>
									<c:if test="${nl.size()==0}">
										<li style="width:82%;height:200px;;margin-left:4%">
											<h3 style="margin-left:45%;margin-top:100px;">暂无新闻数据</h3>
										</li>
									</c:if>
								</ul>
								<div style="text-align:center"></div>
								<div style="height:40px;"></div>
							</div>
						</div>
					</div>
				</div>
				<script src="${pageContext.request.contextPath}/static/index/res/layui/layui.js"></script>
				<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
				<script type="text/javascript" src="${pageContext.request.contextPath}/static/page/myPagination.js"></script>
				
<script type="text/javascript">
<%--	layui 轮播图--%>
layui.use('carousel',  function(){
	var carousel = layui.carousel;
	carousel.render({
		elem: '#lbTest'
		,width: '100%'
		,height: '450px'
		,interval: 5000
		,anim: "fade"
		,full: false


	});
});
$(function(){
})

</script>

</body>
</html>





</script>

