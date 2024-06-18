<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html   style=" background-image:url(${pageContext.request.contextPath}/static/loginbackground.jpg);background-size:100% 100%">
<head>
<meta charset="UTF-8">
<title>留守儿童爱心守护成长平台-登录</title>
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
	<div class="header">留守儿童爱心守护成长平台-登录</div>
	<div>
		<div class="body bg-gray">
			<div class="form-group">
				<label>登录名</label>
				<input id="name" name="name" type="text" placeholder="请输入登录名"  class="form-control ">
			</div>
			<div class="form-group">
				<label>密码</label>
				<input id="password" name="password" type="password" placeholder="请输入密码"  class="form-control ">
			</div>
			<div class="form-group">
				<label>图片验证码</label>
				<img id="codeImg1"  name="codeImg"  style="width:100px;float:right;color:blue;left:80%; z-index:99;" alt="点击更换" title="点击更换" />
				<input type="text" name="imgCode" class="form-control"  id="imgCode" value="">
			</div>
			<div class="form-group">
				<label>登录角色</label>
				<input name="loginType" type="radio" value="1" id="loginType1" style="margin-left:10px;"/><label for="loginType1">管理员</label>
				<input name="loginType" type="radio" value="2" id="loginType2" style="margin-left:10px;"/><label for="loginType2">用户</label>
			</div>
			<div class="form-group">
				<input type="checkbox" name="online" id="online" value="">
				<label for="online">记住密码</label>
			</div>
		</div>
		<div class="footer">
			<button type="button"  onclick="submitForm()" class="btn bg-olive btn-block">登录 </button>
			<a  style="" href="${pageContext.request.contextPath}/regist/user_msg_regist" onclick="" >注册用户</a>
		</div>
	</div>
	<div class="margin text-center">
		<span style="color:black"> 留守儿童爱心守护成长平台</span>
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
	cookieSubmit()
	$.ajax({
		type: 'post',
		url: '${pageContext.request.contextPath}/login/sysSubmit',
		data: {
			'imgCode':$('#imgCode').val(),
			'name':$("#name").val(),
			'password':$("#password").val(),
			'loginType':getCheckBoxVal('loginType')
		},
		success: function(result) {
			if(result.code==1){
				var lt = getCheckBoxVal('loginType');
				if(lt=='1'){
					window.location.href="${pageContext.request.contextPath}/admin/index";
				}
				if(lt=='2'){
					window.location.href="${pageContext.request.contextPath}/index";
				}
				}else{
				alert(result.msg);
			}
		}
	});
}
$(function(){
})
$(function(){
	//页面初始化时，如果帐号密码cookie存在则填充
	if(getCookie('user') && getCookie('pswd')){
		$("#name").val(getCookie('user'));
		$("#password").val( getCookie('pswd'));
		$("#online").prop("checked",true);
	}
	$("#online").change(function(){
		if(!this.checked){
			deleteCookie('user');
			deleteCookie('pswd');
		}
	})
});
function cookieSubmit(){
	var online = $("#online").prop("checked");
	if(online){
		setCookie('user',$("#name").val(),7); //保存帐号到cookie，有效期7天
		setCookie('pswd',$("#password").val(),7); //保存密码到cookie，有效期7天
	}
}
/*添加cookie*/
function setCookie(name,value,outTime){
	var expdate=new Date();
	var outms=outTime*24*60*60*1000;//过期时间，以天为单位‘1’表示一天
	expdate.setTime(expdate.getTime()+outms);
	var cookieStr=name+"="+escape(value)+";expires="+expdate.toGMTString();
	//escape方法的作用是进行编码，主要防止value中有特殊字符
	document.cookie=cookieStr;
}
/*读取cookie*/
function getCookie(cookieName){
	var cookieStr=document.cookie;
	var cookievalue="";
	if(cookieStr!=null &&cookieStr!=undefined){
		var arrayCookie=cookieStr.split(';');
		for(var i=0;i<arrayCookie.length;i++){
			var arrayDetail=arrayCookie[i].split('=');
			if(i==0){
				cookiMap='{"'+arrayDetail[0].trim()+'":"'+arrayDetail[1].trim()+'",';
					}else if(i==arrayCookie.length-1){
				cookiMap+='"'+arrayDetail[0].trim()+'":"'+arrayDetail[1].trim()+'"}';
				}else{
				cookiMap+='"'+arrayDetail[0].trim()+'":"'+arrayDetail[1].trim()+'",';
			}
		}
	}
	var cookieObj=JSON.parse(cookiMap);
	for(var item in cookieObj){
		if(item==cookieName){
			cookievalue=unescape(cookieObj[item]);
		}
	}
	return cookievalue;
}
/*删除cookie
cookie的删除并不是物理意义上的直接删除，
而是将cookie的有效期设置为失效，然后由浏览器删除失效的cookie删除
*/
function deleteCookie(cookiename){
	var date = new Date();
	var outTime=date.getTime()-1000;//将cookie的有效期设置为失效
	date.setTime(outTime);
	document.cookie=cookiename+"='';expires="+date.toGMTString();
}

</script>

</body>
</html>

