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
	<%-- 
	<form:form id="searchForm" modelAttribute="xlfActPicType" action="${ctx}/pic/xlfActPicType/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<shiro:hasPermission name="pic:xlfActPicType:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="xlfActPicType">
			<tr>
				<shiro:hasPermission name="pic:xlfActPicType:edit"><td>
    				<a href="${ctx}/pic/xlfActPicType/form?id=${xlfActPicType.id}">修改</a>
					<a href="${ctx}/pic/xlfActPicType/delete?id=${xlfActPicType.id}" onclick="return confirmx('确认要删除该图片类型吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div> --%>

	<shiro:hasPermission name="pic:xlfActPicType:edit">
		<div class="row">
			<c:forEach var="xlfActPicType" items="${page.list}">
				<ul class="nav-pills nav-stacked ">
					<li>${xlfActPicType.picTypeName }</li>
				</ul>
			</c:forEach>
		</div>


		<div class="row ">
			<div class="span12">
				<div class ="container">
				
				</div>
				<div class="row">
					<div class="span2 offset1">Level 2</div>
					<div class="span2 offset1">Level 2</div>
				</div>
			</div>
		</div>


	</shiro:hasPermission>

</body>
</html>