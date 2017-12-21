<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>区域管理管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/area/xlfArea/">区域管理列表</a></li>
		<li class="active"><a href="${ctx}/area/xlfArea/form?areaId=${xlfArea.areaId}">区域管理<shiro:hasPermission name="area:xlfArea:edit">${not empty xlfArea.areaId?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="area:xlfArea:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="xlfArea" action="${ctx}/area/xlfArea/save" method="post" class="form-horizontal">
		<form:hidden path="areaId"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">省：</label>
			<div class="controls">
				<form:input path="province" htmlEscape="false" maxlength="32" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font></span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">市：</label>
			<div class="controls">
				<form:input path="city" htmlEscape="false" maxlength="32" class="input-xlarge required "/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">区：</label>
			<div class="controls">
				<form:input path="district" htmlEscape="false" maxlength="32" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">区首字母大写：</label>
			<div class="controls">
				<form:input path="cityFirst" htmlEscape="false" maxlength="2" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否为热门城市：</label>
			<div class="controls">
				<form:radiobutton path="hotCity" htmlEscape="false" maxlength="2" class="input-xlarge required" label="是" value="Y"/>
				<form:radiobutton path="hotCity" htmlEscape="false" maxlength="2" class="input-xlarge required" label="否" value="N"/>
			</div>
		</div>
		<div class="form-actions">
		<c:if test="${xlfArea.areaId == null}">
			<shiro:hasPermission name="area:xlfArea:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
		</c:if>
		<c:if test="${xlfArea.areaId != null}">
			<shiro:hasPermission name="area:xlfArea:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="修改"/>&nbsp;</shiro:hasPermission>
		</c:if>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>