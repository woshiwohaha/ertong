<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>留守儿童爱心成长守护平台</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="keywords" content="留守儿童爱心成长守护平台">
<meta name="description" content="留守儿童爱心成长守护平台">

<style type="text/css">
body{margin:0;padding:0;background:#efefef;font-family:Georgia, Times, Verdana, Geneva, Arial, Helvetica, sans-serif;}

div#mother{margin:40px auto 0 auto;width:943px;height:572px;position:relative;}
div#errorBox{background: url(${pageContext.request.contextPath}/static/index/404_bg.png) no-repeat top left;width:943px;height:572px;margin:auto;}
div#errorText{color:#39351e;padding:146px 0 0 446px }
div#errorText p{width:303px;font-size:14px;line-height:26px;}
div.link{height:50px;width:145px;float:left;}
div#home{margin:20px 0 0 444px;}
div#contact{margin:20px 0 0 25px;}
h1{font-size:40px;margin-bottom:35px;}
</style>
</head>
<body>

<div id="mother">
	<div id="errorBox">
		<div id="errorText">
			<h1>${msg}</h1>
		</div>
		<a href="javascript:void(0)" onclick="goLogin()" style="margin-top:400px;text-decoration:none;color:#0000FF;">
			<div style="margin-left:47%;padding:4px;width:150px;text-align:center;background-color:#DCDCDC;border-radius：30px；">
				<h3>返回登录</h3>
			</div>
		</a>
	</div>
</div>

</body>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>

<script type="text/javascript">

function goLogin(){
parent.location.href="${pageContext.request.contextPath}/login/sys_login";
}

</script>
</body>
</html>

