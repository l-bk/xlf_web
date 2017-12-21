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
		<li class="active"><a href="${ctx}/activity/xlfActivity/">活动信息管理列表</a></li>
		<shiro:hasPermission name="activity:xlfActivity:edit"><li><a href="${ctx}/activity/xlfActivity/form">活动信息管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="xlfActivity" action="${ctx}/activity/xlfActivity/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label >&nbsp;活动名称:</label>
		<form:input path="name" htmlEscape="false" maxlength="60"/>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
			<th><id></id>
				<th>活动名称</th>
				<th>创建人</th>
				<th>活动位置</th>
				<th>活动人数</th>
				<th>活动开始时间</th>
				<th>活动结束时间</th>
				<th>审核状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="xlfActivity">
			<tr>
				<td>${xlfActivity.createUser}</td>
				<td>${xlfActivity.name}</td>
				<td>${xlfActivity.userName}</td>
				<td>${xlfActivity.address}</td>
				<td>${xlfActivity.person}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${xlfActivity.startTime}"/></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${xlfActivity.endTime}"/></td>
				<td>
					<c:if test="${xlfActivity.status == '0' }">
						未审核
					</c:if>
					<c:if test="${xlfActivity.status == '1' }">
						审核通过
					</c:if>
					<c:if test="${xlfActivity.status =='2' }">
						结束报名
					</c:if>
				</td>
				<shiro:hasPermission name="activity:xlfActivity:edit"><td>
					<c:if test="${xlfActivity.createUser == '10001'}">
	    				<a href="${ctx}/activity/xlfActivity/form?actId=${xlfActivity.actId}">修改</a>
						<a href="${ctx}/activity/xlfActivity/delete?actId=${xlfActivity.actId}" onclick="return confirmx('确认要删除该活动信息管理吗？', this.href)">删除</a>
						<a href="${ctx}/activity/xlfActivity/updateStatus?actId=${xlfActivity.actId}&status=2&name=${xlfActivity.name}">取消</a>
					</c:if>
					<c:if test="${xlfActivity.createUser != '10001'}">
						<c:if test="${xlfActivity.status == '0' }">
							<a href="${ctx}/activity/xlfActivity/updateStatus?actId=${xlfActivity.actId}&status=1&name=${xlfActivity.name}">审核通过</a>
							<a href="${ctx}/activity/xlfActivity/updateStatus?actId=${xlfActivity.actId}&status=2&name=${xlfActivity.name}">审核不通过</a>
						</c:if>
						<c:if test="${xlfActivity.status == '1'}">
							<a href="${ctx}/activity/xlfActivity/updateStatus?actId=${xlfActivity.actId}&status=2&name=${xlfActivity.name}">取消</a>
						</c:if>
						<c:if test="${xlfActivity.status == '2' }">
							<a href="${ctx}/activity/xlfActivity/updateStatus?actId=${xlfActivity.actId}&status=0&name=${xlfActivity.name}"></a>
						</c:if>
					</c:if>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>