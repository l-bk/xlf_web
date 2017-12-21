<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>兼职信息管理</title>
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
		<li class="active"><a href="${ctx}/ptj/xlfPartTimeJob/">兼职信息列表</a></li>
		<shiro:hasPermission name="ptj:xlfPartTimeJob:edit"><li><a href="${ctx}/ptj/xlfPartTimeJob/form">兼职信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="xlfPartTimeJob" action="${ctx}/ptj/xlfPartTimeJob/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>&nbsp;兼职名称:</label>
		<form:input path="jobName" maxlength="60"  htmlEscape="false"/>&nbsp;
		<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>兼职名称</th>
				<th>发布人</th>
				<th>发布机构</th>
				<th>兼职类型</th>
				<th>工作街道</th>
				<th>发布时间</th>
				<th>工作日期</th>
				<th>审核状态</th>
				
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="xlfPartTimeJob">
			<tr>
				<td>${xlfPartTimeJob.jobName}</td>
				<td>${xlfPartTimeJob.userName}</td>
				
				<td>
					<c:if test="${xlfPartTimeJob.userRole == '0'}">
						${xlfPartTimeJob.schoolName}
					</c:if>
					<c:if test="${xlfPartTimeJob.userRole == '1'}">
						${xlfPartTimeJob.userCompany}
					</c:if>
				</td>
				
				<td>${xlfPartTimeJob.jobType}</td>
				<td>${xlfPartTimeJob.address}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${xlfPartTimeJob.releaseTime}"/></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"  value="${xlfPartTimeJob.startWorkDate}"/></td>
				<td>
					<c:if test="${xlfPartTimeJob.auditStatus == '0' }">
						未审核
					</c:if>
					<c:if test="${xlfPartTimeJob.auditStatus == '1' }">
						审核通过
					</c:if>
					<c:if test="${xlfPartTimeJob.auditStatus =='2' }">
						已取消
					</c:if>
				</td>
				<shiro:hasPermission name="ptj:xlfPartTimeJob:edit"><td>
				<c:if test="${xlfPartTimeJob.userId == '10001'}">
    				<a href="${ctx}/ptj/xlfPartTimeJob/form?jobId=${xlfPartTimeJob.jobId}">修改</a>
					<a href="${ctx}/ptj/xlfPartTimeJob/delete?jobId=${xlfPartTimeJob.jobId}" onclick="return confirmx('确认要删除该兼职信息吗？', this.href)">删除</a>
					<a href="${ctx}/ptj/xlfPartTimeJob/updateStatus?jobId=${xlfPartTimeJob.jobId}&auditStatus=0&jobName=${xlfPartTimeJob.jobName}">取消</a>
				</c:if>
				<c:if test="${xlfPartTimeJob.userId != '10001'}">
					<c:if test="${xlfPartTimeJob.auditStatus == '0' }">
							<a href="${ctx}/ptj/xlfPartTimeJob/updateStatus?jobId=${xlfPartTimeJob.jobId}&auditStatus=1&jobName=${xlfPartTimeJob.jobName}">审核通过</a>
							<a href="${ctx}/ptj/xlfPartTimeJob/updateStatus?jobId=${xlfPartTimeJob.jobId}&auditStatus=2&jobName=${xlfPartTimeJob.jobName}">审核不通过</a>
						</c:if>
						<c:if test="${xlfPartTimeJob.auditStatus  == '1'}">
							<a href="${ctx}/ptj/xlfPartTimeJob/updateStatus?jobId=${xlfPartTimeJob.jobId}&auditStatus=2&jobName=${xlfPartTimeJob.jobName}">取消</a>
						</c:if>
						<c:if test="${xlfPartTimeJob.auditStatus  == '2' }">
							<a href="${ctx}/ptj/xlfPartTimeJob/updateStatus?jobId=${xlfPartTimeJob.jobId}&auditStatus=0&jobName=${xlfPartTimeJob.jobName}"></a>
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