

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
							<title>修改-用户</title>
							<link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/layui/css/layui.css">
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
											<legend>修改-用户</legend>
											<div class="layui-field-box">
												<div >
													<div class="layui-form-item layui-form-text" id="loginNameParentContent">
														<label class="layui-form-label">登录名<p style="color:red">(*必填)</p></label>
														<div class="layui-input-block" style="width:720px">
															<input type="text"  style="display:inline;width:400px" value="${data.loginName}" placeholder="请输入登录名" id="loginName" class="layui-input">
															<p style="color:gray"></p>
														</div>
													</div>
													<div class="layui-form-item layui-form-text" id="passwordParentContent">
														<label class="layui-form-label">密码<p style="color:red">(*必填)</p></label>
														<div class="layui-input-block" style="width:720px">
															<input type="text"  style="display:inline;width:400px" value="${data.password}" placeholder="请输入密码" id="password" class="layui-input">
															<p style="color:gray"></p>
														</div>
													</div>
													<div class="layui-form-item layui-form-text" id="realNameParentContent">
														<label class="layui-form-label">昵称<p style="color:red">(*必填)</p></label>
														<div class="layui-input-block" style="width:720px">
															<input type="text"  style="display:inline;width:400px" value="${data.realName}" placeholder="请输入昵称" id="realName" class="layui-input">
															<p style="color:gray"></p>
														</div>
													</div>
													<div class="layui-form-item layui-form-text" id="celPhoneParentContent">
														<label class="layui-form-label">联系电话<p style="color:red">(*必填)</p></label>
														<div class="layui-input-block" style="width:720px">
															<input type="text"  style="display:inline;width:400px" value="${data.celPhone}" placeholder="请输入联系电话" id="celPhone" class="layui-input">
															<p style="color:gray"></p>
														</div>
													</div>
													<div class="layui-form-item layui-form-text" id="addressParentContent">
														<label class="layui-form-label">地址<p style="color:red">(*必填)</p></label>
														<div class="layui-input-block" style="width:720px">
															<input type="text"  style="display:inline;width:400px" value="${data.address}" placeholder="请输入地址" id="address" class="layui-input">
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
							<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/layui/layui.js"></script>
							<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=1739"></script>
							<script type="text/javascript">
								$(function(){
								})
								function submitData(){
								var loginName= $('#loginName').val();
								var password= $('#password').val();
								var realName= $('#realName').val();
								var celPhone= $('#celPhone').val();
								var address= $('#address').val();
								$.ajax({
								type: 'post',
								url: '${pageContext.request.contextPath}/admin/user_msg/update_submit',
								data:{
								"id":'${data.id}',
								"loginName":loginName,
								"password":password,
								"realName":realName,
								"celPhone":celPhone,
								"address":address
								},
								success: function(result) {
								if(result.code == 0){
								alert(result.msg);
								}else{
								alert(result.msg);
								window.location.href="${pageContext.request.contextPath}/admin/user_msg";
								}
								}
								});
								}
							</script>
						</body>
					</html>



