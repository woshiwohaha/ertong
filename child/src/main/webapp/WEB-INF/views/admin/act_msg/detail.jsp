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


<title>志愿活动-详情</title>
</head>
<body style="background-color:white">

<div class="page-container">
	<div style="margin-top:40px;">
		<div style="margin-top:30px;margin-left:10%">
			<button onclick="javascript:history.back(-1);" style="color: #666;background-color: #e6e6e6;border-color:#e6e6e6;border: solid 1px #ddd;padding: 4px 12px;">返回上一页</button>
		</div>
		<h1 style="margin-top:30px;text-align:center">${detail.actMsg.actName}</h1>
		<p  style="margin-top:10px;text-align:center">活动时间：${detail.actMsg.actTime}</p>
		<p  style="margin-top:10px;text-align:center">活动地点：${detail.actMsg.address}</p>
		<p  style="margin-top:10px;text-align:center">联系方式：${detail.actMsg.contactMsg}</p>
		<p  style="margin-top:10px;text-align:center">已参加的人数：${detail.actMsg.joinNum}</p>
		<p  style="margin-top:10px;text-align:center">发布时间：${detail.actMsg.createTime}</p>
		<p  style="margin-top:10px;text-align:center">状态：${detail.actStatusStr}</p>
		<p  style="margin-top:10px;text-align:center">发布用户：${detail.userIdStr}</p>
		<div style="margin-top:10px;width:70%;margin-left:15%;text-align:center">
			<img src="${detail.actMsg.actImg}" style="width:200px;height:200px;margin-top:10px;margin-left:8px">
			</div>
			<div style="margin-top:30px;width:70%;margin-left:15%">
				${detail.actMsg.actDetail}
			</div>
			<div style="height:200px;"></div>
		</div>
	</div>
</div>

</body>
</html>

