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
<c:set var="uri" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
var uri='${uri}';

</script>
</head>
<body>

<div class="layui-container">
	<div class="layui-row layui-col-space15">
		<div class="layui-col-md9 content detail" style="width:100%">
			<div class="fly-panel detail-box">
				<div style="min-height:200px;">
					<div style="float:left;margin-left:10px;">
						<img src="${newsMsgDetail.model.noticeImg}" style="width:120px;height:120px;">&nbsp;&nbsp;&nbsp;&nbsp;
						</div>
						<div style="margin-left:150px;width:70%">
							<h1>
								${newsMsgDetail.model.newsName}
							</h1>
							<div class="fly-detail-info" >
							</div>
							<div class="detail-about"    style="margin-top:20px;padding:15px 15px 15px 20px">
								发布人：${newsMsgDetail.aidT.loginName}
							</div>
							<div class="detail-about"    style="margin-top:20px;padding:15px 15px 15px 20px">
								发布时间：${newsMsgDetail.model.createTime}
							</div>
						</div>
					</div>
					<div >
						<fieldset class="layui-elem-field">
							<legend>新闻详情</legend>
							<div class="layui-field-box"  >
								${newsMsgDetail.model.newsDetail}
							</div>
						</fieldset>
						<div style="margin-top:20px;margin-left:150px;">
						</div>
					</div>
				</div>
				<div class="fly-panel detail-box" id="flyReply">
					<fieldset class="layui-elem-field layui-field-title" style="text-align: center;">
						<legend>评论</legend>
					</fieldset>
					<ul class="jieda" id="commentList">
					</ul>
					<div style="text-align:center">
						<div id="commentBar" class="pagination" style="margin-top:20px;"></div>
					</div>
					<div class="layui-form layui-form-pane">
						<div>
							<div class="layui-form-item layui-form-text">
								<div class="layui-input-block">
									<textarea id="ccontent"  placeholder="请输入评论内容"  class="layui-textarea fly-editor" style="height: 150px;"></textarea>
								</div>
							</div>
							<div class="layui-form-item">
								<button class="layui-btn" onclick="submitNewsDis()">提交新闻评论</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/static/index/res/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/page/myPagination.js"></script>
	
<script type="text/javascript">
$(function(){
	getCommentList(1);
});
//查询评论列表
function getCommentList(page){
	var id ='${newsMsgDetail.model.id}';
	$.ajax({
		type : 'get',
		url : "${pageContext.request.contextPath}/index/news_detail/getNewsDis",
		data : {
			"page":page,
			"id":id,
		},
		success : function(result) {
			var count = result.count;
			var totalPage = result.totalPage;
			var pageSize = result.pageSize;
			var html='';
			for(var i=0;i<result.list.length;i++){
				html+='<li  class="jieda-daan">';
				html+='<div class="detail-about detail-about-reply">';
				html+='<div  class="fly-detail-user">';
				html+='<a class="fly-avatar" href="#" target="_blank" >';
				html+='</a>';
				html+='<div class="fly-detail-user">';
				html+='<a href="#" class="fly-link" >';
				html+='<cite >'+result.list[i].uidT.loginName+'</cite>';
				html+='</a>';
				html+='</div>';
				html+='</div>';
				html+='<div class="detail-hits">';
				html+='<span>'+result.list[i].model.createTime+'</span>';
				html+='</div>';
				html+='</div>';
				html+='<div class="detail-body jieda-body photos">';
				html+='<p  style="margin-left:10%">';
				html+='';
				html+=''+result.list[i].model.content+'';
				html+='</p>';
				html+='</div>';
				html+='</li>';
			}
			if(result.list.length==0){
			}
			$("#commentList").html(html);
			new myPagination({
				id: 'commentBar',
				curPage:page, //初始页码
				pageTotal:totalPage, //总页数
				pageAmount: pageSize,  //每页多少条
				dataTotal: count, //总共多少条数据
				pageSize: pageSize, //可选,分页个数
				showPageTotalFlag:true, //是否显示数据统计
				showSkipInputFlag:false, //是否支持跳转
				getPage: function (page) {
					getCommentList(page);
				}
			})
		}
	})
}
function submitNewsDis(){
	var id ='${newsMsgDetail.model.id}';
	var ccontent =$("#ccontent").val();
	$.ajax({
		type : 'get',
		url : "${pageContext.request.contextPath}/index/news_detail/submitNewsDis",
		data : {
			"ccontent":ccontent,
			"id":id,
		},
		success : function(result) {
			alert(result.msg);
			if(result.code==1){
				window.location.reload();
			}
		}
	})
}

</script>

</body>
</html>

