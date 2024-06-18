

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
			<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
			<html>
				<head>
					<c:set var="uri" value="${pageContext.request.contextPath}" />
					
<script type="text/javascript">
var uri='${uri}';

</script>
					<meta charset="utf-8">
						<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
							<title>修改-志愿活动</title>
							<link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/layui/css/layui.css">
								<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/webupload/webuploader.css">
									<style type="text/css">
										.loadingModel {
										position: absolute;
										top: 0;
										left: 0;
										display: none;
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
								</head>
								<div id="loadingDiv"></div>
								<div id="imgModal"></div>
								<div class="layui-container" style="overflow:hidden;min-height:850px">
									<div class="layui-row">
										<div class="layui-col-lg12">
											<fieldset class="layui-elem-field">
												<legend>修改-志愿活动</legend>
												<div class="layui-field-box">
													<div >
														<div class="layui-form-item layui-form-text" id="actNameParentContent">
															<label class="layui-form-label">活动名<p style="color:red">(*必填)</p></label>
															<div class="layui-input-block" style="width:720px">
																<input type="text"  style="display:inline;width:400px" value="${data.actName}" placeholder="请输入活动名" id="actName" class="layui-input">
																<p style="color:gray"></p>
															</div>
														</div>
														<div class="layui-form-item layui-form-text" id="actImgParentContent">
															<label class="layui-form-label">图片<p style="color:red">(*必填)</p></label>
															<div class="layui-input-block" style="width:720px">
																<div class="imgUpload" tip="请输入图片"  red-tip=""  upload-num="1" init-val="${data.actImg}" upload-type="1" id="actImg"></div>
																<p style="color:gray"></p>
															</div>
														</div>
														<div class="layui-form-item layui-form-text" id="actTimeParentContent">
															<label class="layui-form-label">活动时间<p style="color:red">(*必填)</p></label>
															<div class="layui-input-block" style="width:720px">
																<input type="text"  style="display:inline;width:400px" value="${data.actTime}" placeholder="请输入活动时间" id="actTime" class="layui-input">
																<p style="color:gray"></p>
															</div>
														</div>
														<div class="layui-form-item layui-form-text" id="addressParentContent">
															<label class="layui-form-label">活动地点<p style="color:red">(*必填)</p></label>
															<div class="layui-input-block" style="width:720px">
																<input type="text"  style="display:inline;width:400px" value="${data.address}" placeholder="请输入活动地点" id="address" class="layui-input">
																<p style="color:gray"></p>
															</div>
														</div>
														<div class="layui-form-item layui-form-text" id="contactMsgParentContent">
															<label class="layui-form-label">联系方式<p style="color:red">(*必填)</p></label>
															<div class="layui-input-block" style="width:720px">
																<input type="text"  style="display:inline;width:400px" value="${data.contactMsg}" placeholder="请输入联系方式" id="contactMsg" class="layui-input">
																<p style="color:gray"></p>
															</div>
														</div>
														<div class="layui-form-item layui-form-text" id="actDetailParentContent">
															<label class="layui-form-label">活动详情<p style="color:red">(*必填)</p></label>
															<div class="layui-input-block" style="width:720px">
																<div id="actDetailDiv1" data-id="actDetail"  class="toolbar" style="border: 1px solid #ccc;margin-top:3%;"></div>
																<div id="actDetailDiv2"  class="text" style="border: 1px solid #ccc;min-height:300px;z-index:1"></div>
																<p style="color:gray"></p>
															</div>
														</div>
														<div class="layui-form-item layui-form-text" id="actStatusParentContent">
															<label class="layui-form-label">状态<p style="color:red">(*必填)</p></label>
															<div class="layui-input-block" style="width:720px">
																<select  id="actStatus" style="display:inline;height:30px;width:400px" >
																	<c:forEach items="${actStatusList}" var="item">
																		<c:if test="${item.id==data.actStatus}">
																			<option value="${item.id}" selected>${item.name}</option>
																		</c:if>
																		<c:if test="${item.id!=data.actStatus}">
																			<option value="${item.id}">${item.name}</option>
																		</c:if>
																	</c:forEach>
																</select>
																<p style="color:gray"></p>
															</div>
														</div>
														<div class="layui-form-item">
															<div class="layui-input-block">
																<button class="layui-btn" onclick="submitData();" >立即提交</button>
																<button  class="layui-btn layui-btn-primary"  onclick="javascript:history.back(-1);" >返回</button>
															</div>
														</div>
														<div style="height:200px"></div>
													</div>
												</div>
											</fieldset>
										</div>
									</div>
								</div>
								<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
								<script type="text/javascript" src="${pageContext.request.contextPath}/static/wangeditor/wangEditor.min.js"></script>
								<script type="text/javascript" src="${pageContext.request.contextPath}/static/wangeditor/wangeditor_emotion.js"></script>
								<script type="text/javascript" src="${pageContext.request.contextPath}/static/webupload/webuploader.js"></script>
								<script type="text/javascript" src="${pageContext.request.contextPath}/static/webupload/upload.js"></script>
								<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/layui/layui.js"></script>
								<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=9479"></script>
								<script type="text/javascript">
									$(function(){
									createFileUpload('${pageContext.request.contextPath}');
									var postDetailEdit =window.wangEditor;
									editor = new postDetailEdit('#actDetailDiv1', '#actDetailDiv2');
									editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/imgUpload/imgUploadForWangEditor'
									editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024;
									editor.customConfig.uploadImgMaxLength = 5;
									editor.customConfig.uploadImgTimeout = 30000;
									editor.customConfig.uploadFileName = 'files'
									editor.customConfig.emotions = [{ title: '默认',type: 'image',content:wangeditorEmotions}];
									editor.create();
									$('#actDetailDiv2').css("z-index","1");
									var actDetailMap={};
									actDetailMap.id='actDetail';
									actDetailMap.edit=editor;
									wangList.push(actDetailMap);
									editor.txt.html(getData().actDetail);
									})
									function getData(){
									var data={};
									$.ajax({
									async:false,
									type: 'post',
									url: '${pageContext.request.contextPath}/admin/act_msg/queryDataDetail',
									data:{
									"id":'${data.id}'
									},
									success: function(result) {
									data = result;
									}
									});
									return data;
									}
									var wangList=[];
									function getEditVal(name){
									for(var i=0;i<wangList.length;i++){
										var dataId = wangList[i].id;
										if(dataId==name){
										return wangList[i].edit.txt.html();
										}
										}
										return '';
										}	function submitData(){
										var actName= $('#actName').val();
										var actImg=getUploadFileStr('actImg')
										var actTime= $('#actTime').val();
										var address= $('#address').val();
										var contactMsg= $('#contactMsg').val();
										var actDetail=getEditVal('actDetail')
										var actStatus= $('#actStatus').val();
										$.ajax({
										type: 'post',
										url: '${pageContext.request.contextPath}/admin/act_msg/update_submit',
										data:{
										"id":'${data.id}',
										"actName":actName,
										"actImg":actImg,
										"actTime":actTime,
										"address":address,
										"contactMsg":contactMsg,
										"actDetail":actDetail,
										"actStatus":actStatus
										},
										success: function(result) {
										if(result.code == 0){
										alert(result.msg);
										}else{
										alert(result.msg);
										window.location.href="${pageContext.request.contextPath}/admin/act_msg";
										}
										}
										});
										}
									</script>
								</body>
							</html>



