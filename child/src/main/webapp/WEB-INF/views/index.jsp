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
</head>
<body>

<div class="fly-header layui-bg-black">
	<div class="layui-container">
		<a style="float:left;left:-30px;margin-top:10px;" href="${pageContext.request.contextPath}/index">
			<h1 style="color:white">留守儿童爱心守护成长平台</h1>
		</a>
		<ul class="layui-nav fly-nav layui-hide-xs">
			<li class="layui-nav-item">
				<a data-href="${pageContext.request.contextPath}/index/index" href="javascript:void(0)" class="clientPageHref"  onclick="goPage(this)">首页</a>
			</li>
			<li class="layui-nav-item">
				<a data-href="${pageContext.request.contextPath}/index/news_search" href="javascript:void(0)" class="clientPageHref"  onclick="goPage(this)">新闻搜索</a>
			</li>
			<li class="layui-nav-item">
				<a data-href="${pageContext.request.contextPath}/index/act_search" href="javascript:void(0)" class="clientPageHref"  onclick="goPage(this)">志愿活动搜索</a>
			</li>
			<li class="layui-nav-item">
				<a data-href="${pageContext.request.contextPath}/index/help_search" href="javascript:void(0)" class="clientPageHref"  onclick="goPage(this)">求助搜索</a>
			</li>
		</ul>
		<ul class="layui-nav fly-nav-user">
			<c:if test="${login!=null and login.loginType==2}">
				<li class="layui-nav-item">
					<a data-href="" href="${pageContext.request.contextPath}/user/index" onclick="" class="fly-nav-avatar rightPageHref">
						<cite class="layui-hide-xs">个人中心</cite>
					</a>
				</li>
			</c:if>
			<c:if test="${login!=null and login.loginType==2}">
				<li class="layui-nav-item">
					<a data-href="" href="${pageContext.request.contextPath}/login/sys_logout" onclick="" class="fly-nav-avatar rightPageHref">
						<cite class="layui-hide-xs">退出</cite>
					</a>
				</li>
			</c:if>
			<c:if test="${login==null}">
				<li class="layui-nav-item">
					<a data-href="" href="${pageContext.request.contextPath}/regist/user_msg_regist" onclick="" class="fly-nav-avatar rightPageHref">
						<cite class="layui-hide-xs">注册</cite>
					</a>
				</li>
			</c:if>
			<c:if test="${login==null}">
				<li class="layui-nav-item">
					<a data-href="" href="${pageContext.request.contextPath}/login/sys_login" onclick="" class="fly-nav-avatar rightPageHref">
						<cite class="layui-hide-xs">登录</cite>
					</a>
				</li>
			</c:if>
		</ul>
	</div>
</div>
<iframe src="${pageContext.request.contextPath}/index/index" id="iframeDom" style="width:100%;min-height:850px"  frameborder="0"></iframe>
<script src="${pageContext.request.contextPath}/static/index/res/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>

<script type="text/javascript">
function goPage(e){
	var dataHref = $(e).attr("data-href");
	goPageAct(dataHref);
}
function goPageAct(dataHref){
	$("#iframeDom").attr("src",dataHref);
}
$(function(){
	var childPageUrl = '${childPageUrl}';
	if(childPageUrl!=null&&childPageUrl!=''&&childPageUrl!='null'){
		childPageUrl = window.atob(childPageUrl);
		goPageAct(childPageUrl);
	}
})

</script>

</body>
</html>

