<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>兼职类型信息管理管理</title>
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
		<li class="active"><a href="${ctx}/ptj/xlfPtjType/">兼职类型管理列表</a></li>
		<shiro:hasPermission name="ptj:xlfPtjType:edit">
			<li><a href="${ctx}/ptj/xlfPtjType/form">兼职类型管理添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="xlfPtjType"
		action="${ctx}/ptj/xlfPtjType/" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
		<label>&nbsp;兼职类型名称：</label>	
		<form:input path="jobType"  maxlength="50"/>&nbsp;
		<input id="btnSubmit" class="btn btn-primary"
				type="submit" value="查询" />
		</ul>
	</form:form>
	<sys:message content="${message}" />
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>类型名称</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<%
				request.setAttribute("strEnter", "\n");
				request.setAttribute("strTab", "\t");
			%>
			<c:forEach items="${page.list}" var="xlfPtjType">
				<tr>
					<td>${xlfPtjType.jobType}</td>
					<shiro:hasPermission name="ptj:xlfPtjType:edit">
						<td><a href="${ctx}/ptj/xlfPtjType/form?id=${xlfPtjType.id}">修改</a>
							<a href="${ctx}/ptj/xlfPtjType/delete?id=${xlfPtjType.id}"
							onclick="return confirmx('确认要删除该兼职类型信息管理吗？', this.href)">删除</a></td>
					</shiro:hasPermission>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>