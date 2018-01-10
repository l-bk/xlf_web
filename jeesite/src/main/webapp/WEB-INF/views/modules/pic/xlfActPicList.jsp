<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>图片信息管理</title>
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
<style>
	img{
		width:120px;
		height:80px;
	}
</style>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a
			href="${ctx}/pic/xlfActPic/list?type=${typeId}">图片信息列表</a></li>
		<shiro:hasPermission name="pic:xlfActPic:edit">
			<li><a href="${ctx}/pic/xlfActPic/form">图片信息添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="xlfActPic"
		action="${ctx}/pic/xlfActPic/" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
		<div>
			<label><font size="6"
				style="letter-spacing: 0.5em; margin-left: 10px;">
					${typeName}</font></label>
			<shiro:hasPermission name="pic:xlfActPicType:view">
				<a href="${ctx}/pic/xlfActPic/form?type=${typeId}" style="margin-left:40px;">添加图片</a>
			</shiro:hasPermission>
		</div>

		<!-- <input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/> -->
	</form:form>
	<sys:message content="${message}" />

	<table id="contentTable"
		class="table table-striped table-bordered table-condensed"
		style="margin-left: 10px; width: 80%">
		<thead>
			<tr>
				<th  style="text-align:center;">图片</th>
				<th  >图片路径</th>
				<th  style="text-align:center;">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="xlfActPic">
				<tr>
					<td  style="text-align:center;"><img src="${xlfActPic.name}" width="100px" height="100px"/></td>
					<td  >${xlfActPic.name}</td>
					<shiro:hasPermission name="pic:xlfActPicType:view">
						<td style="text-align:center;">
							<%-- <a href="${ctx}/pic/xlfActPic/form?type=${xlfActPic.id}">修改</a> --%>
							<a href="${ctx}/pic/xlfActPic/delete?picId=${xlfActPic.picId}&type=${typeId}"
							onclick="return confirmx('确认要删除该图片吗？', this.href)">删除</a>
						</td>
					</shiro:hasPermission>
				</tr>

			</c:forEach>
		</tbody>
	</table>
	<%-- 
	<div class="container-fluid">
				<div class="row">
					<c:forEach var="xlfActPic" items="${page.list}">
						<div class="span5">
							<img src="${xlfActPic.name}" />
						</div>
					</c:forEach>
				</div>
			</div>
	 --%>
	<div class="pagination">${page}</div>
</body>
</html>