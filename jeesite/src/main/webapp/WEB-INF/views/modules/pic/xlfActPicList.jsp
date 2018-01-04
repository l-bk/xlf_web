<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>图片信息管理</title>
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
		<li class="active"><a href="${ctx}/pic/xlfActPic/list?picId=${typeId}">图片信息列表</a></li>
		<shiro:hasPermission name="pic:xlfActPic:edit"><li><a href="${ctx}/pic/xlfActPic/form">图片信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="xlfActPic" action="${ctx}/pic/xlfActPic/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<!-- <input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/> -->
	</form:form>
	<sys:message content="${message}"/>
	<%-- <table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<shiro:hasPermission name="pic:xlfActPic:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="xlfActPic">
			<tr>
				<shiro:hasPermission name="pic:xlfActPic:edit"><td>
    				<a href="${ctx}/pic/xlfActPic/form?id=${xlfActPic.id}">修改</a>
					<a href="${ctx}/pic/xlfActPic/delete?id=${xlfActPic.id}" onclick="return confirmx('确认要删除该图片信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table> --%>
	
	<div>
		<label><font size="6" style="letter-spacing:0.5em;margin-left:40px;" > ${typeName}</font></label>
	</div>
	<div class="container">
		<div class="row">
		<c:forEach var="xlfActPic" items="${page.list}">
			<div class="span4"> 
				<img src="${xlfActPic.name}"/>
			</div>
		</c:forEach> 
		</div>
	</div>
	<div class="pagination">${page}</div>
</body>
</html>