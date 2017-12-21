<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户信息模块管理</title>
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
		<li class="active"><a href="${ctx}/user/xlfUser/">用户信息模块列表</a></li>
		<%-- <shiro:hasPermission name="user:xlfUser:edit"><li><a href="${ctx}/user/xlfUser/form">用户信息模块添加</a></li></shiro:hasPermission> --%>
	</ul>
	<form:form id="searchForm" modelAttribute="xlfUser" action="${ctx}/user/xlfUser/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>用户名称</label>
		<form:input path="userName" maxlength="60" htmlEscape="false"/>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>用户名称</th>
				<th>年龄</th>
				<th>性别</th>
				<th>身高</th>
				<th>电话号码</th>
				<th>角色</th>
				<th>所属单位</th>
				<th>用户简历</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="xlfUser">
			<tr>
				<td>${xlfUser.userName}</td>
				<td>${xlfUser.userAge}</td>
				<td>
					<c:if test="${xlfUser.userSex == '0'}">
						保密
					</c:if>
					<c:if test="${xlfUser.userSex == '1'}">
						男
					</c:if>
					<c:if test="${xlfUser.userSex == '2'}">
						女
					</c:if>
				</td>
				<td>${xlfUser.userHigh}</td>
				<td>${xlfUser.userPhone}</td>
				
					<c:if test="${xlfUser.userRole == '0'}">
						<td>学生</td>
						<td>${xlfUser.schoolName}</td>
						
					</c:if>
					<c:if test="${xlfUser.userRole  == '1'}">
						<td>公司代理人</td>
						<td>${xlfUser.userCompany}</td>
					</c:if>
					<td>${xlfUser.userDetails}</td>
					<td></td>
				<shiro:hasPermission name="join:xlfJoin:edit"><td>
    				<a href="${ctx}/join/xlfJoin/joinByModule?user=${xlfUser.userId}&moduleType=1">所报名活动</a>
    				<a href="${ctx}/join/xlfJoin/joinByModule?user=${xlfUser.userId}&moduleType=2">所报名兼职</a>
    				
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>