<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>活动信息管理管理</title>
<meta name="decorator" content="default" />

<script type="text/javascript">
	$(document).ready(
			function() {
				//$("#name").focus();
				$("#inputForm")
						.validate(
								{
									submitHandler : function(form) {
										loading('正在提交，请稍等...');
										form.submit();
									},
									errorContainer : "#messageBox",
									errorPlacement : function(error, element) {
										$("#messageBox").text("输入有误，请先更正。");
										if (element.is(":checkbox")
												|| element.is(":radio")
												|| element.parent().is(
														".input-append")) {
											error.appendTo(element.parent()
													.parent());
										} else {
											error.insertAfter(element);
										}
									}
								});
				
				//只有运营用户才能修改信息，其他为只读
				var newActId = "${xlfActivity.createUser}";
				if(newActId == '10001' || newActId.length == '0'){
					$(".input-xlarge,.input-medium").attr("disabled",false);
				};
				//审核通过单击事件
				$("#updateStatus").click(
					function(){
						window.location.href="${ctx}/activity/xlfActivity/updateStatus?actId=${xlfActivity.actId}&status=1&name=${xlfActivity.name}";
					}		
				);
				
				//审核不通过，下架单击事件
				$("#updateStatus1,#updateStatus2").click(
					function(){
						window.location.href="${ctx}/activity/xlfActivity/updateStatus?actId=${xlfActivity.actId}&status=2&name=${xlfActivity.name}";
					}		
				)
			});
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/activity/xlfActivity/">活动信息管理列表</a></li>
		<li class="active"><a
			href="${ctx}/activity/xlfActivity/form?actId=${xlfActivity.actId}">活动信息管理<shiro:hasPermission
					name="activity:xlfActivity:edit">${not empty xlfActivity.actId?'修改':'添加'}</shiro:hasPermission>
				<shiro:lacksPermission name="activity:xlfActivity:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<br />
	<form:form id="inputForm" modelAttribute="xlfActivity"
		action="${ctx}/activity/xlfActivity/save" method="post"
		class="form-horizontal">
		<form:hidden path="actId" />
		<sys:message content="${message}" />
		<div class="control-group">
			<label class="control-label">活动名称：</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="30"
					class="input-xlarge required" disabled="true"/>
				<span><font color="red">*</font></span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否校园活动：</label>
			<div class="controls">
				<form:radiobutton path="ifSchool" htmlEscape="false"
					value="0" label="是" class="input-xlarge required" disabled="true"/>
				<form:radiobutton path="ifSchool" htmlEscape="false"
					value="1" label="否" class="input-xlarge required" disabled="true"/>
				<span><font color="red">*</font></span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">活动图片：</label>
			<div class="controls" >
				<form:hidden id="pic" path="pic" htmlEscape="false" maxlength="255" class="input-xlarge" disabled="disabled"/>
				<sys:ckfinder input="pic" type="images" uploadPath="/activity" selectMultiple="false" maxWidth="100" maxHeight="100" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">活动省份：</label>
			<div class="controls">
				<form:input path="province" htmlEscape="false"
					maxlength="10" class="input-xlarge required" disabled="true"/>
				<span><font color="red">*</font></span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">活动市：</label>
			<div class="controls">
				<form:input path="city" htmlEscape="false" maxlength="20"
					class="input-xlarge required" disabled="true"/>
				<span><font color="red">*</font></span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">活动区：</label>
			<div class="controls">
				<form:input path="district" htmlEscape="false"
					maxlength="20" class="input-xlarge required" disabled="true"/>
				<span><font color="red">*</font></span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">活动位置：</label>
			<div class="controls">
				<form:input path="location" htmlEscape="false"
					maxlength="30" class="input-xlarge required" disabled="true"/>
				<span><font color="red">*</font></span>
			</div>
		</div>
		<%-- <div class="control-group">
			<label class="control-label">活动门牌号：</label>
			<div class="controls">
				<form:input path="door" htmlEscape="false"
					maxlength="20" class="input-xlarge required" disabled="true"/>
				<span><font color="red">*</font></span>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">纬度：</label>
			<div class="controls">
				<form:input path="latitude" htmlEscape="false"
					class="input-xlarge required" disabled="true"/>
				<span><font color="red">*</font></span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">经度：</label>
			<div class="controls">
				<form:input path="longitude" htmlEscape="false"
					class="input-xlarge required" disabled="true"/>
				<span><font color="red">*</font></span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">活动人数：</label>
			<div class="controls">
				<form:input path="person" htmlEscape="false" maxlength="10"
					class="input-xlarge " disabled="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">活动开始时间：</label>
			<div class="controls">
				<input name="startTime" type="text" readonly="readonly"
					maxlength="20" class="input-medium Wdate required" disabled="true"
					value="<fmt:formatDate value="${xlfActivity.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});" />
				<span><font color="red">*</font></span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">活动结束时间：</label>
			<div class="controls">
				<input name="endTime" type="text" readonly="readonly"
					maxlength="20" class="input-medium Wdate " disabled="true"
					value="<fmt:formatDate value="${xlfActivity.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});" />
			</div>
		</div>
		</div>
		<div class="control-group">
			<label class="control-label">活动详情：</label>
			<div class="controls">
				<form:textarea path="details" htmlEscape="false"
					maxlength="200" id="content" rows="4" stlye="width:95%"
					class="input-xlarge " disabled="true"/>
				<sys:ckeditor replace="content" uploadPath="/activity" />
			</div>
		</div>

		<c:if test="${ xlfActivity.actId != null }">
			<div class="control-group">
				<label class="control-label">审核状态：</label>
				<div class="controls">
					<form:radiobutton path="status" htmlEscape="false"
						value="0" label="未审核" class="input-xlarge " disabled="true"/>
					<form:radiobutton path="status" htmlEscape="false"
						value="1" label="审核通过" class="input-xlarge " disabled="true"/>
					<form:radiobutton path="status" htmlEscape="false"
						value="2" label="已下架" class="input-xlarge " disabled="true"/>
				</div>
			</div>
			
				<div class="control-group">
					<label class="control-label">创建人：</label>
					<div class="controls">
						<form:input path="userName" htmlEscape="false" class="input-xlarge" readOnly="true"/>
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label">创建人手机：</label>
					<div class="controls">
						<form:input path="userPhone" htmlEscape="false" class="input-xlarge" readOnly="true"/>
					</div>
				</div>
				
				<div class="control-gourp">
					<label class="control-label">创建机构：</label>
					<div class="controls">
						<c:if test="${xlfActivity.userRole == '1' }">
							<form:input path="userCompany" htmlEscape="false" class="input-xlarge" readOnly="true"/>
						</c:if>
						<c:if test="${xlfActivity.userRole == '0' }">
							<form:input path="schoolName" htmlEscape="false" class="input-xlarge" readOnly="true"/>
						</c:if>	
					</div>
				</div>
		</c:if>
		
		<div class="form-actions">
			<c:if test="${xlfActivity.actId == null}">
				<shiro:hasPermission name="activity:xlfActivity:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit"
					value="保 存" />&nbsp;</shiro:hasPermission>
			</c:if>
			
			<c:if test="${xlfActivity.actId != null }">
				<c:if test="${xlfActivity.createUser == '10001'}">
					<shiro:hasPermission name="activity:xlfActivity:edit">
					<input id="btnSubmit" class="btn btn-primary" type="submit"
						value="修改" />&nbsp;</shiro:hasPermission>
				</c:if>
				<c:if test="${xlfActivity.status == '0'}">
				<shiro:hasPermission name="activity:xlfActivity:edit">
					<input id="updateStatus" class="btn btn-primary" type="button"
					value="审核通过" />&nbsp;
					<input id="updateStatus1" class="btn btn-primary" type="button"
					value="审核不通过" />&nbsp;</shiro:hasPermission>
				</c:if>	
				<c:if test="${xlfActivity.status == '1'}">
				<shiro:hasPermission name="activity:xlfActivity:edit">
					<input id="updateStatus2" class="btn btn-primary" type="button"
					value="下架" />&nbsp;</shiro:hasPermission>
				</c:if>
			</c:if>
			
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)" />
		</div>
	</form:form>
</body>
</html>