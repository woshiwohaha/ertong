<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>留守儿童爱心守护成长平台</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/layui/css/layui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/layui/css/admin.css">
</head>
<body class="layui-layout-body">

<div class="layui-layout layui-layout-admin">
	<div class="layui-header">
		<div class="layui-logo" style="width:300px;"><a  href="#" style="color:white">留守儿童爱心守护成长平台</a></div>
		<ul class="layui-nav layui-layout-right">
			<li class="layui-nav-item">
				<a href="javascript:;">
					${roleName}
				</a>
				<dl class="layui-nav-child">
					<dd><a href="javascript:void(0)" onclick="alterPassword()">修改密码</a></dd>
				</dl>
			</li>
			<li class="layui-nav-item"><a href="${pageContext.request.contextPath}/login/sys_logout">退出</a></li>
		</ul>
	</div>
	<div class="layui-side layui-bg-black">
		<div class="layui-side-scroll" style="display:block">
			<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
			<ul class="layui-nav layui-nav-tree"  lay-filter="test">
				<li class="layui-nav-item layui-nav-itemed">
					<a href="javascript:;">用户 </a>
					<dl class="layui-nav-child">
						<dd>  <a onclick="goPage(this)"  data-name="用户管理"    data-url="${pageContext.request.contextPath}/admin/user_msg">用户管理  </a>  </dd>
					</dl>
					</li><li class="layui-nav-item layui-nav-itemed">
					<a href="javascript:;">新闻 </a>
					<dl class="layui-nav-child">
						<dd>  <a onclick="goPage(this)"  data-name="新闻管理"    data-url="${pageContext.request.contextPath}/admin/news_msg">新闻管理  </a>  </dd><dd>  <a onclick="goPage(this)"  data-name="新闻评论管理"    data-url="${pageContext.request.contextPath}/admin/news_dis">新闻评论管理  </a>  </dd>
					</dl>
					</li><li class="layui-nav-item layui-nav-itemed">
					<a href="javascript:;">志愿活动 </a>
					<dl class="layui-nav-child">
						<dd>  <a onclick="goPage(this)"  data-name="志愿活动管理"    data-url="${pageContext.request.contextPath}/admin/act_msg">志愿活动管理  </a>  </dd>
					</dl>
					</li><li class="layui-nav-item layui-nav-itemed">
					<a href="javascript:;">求助 </a>
					<dl class="layui-nav-child">
						<dd>  <a onclick="goPage(this)"  data-name="求助管理"    data-url="${pageContext.request.contextPath}/admin/help_msg">求助管理  </a>  </dd>
					</dl>
					</li><li class="layui-nav-item layui-nav-itemed">
					<a href="javascript:;">轮播图 </a>
					<dl class="layui-nav-child">
						<dd>  <a onclick="goPage(this)"  data-name="轮播图管理"    data-url="${pageContext.request.contextPath}/admin/banner">轮播图管理  </a>  </dd>
					</dl>
				</li>
			</ul>
		</div>
	</div>
	<div class="layui-body" id="LAY_app_body">
		<div class="layui-tabsbody-item layui-show">
			<iframe src="${pageContext.request.contextPath}/admin/user_msg" frameborder="0" class="layui-iframe" style="padding: 15px;"></iframe>
		</div>
	</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/layui/layui.all.js"></script>

<script type="text/javascript">
layui.use('element', function() {
});
$(function(){
});
/**
* 操作管理--打开界面
* @param String title 界面标题
* @param String url 访问路径
* @param int width 打开宽度
* @param int height 打开高度
*/
function execute_open(title, url, width, height) {
	layer.open({
		type: 2,
		title: ''+ title +'',
		shadeClose: true,
		shade: 0.8,
		area: [''+ width +'px', ''+ height +'px'],
		content: ''+ url +'',
	});
}
/**选项卡切换**/
var nav_id = $('.layui-this').data('nav');
$('#layui_nav_left_' + nav_id).show();
$('.layui-layout-left').find('.layui-nav-item').click(function () {
	var nav_id = $(this).data('nav');
	$('#layui_nav_left_' + nav_id).show().siblings().hide();
});
$('.layui-nav-child').find('dd').find('a').click(function () {
	var url = $(this).data('url');
	$('.layui-iframe').attr('src', url);
});
function goPage(name,url){
	$('.layui-iframe').attr('src', url);
}
function alterPassword(){
	goPage("修改密码","${pageContext.request.contextPath}/alterPwd/alterPassword");
}

</script>

</body>
</html>

