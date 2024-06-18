

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
							<title>新增-求助信息</title>
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
												<legend>新增-求助信息</legend>
												<div class="layui-field-box">
													<div >
														<div class="layui-form-item layui-form-text" id="hnameParentContent">
															<label class="layui-form-label">姓名<p style="color:red">(*必填)</p></label>
															<div class="layui-input-block" style="width:720px">
																<input type="text"  style="display:inline;width:400px" value="" placeholder="请输入姓名" id="hname" class="layui-input">
																<p style="color:gray"></p>
															</div>
														</div>
														<div class="layui-form-item layui-form-text" id="hageParentContent">
															<label class="layui-form-label">年龄<p style="color:red">(*必填)</p></label>
															<div class="layui-input-block" style="width:720px">
																<input type="text"  style="display:inline;width:400px" value="" placeholder="请输入年龄(请输入数字)" id="hage" class="layui-input">
																<p style="color:gray"></p>
															</div>
														</div>
														<div class="layui-form-item layui-form-text" id="hzpParentContent">
															<label class="layui-form-label">照片<p style="color:red">(*必填)</p></label>
															<div class="layui-input-block" style="width:720px">
																<div class="imgUpload" tip="请输入照片"  red-tip=""  upload-num="1" init-val="" upload-type="1" id="hzp"></div>
																<p style="color:gray"></p>
															</div>
														</div>
														<div class="layui-form-item layui-form-text" id="hsexParentContent">
															<label class="layui-form-label">性别<p style="color:red">(*必填)</p></label>
															<div class="layui-input-block" style="width:720px">
																<select  id="hsex" style="display:inline;height:30px;width:400px" >
																	<c:forEach items="${sexList}" var="item">
																		<option value="${item.id}">${item.name}</option>
																	</c:forEach>
																</select>
																<p style="color:gray"></p>
															</div>
														</div>
														<div class="layui-form-item layui-form-text" id="hcelParentContent">
															<label class="layui-form-label">联系电话<p style="color:red">(*必填)</p></label>
															<div class="layui-input-block" style="width:720px">
																<input type="text"  style="display:inline;width:400px" value="" placeholder="请输入联系电话" id="hcel" class="layui-input">
																<p style="color:gray"></p>
															</div>
														</div>
														<div class="layui-form-item layui-form-text" id="helpIntroParentContent">
															<label class="layui-form-label">具体情况<p style="color:red">(*必填)</p></label>
															<div class="layui-input-block" style="width:720px">
																<textarea  placeholder="请输入具体情况"  id="helpIntro"  rows="15" cols="100"></textarea>
																<p style="color:gray"></p>
															</div>
														</div>
														<div class="layui-form-item layui-form-text" id="amountParentContent">
															<label class="layui-form-label">需要金额<p style="color:red">(*必填)</p></label>
															<div class="layui-input-block" style="width:720px">
																<input type="text"  style="display:inline;width:400px" value="" placeholder="请输入需要金额(请输入数字)" id="amount" class="layui-input">
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
								<script type="text/javascript" src="${pageContext.request.contextPath}/static/webupload/webuploader.js"></script>
								<script type="text/javascript" src="${pageContext.request.contextPath}/static/webupload/upload.js"></script>
								<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/layui/layui.js"></script>
								<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=1488"></script>
								<script type="text/javascript">
									$(function(){
									createFileUpload('${pageContext.request.contextPath}');
									})
									function submitData(){
									var hname= $('#hname').val();
									var hage= $('#hage').val();
									var hzp=getUploadFileStr('hzp')
									var hsex= $('#hsex').val();
									var hcel= $('#hcel').val();
									var helpIntro= $('#helpIntro').val();
									var amount= $('#amount').val();
									if(hage!=''){
									if(isIntNum(hage)==false){
									alert("年龄必须填入整数");
									return;
									}
									}
									if(amount!=''){
									if(isIntNum(amount)==false){
									alert("需要金额必须填入整数");
									return;
									}
									}
									$.ajax({
									type: 'post',
									url: '${pageContext.request.contextPath}/admin/help_msg/add_submit',
									data:{
									"hname":hname,
									"hage":hage,
									"hzp":hzp,
									"hsex":hsex,
									"hcel":hcel,
									"helpIntro":helpIntro,
									"amount":amount
									},
									success: function(result) {
									if(result.code == 0){
									alert(result.msg);
									}else{
									alert(result.msg);
									window.location.href="${pageContext.request.contextPath}/admin/help_msg";
									}
									}
									});
									}
								</script>
							</body>
						</html>



