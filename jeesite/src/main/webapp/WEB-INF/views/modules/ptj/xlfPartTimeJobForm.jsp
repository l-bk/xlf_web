<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>兼职信息管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//$("#name").focus();
						$("#inputForm").validate(
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

						//如果是运营人员（userId=‘10001’)可以修改，其他身份改为只读。只允许审核
						var userId = "${xlfPartTimeJob.userId}";
						if (userId == '10001' || userId == '0') {
							$(".input-xlarge,.input-medium").attr("disabled", false);
						}
						;

						//审核通过按钮单击
						$("#updateStatus")
								.click(
										function() {
											window.location.href = "${ctx}/ptj/xlfPartTimeJob/updateStatus?jobId=${xlfPartTimeJob.jobId}&auditStatus=1&jobName=${xlfPartTimeJob.jobName}";
										});
						//审核不通过按钮单击
						$("#updateStatus1,#updateStatus2")
								.click(
										function() {
											window.location.href = "${ctx}/ptj/xlfPartTimeJob/updateStatus?jobId=${xlfPartTimeJob.jobId}&auditStatus=2&jobName=${xlfPartTimeJob.jobName}";
										});
					});
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/ptj/xlfPartTimeJob/">兼职信息列表</a></li>
		<li class="active"><a
			href="${ctx}/ptj/xlfPartTimeJob/form?jobId=${xlfPartTimeJob.jobId}">兼职信息<shiro:hasPermission
					name="ptj:xlfPartTimeJob:edit">${not empty xlfPartTimeJob.id?'修改':'添加'}</shiro:hasPermission>
				<shiro:lacksPermission name="ptj:xlfPartTimeJob:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<br />
	<form:form id="inputForm" modelAttribute="xlfPartTimeJob"
		action="${ctx}/ptj/xlfPartTimeJob/save" method="post"
		class="form-horizontal">
		<form:hidden path="jobId" />
		<sys:message content="${message}" />
		<div class="control-group">
			<label class="control-label">兼职名称：</label>
			<div class="controls">
				<form:input path="jobName" htmlEscape="false" maxlength="256"
					class="input-xlarge required" disabled="true" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">兼职限定人数：</label>
			<div class="controls">
				<form:input path="limitNumber" htmlEscape="false" maxlength="64"
					class="input-xlarge " disabled="true" />
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">性别要求：</label>
			<div class="controls">
				<form:radiobutton path="sexDemand" htmlEscape="false" maxlength="3"
					class="input-xlarge required" label="男" value="1" disabled="true" />
				<form:radiobutton path="sexDemand" htmlEscape="false" maxlength="3"
					class="input-xlarge required" label="女" value="2" disabled="true" />
				<form:radiobutton path="sexDemand" htmlEscape="false" maxlength="3"
					class="input-xlarge required" label="不限制" value="3" disabled="true" />
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">兼职类型</label>
			<div class="controls">
				<form:select path="jobTypeId" htmlEscape="false" maxlength="64"
					class="input-xlarge required " disabled="true">
					<form:option value="" label="请选择" disabled="true" class="select"></form:option>
					<c:forEach var="type" items="${typeList}">
						<form:option value="${type.id}" label="${type.jobType}" class="select"
							></form:option>
					</c:forEach>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">兼职工资：</label>
			<div class="controls">
				<form:input path="wage" htmlEscape="false"
					class="input-xlarge required" disabled="true" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">工资单位：</label>
			<div class="controls">
				<form:input path="wageType" htmlEscape="false" maxlength="32"
					class="input-xlarge required" disabled="true" />
				<span class="help-inline"><font color="red">*</font><font
					color="gray">例:元/天</font> </span>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">结款方式 ：</label>
			<div class="controls required">
				<form:radiobutton path="calculateMoneyType" htmlEscape="false"
					maxlength="3" class="input-xlarge" label="日结" value="1"
					disabled="true" />
				<form:radiobutton path="calculateMoneyType" htmlEscape="false"
					maxlength="3" class="input-xlarge" label="周结" value="2"
					disabled="true" />
				<form:radiobutton path="calculateMoneyType" htmlEscape="false"
					maxlength="3" class="input-xlarge" label="月结" value="3"
					disabled="true" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">结款日期：</label>
			<div class="controls">
				<form:input path="calculateMoneyDate" htmlEscape="false"
					maxlength="10" class="input-xlarge " disabled="true" />
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">经度：</label>
			<div class="controls">
				<form:input path="longitude" htmlEscape="false"
					class="input-xlarge required" disabled="true" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">纬度：</label>
			<div class="controls">
				<form:input path="latitude" htmlEscape="false"
					class="input-xlarge required" disabled="true" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>


		<%-- <div class="control-group">
			<label class="control-label">区域：</label>
			<div class="controls">
				<form:select path="areaId" htmlEscape="false" class="input-xlarge">
					<c:forEach items="areaList" var="area">
						<form:option label="${area}" value="${area.areaId}"/>
					</c:forEach>
				</form:select>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">工作省：</label>
			<div class="controls">
				<form:input path="workProvince" htmlEscape="false" maxlength="256"
					class="input-xlarge required" disabled="true" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">工作市：</label>
			<div class="controls">
				<form:input path="workCity" htmlEscape="false" maxlength="256"
					class="input-xlarge required" disabled="true" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">工作区：</label>
			<div class="controls">
				<form:input path="workDistrict" htmlEscape="false" maxlength="256"
					class="input-xlarge required" disabled="true" />
				<span class="help-inline"><font color="red">*</font></span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">工作街道：</label>
			<div class="controls">
				<form:input path="workStreet" htmlEscape="false" maxlength="256"
					class="input-xlarge required" disabled="true" />
				<span class="help-inline"><font color="red">*</font> <!-- <font color=""gray>例:广东省广州市天河区xx街道</font> --></span>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">开始工作日期：</label>
			<div class="controls">
				<input name="startWorkDate" type="text" readonly="readonly"
					maxlength="20" class="input-medium Wdate required"
					value="<fmt:formatDate value="${xlfPartTimeJob.startWorkDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"
					disabled="true" /> <span class="help-inline"><font
					color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">结束工作日期：</label>
			<div class="controls">
				<input name="endWorkDate" type="text" readonly="readonly"
					maxlength="20" class="input-medium Wdate  "
					value="<fmt:formatDate value="${xlfPartTimeJob.endWorkDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"
					disabled="true" /> <span class="help-inline "><font
					color="red">*</font> </span>
			</div>
		</div>



		<div class="control-group">
			<label class="control-label">工作时间段：</label>
			<div class="controls">
				<form:input path="workTime" htmlEscape="false" maxlength="128"
					class="input-xlarge required" disabled="true" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>


		<div class="control-group">
			<label class="control-label">工作内容：</label>
			<div class="controls">
				<form:textarea path="jobContent" htmlEscape="false" maxlength="200"
					id="content" rows="4" stlye="width:95%" class="input-xlarge "
					disabled="true" />
				<sys:ckeditor replace="content" uploadPath="/ptj" />
			</div>
		</div>

		<%-- 	<div class="control-group">
			<label class="control-label">用户：</label>
			<div class="controls">
				<form:input path="userName" htmlEscape="false" maxlength="10"
					class="input-xlarge " />
			</div>
		</div> --%>
		<c:if test="${xlfPartTimeJob.jobId != null }">
			<div class="control-group">
				<label class="control-label">审核状态：</label>
				<div class="controls">
					<form:radiobutton path="auditStatus" htmlEscape="false" value="0"
						label="未审核" class="input-xlarge " disabled="true" />
					<form:radiobutton path="auditStatus" htmlEscape="false" value="1"
						label="审核通过" class="input-xlarge " disabled="true" />
					<form:radiobutton path="auditStatus" htmlEscape="false" value="2"
						label="已下架" class="input-xlarge " disabled="true" />
				</div>
				</div>
				<c:if test="${xlfPartTimeJob.userId != '10001'}">
					<div class="control-group">
						<label class="control-label">创建人</label>
						<div class="controls">
							<form:input path="userName" htmlEscape="false"
								class="input-xlarge" readOnly="true"/>
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label">创建人手机</label>
						<div class="controls">
							<form:input path="userPhone" htmlEscape="false"
								class="input-xlarge" readOnly="true"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label">创建机构</label>
						<div class="controls">
							<c:if test="${xlfPartTimeJob.userRole == '1' }">
								<form:input path="userCompany" htmlEscape="false"
									class="input-xlarge" readOnly="true"/>
							</c:if>
							<c:if test="${xlfPartTimeJob.userRole == '0' }">
								<form:input path="schoolName" htmlEscape="false"
									class="input-xlarge" readOnly="true" />
							</c:if>
						</div>
					</div>
				</c:if>
		</c:if>

		<div class="form-actions">

			<c:if test="${xlfPartTimeJob.jobId == null }">
				<shiro:hasPermission name="ptj:xlfPartTimeJob:edit">
					<input id="btnSubmit" class="btn btn-primary" type="submit"
						value="保 存" />&nbsp;</shiro:hasPermission>

			</c:if>

			<c:if test="${xlfPartTimeJob.jobId != null }">
				<c:if test="${xlfPartTimeJob.userId == '10001' }">
					<shiro:hasPermission name="ptj:xlfPartTimeJob:edit">
						<input id="btnSubmit" class="btn btn-primary" type="submit"
							value="修改" />&nbsp;</shiro:hasPermission>
				</c:if>

				<c:if test="${xlfPartTimeJob.auditStatus == '0' }">
					<shiro:hasPermission name="ptj:xlfPartTimeJob:edit">
						<input id="updateStatus" class="btn btn-primary" type="button"
							value="审核通过" />&nbsp;	
					<input id="updateStatus1" class="btn btn-primary" type="button"
							value="审核不通过" />&nbsp;	
					</shiro:hasPermission>
				</c:if>
				<c:if test="${xlfPartTimeJob.auditStatus == '1' }">
					<shiro:hasPermission name="ptj:xlfPartTimeJob:edit">
						<input id="updateStatus2" class="btn btn-primary" type="button"
							value="下架" />
					</shiro:hasPermission>
				</c:if>
			</c:if>

			<input id="btnCancel" class="btn" type="button" value="返 回"
				onclick="history.go(-1)" />
		</div>
	</form:form>
</body>
</html>