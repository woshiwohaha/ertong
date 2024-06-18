<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="uri" value="${pageContext.request.contextPath}" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>志愿活动</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/layui/css/layui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/css/global.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/icheck/minimal/red.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/page/myPagination.css" />


</head>
<body class="layui-layout-body" style="overflow:scroll;">

<style type="text/css">
	.btnStyle{
	margin-left:8px;
	margin-top:8px
	}
	.loadingModel {
	position: absolute;
	top: 0;
	left: 0;
	background-color: rgba(9, 9, 9, 0.63);
	width: 100%;
	height: 100%;
	z-index: 1000;
	}
	.loading-content {
	width: 50%;
	text-align: center;
	background: #ffffff;
	border-radius: 6px;
	line-height: 30px;
	z-index: 10001;
	}
</style>
<div id="loadingDiv"></div>
<div id="imgModal"></div>
<div></div>
<fieldset class="layui-elem-field">
	<legend>志愿活动</legend>
	<div class="layui-field-box">
		<div>
			<div class="layui-form-item" style="text-align:center;">
				<div style="display:inline;width:300px">
					<div class="layui-inline"  style="margin-left:30px;margin-top:20px;">
						<label>活动名</label>
					</div>
					<div class="layui-inline" style="margin-top:20px;">
						<div>
							<input type="text"  style="display:inline;width:200px" value="" placeholder="请输入活动名" id="actName" class="layui-input">
						</div>
					</div>
				</div>
				<button type="button" onclick="ajaxList(1);" style="margin-left:50px;margin-top:10px" class="layui-btn layui-btn-radius" ><i class="layui-icon layui-icon-search"></i>查询</button>
			</div>
		</div>
		<hr>
			<div class="layui-form-item">
				<span id="batchUpdateDiv">
				</span>
				<span class="l" id="globalBtns">
					<a href="${pageContext.request.contextPath}/user/act_msg/add1" class="layui-btn layui-btn-radius">新增</a>
				</span>
			</div>
			<hr>
				<table class="layui-table"   style="width:100%; table-layout:inherit; word-break: break-all;overflow: auto;">
					<thead>
						<tr  style="text-align:center">
							<th>活动名</th>
							<th>图片</th>
							<th>活动时间</th>
							<th>活动地点</th>
							<th>联系方式</th>
							<th>已参加的人数</th>
							<th>发布时间</th>
							<th>状态</th>
							<th>发布用户</th>
							<th style="width:200px;">操作</th>
						</tr>
					</thead>
					<tbody id="act_msg_body">
					</tbody>
				</table>
				<div id="act_msg_bar" class="pagination" style="margin-top:20px;"></div>
			</div>
		</fieldset>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/page/myPagination.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/layui/layui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/layuiutil.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=4347"></script>
		
