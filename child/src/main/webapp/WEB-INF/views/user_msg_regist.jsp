<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html   style=" background-image:url(${pageContext.request.contextPath}/static/loginbackground.jpg);background-size:100% 100%">
<head>
<meta charset="UTF-8">
<title>留守儿童爱心守护成长平台-用户-注册</title>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<!-- bootstrap 3.0.2 -->
<link href="${pageContext.request.contextPath}/static/login/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<!-- font Awesome -->
<link href="${pageContext.request.contextPath}/static/login/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link href="${pageContext.request.contextPath}/static/login/css/ALTE.css" rel="stylesheet" type="text/css" />



<style>


.codeBtn{
position:relative;
color:blue;
top:7px;
left:75%;
z-index:99;
}
</style>

</head>
<body  style=" background: transparent" >

<div class="form-box" id="login-box" style="width:600px">
	<div class="header">留守儿童爱心守护成长平台-用户-注册</div>
	<div>
		<div class="body bg-gray">
			<div class="form-group">
				<label>登录名</label>&nbsp;&nbsp;&nbsp;<span id="msgname"></span>
				<input id="name" name="name" type="text" placeholder="请输入登录名"  class="form-control ">
			</div>
			<div class="form-group">
				<label>密码</label>&nbsp;&nbsp;&nbsp;<span id="msgpassword"></span>
				<input id="password" name="password" type="password" placeholder="请输入密码"  class="form-control ">
			</div><div class="form-group">
			<label>昵称</label>&nbsp;&nbsp;&nbsp;<span id="msgrealName"></span>
			<input id="realName" name="realName" type="text" placeholder="请输入昵称"  class="form-control ">
		</div><div class="form-group">
			<label>联系电话</label>&nbsp;&nbsp;&nbsp;<span id="msgcelPhone"></span>
			<input id="celPhone" name="celPhone" type="text" placeholder="请输入联系电话"  class="form-control ">
		</div><div class="form-group">
			<label>地址</label>&nbsp;&nbsp;&nbsp;<span id="msgaddress"></span>
			<input id="address" name="address" type="text" placeholder="请输入地址"  class="form-control ">
		</div>
			<div class="form-group">
				<label>图片验证码</label>
				<img id="codeImg1"  name="codeImg"  style="width:100px;float:right;color:blue;left:80%; z-index:99;" alt="点击更换" title="点击更换" />
				<input type="text" name="imgCode" class="form-control"  id="imgCode" value="">
			</div>
		</div>
		<div class="footer">
			<button type="button"  onclick="submitForm()" class="btn bg-olive btn-block">用户-注册 </button>
			<a  style="" href="${pageContext.request.contextPath}/login/sys_login" onclick="" >前往登录</a>
		</div>
	</div>
	<div class="margin text-center">
		<span style="color:black">留守儿童爱心守护成长平台</span>
	</div>
</div>
<!-- jQuery 2.0.2 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=26573"></script>

<script>
$(document).ready(function(e) {
	changeCode();
	$("#codeImg1").bind("click",changeCode);
});
function genTimestamp(){
	var time = new Date();
	return time.getTime();
}
function changeCode(){
	$("img[name='codeImg']").attr("src","${pageContext.request.contextPath}/validCode/code?t="+genTimestamp());
}
function submitForm(){
	$.ajax({
		type: 'post',
		url: '${pageContext.request.contextPath}/regist/userMsgRegistSubmit',
		data: {
			'name':$("#name").val(),
			'password':$("#password").val(),
			'realName':$("#realName").val(),
			'celPhone':$("#celPhone").val(),
			'address':$("#address").val(),
			'imgCode':$('#imgCode').val()
		},
		success: function(result) {
			alert(result.msg);
			if(result.code==1){
				window.location.href="${pageContext.request.contextPath}/login/sys_login";
			}
		}
	});
}
$(function(){
	$("#password").blur(function(){
		var password=$("#password").val();
		$.ajax({
			url:"../regist/checkPassword",
			type:"post",
			data:{"password":password},
			success:function(data){
				if (data.code==0) {
					$("#msgpassword").html(data.msgpassword);
					$("#msgpassword").css("color", "red");
				}else if(data.code==1) {
					$("#msgpassword").html(data.msgpassword);
					$("#msgpassword").css("color", "green");
				}
			}
		});
	});

	$("#name").blur(function(){
		var name=$("#name").val();
		$.ajax({
			url:"../regist/checkUserName",
			type:"post",
			data:{"name":name},
			success:function(data){
				if (data.code==0) {
					$("#msgname").html(data.msgname);
					$("#msgname").css("color", "red");
				}else if(data.code==1) {
					$("#msgname").html(data.msgname);
					$("#msgname").css("color", "green");
				}
			}
		});
	});

	$("#realName").blur(function(){
		var realName=$("#realName").val();
		$.ajax({
			url:"../regist/checkRealName",
			type:"post",
			data:{"realName":realName},
			success:function(data){
				if (data.code==0) {
					$("#msgrealName").html(data.msgrealName);
					$("#msgrealName").css("color", "red");
				}else if(data.code==1) {
					$("#msgrealName").html(data.msgrealName);
					$("#msgrealName").css("color", "green");
				}
			}
		});
	});

	$("#celPhone").blur(function(){
		var celPhone=$("#celPhone").val();
		$.ajax({
			url:"../regist/checkCelPhone",
			type:"post",
			data:{"celPhone":celPhone},
			success:function(data){
				if (data.code==0) {
					$("#msgcelPhone").html(data.msgcelPhone);
					$("#msgcelPhone").css("color", "red");
				}else if(data.code==1) {
					$("#msgcelPhone").html(data.msgcelPhone);
					$("#msgcelPhone").css("color", "green");
				}
			}
		});
	});

	$("#address").blur(function(){
		var address=$("#address").val();
		$.ajax({
			url:"../regist/checkAddress",
			type:"post",
			data:{"address":address},
			success:function(data){
				if (data.code==0) {
					$("#msgaddress").html(data.msgaddress);
					$("#msgaddress").css("color", "red");
				}else if(data.code==1) {
					$("#msgaddress").html(data.msgaddress);
					$("#msgaddress").css("color", "green");
				}
			}
		});
	});
});

</script>

</body>
</html>

