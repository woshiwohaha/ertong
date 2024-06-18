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
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/index/res/layui/css/layui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/index/res/css/global.css">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/page/myPagination.css" />
</head>
<body>

<div class="layui-container" style="width:85%">
	<div class="layui-row layui-col-space15">
		<div class="layui-col-md9" style="width:100%">
			<div class="fly-panel">
				<div class="layui-form">
					<div class="layui-row">
						<div class="layui-col-xs6 layui-col-sm6 layui-col-md6" style="padding:6px;">
							<label class="layui-form-label">姓名</label>
							<div class="layui-input-block">
								<input type="text" id="hname" placeholder="请输入姓名搜索"  class="layui-input">
							</div>
						</div>
						<div class="layui-col-xs6 layui-col-sm6 layui-col-md4" style="padding:3px;">
							<button type="button" class="layui-btn layui-btn-normal" onclick="queryHelpMsgList(1)">查询</button>
						</div>
					</div>
				</div>
			</div>
			<div class="fly-panel" style="margin-bottom: 20px;">
				<div class="fly-panel-title fly-filter">
					性别
					<a href="javascript:void(0)" onclick="hsex(this)"  data-id="" class="hsexClass">全部</a>
					<c:forEach var="item" items="${dataSexList}">
						<a href="javascript:void(0)" onclick="hsex(this)"  data-id="${item.id}" class="hsexClass">${item.name}</a>
					</c:forEach>
					<span class="fly-filter-right layui-hide-xs">
					</span>
				</div>
				<div class="fly-panel-title fly-filter">
					<a href="javascript:void(0)"  class="layui-this">求助</a>
				</div>
				<ul  class="fly-case-list"  id="dataQl"   style="margin-left:30px;">
				</ul>
				<div style="text-align:center">
					<div id="qlBar" class="pagination" style="margin-top:20px;"></div>
				</div>
				<div style="height:40px;"></div>
			</div>
		</div>
	</div>
</div>
<script src="${pageContext.request.contextPath}/static/index/res/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/page/myPagination.js"></script>

<script type="text/javascript">
function hsex(e){
	$(".hsexClass").removeClass("layui-this");
	$(e).addClass("layui-this");
	queryHelpMsgList(1);
}
function queryHelpMsgList(page) {
	var  hname= $("#hname").val();
	var  hsex= null;
	var hsexDiv = $(".hsexClass");
	for(var k=0;k<hsexDiv.length;k++){
		if($(hsexDiv[k]).hasClass("layui-this")==true){
			hsex = $(hsexDiv[k]).attr("data-id");
			break;
		}
	}
	$.ajax({
		type : 'get',
		url : "${pageContext.request.contextPath}/index/help_search/queryHelpMsgList",
		async:false,
		data : {
			'hname':hname,
			'hsex':hsex,
			'page':page
		},
		success : function(result) {
			var html = '';
			var count = result.count;
			var totalPage = result.totalPage;
			var pageSize = result.pageSize;
			for(var i=0;i<result.list.length;i++){
				html+='<li data-id="123" style="border:1px solid black;">';
				html+='<a class="fly-case-img" href="${pageContext.request.contextPath}/index/help_detail?id='+result.list[i].model.id+'">';
				html+='<img src="'+result.list[i].model.hzp+'" alt="">';
				html+='</a>';
				html+='<h2><a href="${pageContext.request.contextPath}/index/help_detail?id='+result.list[i].model.id+'">'+result.list[i].model.hname+'</a></h2>';
				html+='<div class="fly-case-info" style="padding:0px;">';
				html+='<p class="layui-elip" style="font-size: 16px;text-align:center;color:#f78b05;font-weight:bold;">'+result.list[i].hsex+'</p>';
				html+='</div>';
				html+='<span style="float:right;color:gray;">'+result.list[i].model.createDate+'</span>';
				html+='</li>';
			}
			if(result.list.length==0){
				html+='<li style="width:82%;height:200px;;margin-left:4%">';
				html+='<h3 style="margin-left:45%;margin-top:100px;">暂无求助信息数据</h3>';
				html+='</li>';
			}
			$("#dataQl").html(html);
			new myPagination({
				id: 'qlBar',
				curPage:page, //初始页码
				pageTotal:totalPage, //总页数
				pageAmount: pageSize,  //每页多少条
				dataTotal: count, //总共多少条数据
				pageSize: pageSize, //可选,分页个数
				showPageTotalFlag:true, //是否显示数据统计
				showSkipInputFlag:false, //是否支持跳转
				getPage: function (page) {
					queryHelpMsgList(page);
				}
			})
		}
	});
}
$(function(){
	queryHelpMsgList(1);
})

</script>

</body>
</html>

