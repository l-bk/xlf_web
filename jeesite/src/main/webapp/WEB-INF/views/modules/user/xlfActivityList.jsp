<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>活动信息管理管理</title>
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
		<li class="active"><a href="${ctx}/join/xlfJoin/joinByModule?moduleType=1&user=${xlfJoin.user}">活动信息管理列表</a></li>
		<%-- <shiro:hasPermission name="activity:xlfActivity:edit"><li><a href="${ctx}/activity/xlfActivity/form">活动信息管理添加</a></li></shiro:hasPermission> --%>
	</ul>
	<form:form id="searchForm" modelAttribute="xlfJoin" action="${ctx}/join/xlfJoin/joinByModule?moduleType=1&user=${xlfJoin.user}" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label >&nbsp;活动名称:</label>
		<form:input path="actName" htmlEscape="false" maxlength="60"/>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
		&nbsp;<input id="btnCancel" class="btn btn-primary" type="button" value="返 回" onclick="history.go(-1)"/>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>活动名称</th>
				<th>创建人</th>
				<th>创建机构</th>
				<th>活动人数</th>
				<th>报名时间</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="xlfActivity">
			<tr>
				<td>${xlfActivity.actName}</td>
				<td>${xlfActivity.userName}</td>
				<td><c:if test="${xlfActivity.userRole == '1'}">
							${xlfActivity.userCompany}
						</c:if>
						<c:if test="${xlfActivity.userRole == '0'}">
							${xlfActivity.schoolName}
						</c:if>
				</td>
				<td>${xlfActivity.actPerson}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${xlfActivity.time}"/></td>
				
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>