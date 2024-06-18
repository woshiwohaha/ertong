<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="uri" value="${pageContext.request.contextPath}" />
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />


<title>新闻-详情</title>
</head>
<body style="background-color:white">

<div class="page-container">
	<div style="margin-top:40px;">
		<div style="margin-top:30px;margin-left:10%">
			<button onclick="javascript:history.back(-1);" style="color: #666;background-color: #e6e6e6;border-color:#e6e6e6;border: solid 1px #ddd;padding: 4px 12px;">返回上一页</button>
		</div>
		<h1 style="margin-top:30px;text-align:center">${detail.newsMsg.newsName}</h1>
		<p  style="margin-top:10px;text-align:center">发布人：${detail.aidStr}</p>
		<p  style="margin-top:10px;text-align:center">发布时间：${detail.newsMsg.createTime}</p>
		<div style="margin-top:10px;width:70%;margin-left:15%;text-align:center">
			<img src="${detail.newsMsg.noticeImg}" style="width:200px;height:200px;margin-top:10px;margin-left:8px">
			</div>
			<div style="margin-top:30px;width:70%;margin-left:15%">
				${detail.newsMsg.newsDetail}
			</div>
			<div style="height:200px;"></div>
		</div>
	</div>
</div>

</body>
</html>

