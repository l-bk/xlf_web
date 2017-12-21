<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>兼职信息</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/join/xlfJoin/joinByModule?moduleType=2&user=${xlfJoin.user}">所报名兼职列表</a></li>
		<%-- <shiro:hasPermission name="ptj:xlfPartTimeJob:edit"><li><a href="${ctx}/ptj/xlfPartTimeJob/form">兼职信息添加</a></li></shiro:hasPermission> --%>
	</ul>
	<form:form id="searchForm"  modelAttribute="xlfJoin" action="${ctx}/join/xlfJoin/joinByModule?moduleType=2&user=${xlfJoin.user}"  method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>&nbsp;兼职名称:</label>
		<form:input path="ptjName" maxlength="60"  htmlEscape="false"/>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
		&nbsp;<input id="btnCancel" class="btn btn-primary" type="button" value="返 回" onclick="history.go(-1)"/>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>兼职名称</th>
				<th>发布人</th>
				<th>发布机构</th>
				<th>兼职类型</th>
				<th>报名时间</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="xlfPartTimeJob">
			<tr>
				<td>${xlfPartTimeJob.ptjName}</td>
				<td>${xlfPartTimeJob.userName}</td>
				<td><c:if test="${xlfPartTimeJob.userRole == '1'}">
							${xlfPartTimeJob.userCompany}
						</c:if>
						<c:if test="${xlfPartTimeJob.userRole == '0'}">
							${xlfPartTimeJob.schoolName}
						</c:if></td>
				<td>${xlfPartTimeJob.jobType}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${xlfPartTimeJob.time}"/></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>