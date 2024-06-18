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
						<img src="${helpMsgDetail.model.hzp}" style="width:120px;height:120px;">&nbsp;&nbsp;&nbsp;&nbsp;
						</div>
						<div style="margin-left:150px;width:70%">
							<h1>
								${helpMsgDetail.model.hname}
							</h1>
							<div class="fly-detail-info" >
							</div>
							<div class="detail-about"    style="margin-top:20px;padding:15px 15px 15px 20px">
								年龄：${helpMsgDetail.model.hage}
							</div>
							<div class="detail-about"    style="margin-top:20px;padding:15px 15px 15px 20px">
								性别：${helpMsgDetail.hsex}
							</div>
							<div class="detail-about"    style="margin-top:20px;padding:15px 15px 15px 20px">
								联系电话：${helpMsgDetail.model.hcel}
							</div>
							<div class="detail-about"    style="margin-top:20px;padding:15px 15px 15px 20px">
								具体情况：${helpMsgDetail.model.helpIntro}
							</div>
							<div class="detail-about"    style="margin-top:20px;padding:15px 15px 15px 20px">
								需要金额：${helpMsgDetail.model.amount}
							</div>
							<div class="detail-about"    style="margin-top:20px;padding:15px 15px 15px 20px">
								发布日期：${helpMsgDetail.model.createDate}
							</div>
						</div>
					</div>
					<div >
						<div style="margin-top:20px;margin-left:150px;">
							<div style="margin-top:10px;"><p>捐助物品</p><input type="text" style="width:240px;height:30px;" id="donateGoods" ></div>
							<div style="margin-top:10px;"><p>捐助金额</p><input type="text" style="width:240px;height:30px;" id="donateAmount" ></div>
							<div style="margin-top:10px;"><button onClick="submitDonateLog()" class="layui-btn layui-btn-danger">提交捐助</button></div>
						</div>
					</div>
				</div>
				<div class="fly-panel" >
					<div class="fly-panel-title fly-filter">
						<a href="javascript:void(0)"  class="layui-this" >捐助记录</a>
						<span class="fly-filter-rig0ht layui-hide-xs" style="float:right">
						</span>
					</div>
					<ul class="fly-list"   id="dl"  style="margin-left:30px;">
						<c:forEach var="item" items="${dl}">
							<li>
								<h2>
									<a href="javascript:void(0)">${item.uid}</a>
								</h2>
								<div style="float:right;margin-right:50px;">
								</div>
								<div class="fly-list-info">
									<span style="">捐赠物品：${item.model.donateGoods}</span>
									<span style="">捐赠金额：${item.model.donateAmount}</span>
									<span style="">捐赠时间${item.model.createTime}</span>
								</div>
								<div class="fly-list-badge">
								</div>
							</li>
						</c:forEach>
						<c:if test="${dl.size()==0}">
							<li style="width:82%;height:200px;;margin-left:4%">
								<h3 style="margin-left:45%;margin-top:100px;">暂无捐助记录数据</h3>
							</li>
						</c:if>
					</ul>
					<div style="text-align:center"></div>
					<div style="height:40px;"></div>
				</div>
			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/static/index/res/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/page/myPagination.js"></script>
	
<script type="text/javascript">
$(function(){
});
function submitDonateLog(){
	if(confirm('确定要提交该捐助记录吗')==false){
		return false;
		}else{
		var donateGoods = $("#donateGoods").val();
		var donateAmount = $("#donateAmount").val();
		$.ajax({
			type: 'post',
			url: '${pageContext.request.contextPath}/index/help_detail/submitDonateLog',
			data:{
				'donateGoods':donateGoods,
				'donateAmount':donateAmount,
				"hid":'${helpMsgDetail.model.id}'
			},
			success: function(result) {
				if(result.code == 0){
					alert(result.msg);
					}else{
					alert(result.msg);
					window.location.reload();
				}
			}
		});
	}
}

</script>

</body>
</html>

