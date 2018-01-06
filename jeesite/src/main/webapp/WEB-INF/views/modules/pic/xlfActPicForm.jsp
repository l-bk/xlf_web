<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>图片信息管理</title>
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
		<li><a href="${ctx}/pic/xlfActPic/list?type=${typeId}">图片信息列表</a></li>
		<li class="active"><a href="${ctx}/pic/xlfActPic/form?type=${typeId}">图片信息<shiro:hasPermission name="pic:xlfActPicType:view">${not empty xlfActPic.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="pic:xlfActPicType:view">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="xlfActPic" action="${ctx}/pic/xlfActPic/save?type=${typeId}" method="post" class="form-horizontal">
		<form:hidden path="picId"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">图片名：</label>
			<div class="controls" >
				<form:hidden id="name" path="name" htmlEscape="false" maxlength="255" class="input-xlarge" disabled="disabled"/>
				<sys:ckfinder input="name" type="images" uploadPath="/image" selectMultiple="false" maxWidth="100" maxHeight="100" />
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="pic:xlfActPicType:view"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>