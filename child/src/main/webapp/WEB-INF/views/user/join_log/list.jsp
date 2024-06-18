<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="uri" value="${pageContext.request.contextPath}" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>参加记录</title>
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
	<legend>参加记录</legend>
	<div class="layui-field-box">
		<div>
			<div class="layui-form-item" style="text-align:center;">
				<div style="display:inline;width:300px">
					<div class="layui-inline"  style="margin-left:30px;margin-top:20px;">
						<label>用户昵称</label>
					</div>
					<div class="layui-inline" style="margin-top:20px;">
						<div>
							<input type="text"  style="display:inline;width:200px" value="" placeholder="请输入用户昵称" id="urealName" class="layui-input">
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
				</span>
			</div>
			<hr>
				<table class="layui-table"   style="width:100%; table-layout:inherit; word-break: break-all;overflow: auto;">
					<thead>
						<tr  style="text-align:center">
							<th>用户ID</th>
							<th>用户昵称</th>
							<th>联系电话</th>
							<th>志愿活动ID</th>
							<th>活动时间</th>
							<th>活动地点</th>
							<th>创建时间</th>
						</tr>
					</thead>
					<tbody id="join_log_body">
					</tbody>
				</table>
				<div id="join_log_bar" class="pagination" style="margin-top:20px;"></div>
			</div>
		</fieldset>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/page/myPagination.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/layui/layui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/layuiutil.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=4915"></script>
		
<script type="text/javascript">
$(function(){
	ajaxList(1);
});
var currentPage=1;
function ajaxList(page) {
	currentPage =page;
	var urealName = $("#urealName").val();
	var countRs = ajaxCount();
	if(countRs.totalPage<page){
		page = countRs.totalPage;
	}
	showLoading('${pageContext.request.contextPath}/static/common/loading.gif');
	$.ajax({
		type : 'get',
		url : "${pageContext.request.contextPath}/user/join_log/queryList",
		data : {
			"page":page,
			"urealName":urealName
		},
		success : function(result) {
			hideLoading();
			var rows = result.list;//得到数据列
			var total = countRs.count;//得到数据总数
			var totalPage=countRs.totalPage;
			var html = '';
			for (var i = 0; i < rows.length; i++) {
				html += '<tr>' ;
				var uidVal=setNullToEmpty(rows[i].uidStr);
				html+='<td>'+ uidVal+'</td>';
				var urealNameVal=setNullToEmpty(rows[i].joinLog.urealName);
				html+='<td>'+ urealNameVal+'</td>';
				var ucelPhoneVal=setNullToEmpty(rows[i].joinLog.ucelPhone);
				html+='<td>'+ ucelPhoneVal+'</td>';
				var aidVal=setNullToEmpty(rows[i].aidStr);
				html+='<td>'+ aidVal+'</td>';
				var aactTimeVal=setNullToEmpty(rows[i].joinLog.aactTime);
				html+='<td>'+ aactTimeVal+'</td>';
				var aaddressVal=setNullToEmpty(rows[i].joinLog.aaddress);
				html+='<td>'+ aaddressVal+'</td>';
				var createTimeVal=setNullToEmpty(rows[i].joinLog.createTime);
				html+='<td>'+ createTimeVal+'</td>';
				html+='</tr>';
			}
			if (rows.length == 0) {
				html += '<tr><td></td><td></td><td></td><td>无数据</td><td></td><td></td><td></td></tr>';
			}
			$("#join_log_body").html(html);
			new myPagination({
				id: 'join_log_bar',
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
	var urealName = $("#urealName").val();
	$.ajax({
		type : 'get',
		url : "${pageContext.request.contextPath}/user/join_log/queryCount",
		async: false,
		data : {
			"urealName":urealName
		},
		success : function(result) {
			rs = result;
		}
	});
	return rs;
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