<script type="text/javascript">
$(function(){
	ajaxList(1);
});
var currentPage=1;
function ajaxList(page) {
	currentPage =page;
	var actName = $("#actName").val();
	var countRs = ajaxCount();
	if(countRs.totalPage<page){
		page = countRs.totalPage;
	}
	showLoading('${pageContext.request.contextPath}/static/common/loading.gif');
	$.ajax({
		type : 'get',
		url : "${pageContext.request.contextPath}/user/act_msg/queryList",
		data : {
			"page":page,
			"actName":actName
		},
		success : function(result) {
			hideLoading();
			var rows = result.list;//得到数据列
			var total = countRs.count;//得到数据总数
			var totalPage=countRs.totalPage;
			var html = '';
			for (var i = 0; i < rows.length; i++) {
				html += '<tr>' ;
				var actNameVal=setNullToEmpty(rows[i].actMsg.actName);
				html+='<td>'+ actNameVal+'</td>';
				var actImgStr = rows[i].actMsg.actImg;
				if(actImgStr!=null){
					var actImgSplit = actImgStr.split(";");
					var tmp = '';
					for(var j=0;j<actImgSplit.length;j++){
						if(actImgSplit[j]!=''){
							tmp+='<div style="display:inline"><img src="'+actImgSplit[j]+'" style="width:100px;height:100px" onclick="maxImg(this)"></div>';
						}
					}
					html+='<td>'+tmp+'</td>';
					}else{
					html+='<td></td>';
				}
				var actTimeVal=setNullToEmpty(rows[i].actMsg.actTime);
				html+='<td>'+ actTimeVal+'</td>';
				var addressVal=setNullToEmpty(rows[i].actMsg.address);
				html+='<td>'+ addressVal+'</td>';
				var contactMsgVal=setNullToEmpty(rows[i].actMsg.contactMsg);
				html+='<td>'+ contactMsgVal+'</td>';
				var joinNumVal=setNullToEmpty(rows[i].actMsg.joinNum);
				html+='<td>'+ joinNumVal+'</td>';
				var createTimeVal=setNullToEmpty(rows[i].actMsg.createTime);
				html+='<td>'+ createTimeVal+'</td>';
				var actStatusVal=setNullToEmpty(rows[i].actStatusStr);
				html+='<td>'+actStatusVal+'</td>';
				var userIdVal=setNullToEmpty(rows[i].userIdStr);
				html+='<td>'+ userIdVal+'</td>';
				html+='<td>';
				html+='<a href="${pageContext.request.contextPath}/user/act_msg/detail2?id='+rows[i].actMsg.id+'" class="layui-btn layui-btn-radius btnStyle">查看详情</a>';
				if(rows[i].actMsg.actStatus=='3'){
					html+='<a href="${pageContext.request.contextPath}/user/act_msg/update1?id='+rows[i].actMsg.id+'" class="layui-btn layui-btn-normal layui-btn-radius btnStyle">修改</a>';
				}
				if(rows[i].actMsg.actStatus=='3'){
					html+='<a href="javascript:void(0)" onclick="del1(this)" data-id="'+rows[i].actMsg.id+'" class="layui-btn layui-btn-danger layui-btn-radius btnStyle">删除</a>';
				}
				if(rows[i].actMsg.actStatus=='2'){
					html+='<a href="javascript:void(0)" onclick="del1(this)" data-id="'+rows[i].actMsg.id+'" class="layui-btn layui-btn-danger layui-btn-radius btnStyle">删除</a>';
				}
				html+='</td>';
				html+='</tr>';
			}
			if (rows.length == 0) {
				html += '<tr><td></td><td></td><td></td><td></td><td></td><td>无数据</td><td></td><td></td><td></td><td></td></tr>';
			}
			$("#act_msg_body").html(html);
			new myPagination({
				id: 'act_msg_bar',
				curPage:page, //初始页码
				pageTotal:totalPage, //总页数
				pageAmount: 10,  //每页多少条
				dataTotal: total, //总共多少条数据
				pageSize: 10, //可选,分页个数
				showPageTotalFlag:true, //是否显示数据统计
				showSkipInputFlag:false, //是否支持跳转
				getPage: function (page) {
					ajaxList(page);
				}
			})
		}
	});
}
function ajaxCount() {
	var rs = null;
	var actName = $("#actName").val();
	$.ajax({
		type : 'get',
		url : "${pageContext.request.contextPath}/user/act_msg/queryCount",
		async: false,
		data : {
			"actName":actName
		},
		success : function(result) {
			rs = result;
		}
	});
	return rs;
}
function del1(e){
	if(window.confirm('你确定要删除该志愿活动吗')){
		var id = $(e).attr("data-id");
		$.ajax({
			type : 'get',
			url : "${pageContext.request.contextPath}/user/act_msg/del1",
			data : {
				"id":id
			},
			success : function(result) {
				alert(result.msg);
				if(result.code==1){
					ajaxList(currentPage);
				}
			}
		});
		return true;
		}else{
		return false;
	}
}
function downLoadFile(e){
	var url = $(e).attr("file-url");
	window.open(url);
}
function gotoPage(e){
	var url = $(e).attr("data-url");
	window.location.href=url;
}

</script>

</body>
</html>

