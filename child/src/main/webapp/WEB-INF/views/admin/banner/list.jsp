<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="uri" value="${pageContext.request.contextPath}" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>轮播图</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/layui/css/layui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/css/global.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/icheck/minimal/red.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/page/myPagination.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/selectsearch/jquery.searchableSelect.css" />


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
	<legend>轮播图</legend>
	<div class="layui-field-box">
		<div>
			<div class="layui-form-item" style="text-align:center;">
				<div style="display:inline;width:300px">
					<div class="layui-inline"  style="margin-left:30px;margin-top:20px;">
						<label>求助ID</label>
					</div>
					<div class="layui-inline" style="margin-top:20px;">
						<div>
							<select  id="helpId" style="height:30px;width:200px"  >
								<option value="">全部</option>
								<c:forEach items="${helpMsgList}" var="item">
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
					<a href="${pageContext.request.contextPath}/admin/banner/add" class="layui-btn layui-btn-radius">新增</a>
				</span>
			</div>
			<hr>
				<table class="layui-table"   style="width:100%; table-layout:inherit; word-break: break-all;overflow: auto;">
					<thead>
						<tr  style="text-align:center">
							<th><input type="checkbox" onclick="changeAllCheckBox(this)"></th>
							<th>轮播图</th>
							<th>求助ID</th>
							<th style="width:200px;">操作</th>
						</tr>
					</thead>
					<tbody id="banner_body">
					</tbody>
				</table>
				<div id="banner_bar" class="pagination" style="margin-top:20px;"></div>
			</div>
		</fieldset>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/page/myPagination.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/layui/layui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/layuiutil.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=6786"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/selectsearch/jquery.searchableSelect.js"></script>
		
<script type="text/javascript">
$(function(){
	$('#helpId').next().remove();
	$('#helpId').searchableSelect();
	ajaxList(1);
});
var currentPage=1;
function ajaxList(page) {
	currentPage =page;
	var helpId =$('#helpId').val();
	var countRs = ajaxCount();
	if(countRs.totalPage<page){
		page = countRs.totalPage;
	}
	showLoading('${pageContext.request.contextPath}/static/common/loading.gif');
	$.ajax({
		type : 'get',
		url : "${pageContext.request.contextPath}/admin/banner/queryList",
		data : {
			"page":page,
			"helpId":helpId
		},
		success : function(result) {
			hideLoading();
			var rows = result.list;//得到数据列
			var total = countRs.count;//得到数据总数
			var totalPage=countRs.totalPage;
			var html = '';
			for (var i = 0; i < rows.length; i++) {
				html += '<tr>' ;
				html+='<td><input name="itemCheckBox" data-id="' + rows[i].banner.id+ '" type="checkbox"></td>';
				var bimgStr = rows[i].banner.bimg;
				if(bimgStr!=null){
					var bimgSplit = bimgStr.split(";");
					var tmp = '';
					for(var j=0;j<bimgSplit.length;j++){
						if(bimgSplit[j]!=''){
							tmp+='<div style="display:inline"><img src="'+bimgSplit[j]+'" style="width:100px;height:100px" onclick="maxImg(this)"></div>';
						}
					}
					html+='<td>'+tmp+'</td>';
					}else{
					html+='<td></td>';
				}
				var helpIdVal=setNullToEmpty(rows[i].helpIdStr);
				html+='<td>'+ helpIdVal+'</td>';
				html+='<td>';
				html+='<a href="${pageContext.request.contextPath}/admin/banner/update?id='+rows[i].banner.id+'" class="layui-btn layui-btn-normal layui-btn-radius btnStyle">修改</a>';
				html+='<a href="javascript:void(0)" onclick="del(this)" data-id="'+rows[i].banner.id+'" class="layui-btn layui-btn-danger layui-btn-radius btnStyle">删除</a>';
				html+='</td>';
				html+='</tr>';
			}
			if (rows.length == 0) {
				html += '<tr><td></td><td></td><td>无数据</td><td></td></tr>';
			}
			$("#banner_body").html(html);
			new myPagination({
				id: 'banner_bar',
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
	var helpId =$('#helpId').val();
	$.ajax({
		type : 'get',
		url : "${pageContext.request.contextPath}/admin/banner/queryCount",
		async: false,
		data : {
			"helpId":helpId
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
		var url="${pageContext.request.contextPath}/admin/banner/"+type+"";
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
	if(window.confirm('你确定要删除该轮播图吗')){
		var id = $(e).attr("data-id");
		$.ajax({
			type : 'get',
			url : "${pageContext.request.contextPath}/admin/banner/del",
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
