<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>图片类型管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function() {

	});
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/pic/xlfActPicType/">图片类型列表</a></li>
		<shiro:hasPermission name="pic:xlfActPicType:edit">
			<li><a href="${ctx}/pic/xlfActPicType/form">图片类型添加</a></li>
		</shiro:hasPermission>
	</ul>
	<sys:message content="${message}" />
	<form:form id="searchForm" modelAttribute="xlfActPicType" action="${ctx}/pic/xlfActPicType/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
			<!-- <input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/> -->
	</form:form>
	<table id="contentTable" class="table table-striped table-bordered table-condensed" style="width:60%">
		<thead>
			<tr>
				<th>图片类型</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="xlfActPicType">
			<tr>
				<td>${xlfActPicType.picTypeName}</td>
				<td>
				<shiro:hasPermission name="pic:xlfActPicType:view">
					<a href="${ctx}/pic/xlfActPic/list?type=${xlfActPicType.picTypeId}">查看图片</a>
				</shiro:hasPermission>
				<shiro:hasPermission name="pic:xlfActPicType:edit">
    				<a href="${ctx}/pic/xlfActPicType/form?picTypeId=${xlfActPicType.picTypeId}">修改</a>
					<a href="${ctx}/pic/xlfActPicType/delete?picTypeId=${xlfActPicType.picTypeId}" onclick="return confirmx('确认要删除该图片类型及对应图片吗？', this.href)">删除</a>
				</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>