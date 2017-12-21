<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>区域管理管理</title>
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
		<li class="active"><a href="${ctx}/area/xlfArea/">区域管理列表</a></li>
		<shiro:hasPermission name="area:xlfArea:edit">
			<li><a href="${ctx}/area/xlfArea/form">区域管理添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="xlfArea"
		action="${ctx}/area/xlfArea/" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
		<ul class="ul-form">
			<label>&nbsp;省:</label>
			<form:input path="province" htmlEscape="false" maxlength="50" />
			<label>&nbsp;市:</label>
			<form:input path="city" htmlEscape="false" maxlength="50" />
			<label>&nbsp;区:</label>
			<form:input path="district" htmlEscape="false" maxlength="50" />
			</br>
			</br>
			<label>&nbsp;市首字母大写:</label>
			<form:input path="cityFirst" htmlEscape="false" maxlength="50" />
			<label>&nbsp;是否为热门城市:</label>
			<form:select path="hotCity" maxlength="50">
				<form:option label="请选择" value=""/>
				<form:option label="是" value="Y" />
				<form:option label="否" value="N" />
			</form:select>
			&nbsp;&nbsp;
			<input id="btnSubmit" class="btn btn-primary" type="submit"
				value="查询" />
		</ul>
	</form:form>
	<sys:message content="${message}" />
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>省</th>
				<th>市</th>
				<th>区</th>
				<th>热门城市</th>
				<th>操作</th>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="xlfArea">
				<tr>
					<td>${xlfArea.province}</td>
					<td>${xlfArea.city}</td>
					<td>${xlfArea.district}</td>
					<td><c:choose>
							<c:when test="${xlfArea.hotCity == 'Y'}">
								<span>是</span>
							</c:when>
							<c:otherwise>
								<span>否</span>
							</c:otherwise>
						</c:choose></td>
					<shiro:hasPermission name="area:xlfArea:edit">
						<td><a
							href="${ctx}/area/xlfArea/form?areaId=${xlfArea.areaId}">修改</a> <a
							href="${ctx}/area/xlfArea/delete?areaId=${xlfArea.areaId}"
							onclick="return confirmx('确认要删除该区域管理吗？', this.href)">删除</a></td>
					</shiro:hasPermission>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>