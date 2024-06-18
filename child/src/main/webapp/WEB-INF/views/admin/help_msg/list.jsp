<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="uri" value="${pageContext.request.contextPath}" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>求助信息</title>
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
	<legend>求助信息</legend>
	<div class="layui-field-box">
		<div>
			<div class="layui-form-item" style="text-align:center;">
				<div style="display:inline;width:300px">
					<div class="layui-inline"  style="margin-left:30px;margin-top:20px;">
						<label>姓名</label>
					</div>
					<div class="layui-inline" style="margin-top:20px;">
						<div>
							<input type="text"  style="display:inline;width:200px" value="" placeholder="请输入姓名" id="hname" class="layui-input">
						</div>
					</div>
				</div>
				<div style="display:inline;width:300px">
					<div class="layui-inline"  style="margin-left:30px;margin-top:20px;">
						<label>性别</label>
					</div>
					<div class="layui-inline" style="margin-top:20px;">
						<div>
							<select  id="hsex" style="display:inline;height:30px;width:200px" >
								<option value="">全部</option>
								<c:forEach items="${sexList}" var="item">
									<option value="${item.id}">${item.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<button type="button" onclick="ajaxList(1);" style="margin-left:50px;margin-top:10px" class="layui-btn layui-btn-radius" ><i class="layui-icon layui-icon-search"></i>查询</button>
			</div>
		</div>
		<hr>
			<div class="layui-form-item">
				<span id="batchUpdateDiv">
					批量操作：<select id="batchUpdate"  style="height:30px;width:200px;">
						<option value="-5">请选择</option>
						<option value="batch_delete">批量删除</option>
					</select>
					<button onclick="batchAction()" style="width:100px;height:30px;color:black;background-color:#F0FFFF">确定</button>
				</span>
				<span class="l" id="globalBtns">
					<a href="${pageContext.request.contextPath}/admin/help_msg/add" class="layui-btn layui-btn-radius">新增</a>
				</span>
			</div>
			<hr>
				<table class="layui-table"   style="width:100%; table-layout:inherit; word-break: break-all;overflow: auto;">
					<thead>
						<tr  style="text-align:center">
							<th><input type="checkbox" onclick="changeAllCheckBox(this)"></th>
							<th>姓名</th>
							<th>年龄</th>
							<th>照片</th>
							<th>性别</th>
							<th>联系电话</th>
							<th>具体情况</th>
							<th>需要金额</th>
							<th>发布日期</th>
							<th style="width:200px;">操作</th>
						</tr>
					</thead>
					<tbody id="help_msg_body">
					</tbody>
				</table>
				<div id="help_msg_bar" class="pagination" style="margin-top:20px;"></div>
			</div>
		</fieldset>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/page/myPagination.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/layui/layui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/layuiutil.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=3670"></script>
		
<script type="text/javascript">
$(function(){
	ajaxList(1);
});
var currentPage=1;
function ajaxList(page) {
	currentPage =page;
	var hname = $("#hname").val();
	var hsex = $("#hsex").val();
	var countRs = ajaxCount();
	if(countRs.totalPage<page){
		page = countRs.totalPage;
	}
	showLoading('${pageContext.request.contextPath}/static/common/loading.gif');
	$.ajax({
		type : 'get',
		url : "${pageContext.request.contextPath}/admin/help_msg/queryList",
		data : {
			"page":page,
			"hname":hname,
			"hsex":hsex
		},
		success : function(result) {
			hideLoading();
			var rows = result.list;//得到数据列
			var total = countRs.count;//得到数据总数
			var totalPage=countRs.totalPage;
			var html = '';
			for (var i = 0; i < rows.length; i++) {
				html += '<tr>' ;
				html+='<td><input name="itemCheckBox" data-id="' + rows[i].helpMsg.id+ '" type="checkbox"></td>';
				var hnameVal=setNullToEmpty(rows[i].helpMsg.hname);
				html+='<td>'+ hnameVal+'</td>';
				var hageVal=setNullToEmpty(rows[i].helpMsg.hage);
				html+='<td>'+ hageVal+'</td>';
				var hzpStr = rows[i].helpMsg.hzp;
				if(hzpStr!=null){
					var hzpSplit = hzpStr.split(";");
					var tmp = '';
					for(var j=0;j<hzpSplit.length;j++){
						if(hzpSplit[j]!=''){
							tmp+='<div style="display:inline"><img src="'+hzpSplit[j]+'" style="width:100px;height:100px" onclick="maxImg(this)"></div>';
						}
					}
					html+='<td>'+tmp+'</td>';
					}else{
					html+='<td></td>';
				}
				var hsexVal=setNullToEmpty(rows[i].hsexStr);
				html+='<td>'+hsexVal+'</td>';
				var hcelVal=setNullToEmpty(rows[i].helpMsg.hcel);
				html+='<td>'+ hcelVal+'</td>';
				var helpIntroVal=setNullToEmpty(rows[i].helpMsg.helpIntro);
				html+='<td>'+ helpIntroVal+'</td>';
				var amountVal=setNullToEmpty(rows[i].helpMsg.amount);
				html+='<td>'+ amountVal+'</td>';
				var createDateVal=setNullToEmpty(rows[i].helpMsg.createDate);
				html+='<td>'+ createDateVal+'</td>';
				html+='<td>';
				html+='<a href="${pageContext.request.contextPath}/admin/help_msg/update?id='+rows[i].helpMsg.id+'" class="layui-btn layui-btn-normal layui-btn-radius btnStyle">修改</a>';
				html+='<a href="javascript:void(0)" onclick="del(this)" data-id="'+rows[i].helpMsg.id+'" class="layui-btn layui-btn-danger layui-btn-radius btnStyle">删除</a>';
				html+='<a href="javascript:void(0)" data-url="${pageContext.request.contextPath}/admin/donate_log?hid='+rows[i].helpMsg.id+'" page-name="捐助记录" onclick="gotoPage(this)"  class="layui-btn layui-btn-warm layui-btn-radius btnStyle">捐助管理</a>';
				html+='</td>';
				html+='</tr>';
			}
			if (rows.length == 0) {
				html += '<tr><td></td><td></td><td></td><td></td><td></td><td>无数据</td><td></td><td></td><td></td><td></td></tr>';
			}
			$("#help_msg_body").html(html);
			new myPagination({
				id: 'help_msg_bar',
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
	var hname = $("#hname").val();
	var hsex = $("#hsex").val();
	$.ajax({
		type : 'get',
		url : "${pageContext.request.contextPath}/admin/help_msg/queryCount",
		async: false,
		data : {
			"hname":hname,
			"hsex":hsex
		},
		success : function(result) {
			rs = result;
		}
	});
	return rs;
}
function batchAction(){
	var type = $("#batchUpdate").val();
	if(type=='-5'){
		alert("请选择操作");
		return;
	}
	var cl = $("input[name='itemCheckBox']");
	var ids = "";
	for(var i=0;i<cl.length;i++){
		if($(cl[i]).prop("checked")==true){
			ids+=$(cl[i]).attr("data-id")+",";
		}
	}
	if(ids!=''){
		ids = ids.substring(0,ids.length-1);
		}else{
		alert("请选择数据");
		return;
	}
	var r=confirm("确认对选中数据进行此批量操作？");
	if(r==true){
		var url="${pageContext.request.contextPath}/admin/help_msg/"+type+"";
		$.ajax({
			type : 'get',
			url : url,
			data : {
				"ids":ids
			},
			success : function(result) {
				alert(result.msg);
				if(result.code==1){
					ajaxList(currentPage);
				}
			}
		});
	}
}
function changeAllCheckBox(e){
	var val = $(e).prop("checked");
	$("input[name='itemCheckBox']").prop("checked",val);
}
function del(e){
	if(window.confirm('你确定要删除该求助信息吗')){
		var id = $(e).attr("data-id");
		$.ajax({
			type : 'get',
			url : "${pageContext.request.contextPath}/admin/help_msg/del",
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

