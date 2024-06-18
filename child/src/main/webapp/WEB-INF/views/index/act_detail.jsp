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
						<img src="${actMsgDetail.model.actImg}" style="width:120px;height:120px;">&nbsp;&nbsp;&nbsp;&nbsp;
						</div>
						<div style="margin-left:150px;width:70%">
							<h1>
								${actMsgDetail.model.actName}
							</h1>
							<div class="fly-detail-info" >
							</div>
							<div class="detail-about"    style="margin-top:20px;padding:15px 15px 15px 20px">
								活动时间：${actMsgDetail.model.actTime}
							</div>
							<div class="detail-about"    style="margin-top:20px;padding:15px 15px 15px 20px">
								活动地点：${actMsgDetail.model.address}
							</div>
							<div class="detail-about"    style="margin-top:20px;padding:15px 15px 15px 20px">
								联系方式：${actMsgDetail.model.contactMsg}
							</div>
							<div class="detail-about"    style="margin-top:20px;padding:15px 15px 15px 20px">
								已参加的人数：${actMsgDetail.model.joinNum}
							</div>
							<div class="detail-about"    style="margin-top:20px;padding:15px 15px 15px 20px">
								发布时间：${actMsgDetail.model.createTime}
							</div>
						</div>
					</div>
					<div >
						<fieldset class="layui-elem-field">
							<legend>活动详情</legend>
							<div class="layui-field-box"  >
								${actMsgDetail.model.actDetail}
							</div>
						</fieldset>
						<div style="margin-top:20px;margin-left:150px;">
							<c:if test="${user==1}">
								<div style="margin-top:10px;" ><p style="color: red;font-size:15px">您已报名参加!</p></div>
							</c:if>
							<c:if test="${user==0}">
								<div style="margin-top:10px;"><button onClick="submitJoinLog()" class="layui-btn layui-btn-danger">提交参加</button></div>
							</c:if>
							<c:if test="${user==3}">
								<div style="margin-top:10px; " ><p style="color: red;font-size:15px">感谢你组织的活动!</p></div>
							</c:if>
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
});
function submitJoinLog(){
	if(confirm('确定要提交该参加记录吗')==false){
		return false;
		}else{
		$.ajax({
			type: 'post',
			url: '${pageContext.request.contextPath}/index/act_detail/submitJoinLog',
			data:{
				"aid":'${actMsgDetail.model.id}'
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

