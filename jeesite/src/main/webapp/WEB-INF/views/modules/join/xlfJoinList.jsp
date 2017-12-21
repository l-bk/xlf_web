<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>报名信息管理</title>
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
		<li class="active"><a
			href="${ctx}/join/xlfJoin/list?moduleType=${moduleType}&moduleId=${moduleId}">报名信息列表</a></li>
		<%-- <shiro:hasPermission name="join:xlfJoin:edit"><li><a href="${ctx}/join/xlfJoin/form">报名信息添加</a></li></shiro:hasPermission> --%>
	</ul>
	<form:form id="searchForm" modelAttribute="xlfJoin"
		action="${ctx}/join/xlfJoin/list" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
		<label>报名状态</label>
		<form:select path="status" >
			<form:option  htmlEscape="false" value="" label="&nbsp;请选择 "/>
			<form:option  htmlEscape="false" value="0" label="未审核 " />
			<form:option  htmlEscape="false" value="1" label="审核通过"/>
			<form:option  htmlEscape="false" value="2" label= " 取消  "/>
		</form:select>
		&nbsp;&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询" />
		&nbsp;&nbsp;<input id="btnCancel" class="btn btn-primary" type="button" value="返回"  onclick="history.go(-1)"/>
		</ul>
	</form:form>
	<sys:message content="${message}" />
	
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<c:if test="${moduleType == '2'}">
					<th>兼职名称</th>
					<th>兼职类型</th>
				</c:if>
				<c:if test="${moduleType =='1'}">
					<th>活动名称</th>
					<th>活动人数</th>
				</c:if>
				
				<th>报名人</th>
				<th>性别</th>
				<th>所属单位</th>
				<th>报名时间</th>
				<th>电话号码</th>
				<th>报名状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="xlfJoin">
				<tr>
					<c:if test="${xlfJoin.moduleType == '2'}">
						<td>${xlfJoin.ptjName}</td>
						<td>${xlfJoin.jobType}</td>
					</c:if>
					<c:if test="${xlfJoin.moduleType == '1'}">
						<td>${xlfJoin.actName}</td>
						<td>${xlfJoin.actPerson}</td>
					</c:if>
					<td>${xlfJoin.userName}</td>
					<td>
						<c:if test="${xlfJoin.userSex == '0'}">
							保密
						</c:if>
						<c:if test="${xlfJoin.userSex == '1'}">
							男
						</c:if>
						<c:if test="${xlfJoin.userSex == '2'}">
							女
						</c:if>
					</td>
					<td>
						<c:if test="${xlfJoin.userRole == '1'}">
							${xlfJoin.userCompany}
						</c:if>
						<c:if test="${xlfJoin.userRole == '0'}">
							${xlfJoin.schoolName}
						</c:if>
					</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${xlfJoin.time}"/></td>
					<td>${xlfJoin.userPhone}</td>
					<td><c:if test="${xlfJoin.status == '0'}">
						未审核
					</c:if> <c:if test="${xlfJoin.status == '1'}">
						审核通过
					</c:if> <c:if test="${xlfJoin.status == '2'}">
						取消
					</c:if></td>
					<shiro:hasPermission name="join:xlfJoin:edit">
						<td><a href="${ctx}/join/xlfJoin/updateStatus?joinId=${xlfJoin.joinId}&status=1">通过</a>
							<a href="${ctx}/join/xlfJoin/updateStatus?joinId=${xlfJoin.joinId}&status=2">不通过</a></td>
					</shiro:hasPermission>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>