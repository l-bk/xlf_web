<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>欢迎页面</title>
	<meta name="decorator" content="default"/>
	
	<style type="text/css">
		body{
			background: #f1f1f1;
		}
		.content{
			padding: 20px;
		}
		.content h3{
			padding: 10px;
		}
		.link-panel{
			display:table;
			width:100%;
			padding: 20px 0px;
			border-top: 1px solid #ccc;
		}
		.link-panel a{
			float: left;
			color: #000;
			margin: 0 10px;
			padding: 17px 5px;
			width:100px;
			border: 1px solid #ccc;
			border-radius: 5px;
			text-align: center;
			text-decoration: none;
			cursor: pointer;
		}
		.link-panel a:hover{
			background: #f8f8f8;
			color: #333;
		}
		.link-panel a i{
			font-size: 40px;
			padding-bottom:20px;
		}
		.link-panel a span{
			padding-top: 10px;
		}
	</style>
</head>
<body>
	
	<div class="content">
		<h3>欢迎登陆闲来蜂开发平台</h3>
		<div class="link-panel">
			<a href="${ctx}/ptj/xlfPartTimeJob/list">
				<i class=" icon-book"></i><br/><span>兼职信息管理</span>
			</a>
			<a href="${ctx}/activity/xlfActivity/list">
				<i class=" icon-list"></i><br/><span>活动信息管理</span>
			</a>
			<%-- <a href="${ctx}/area/xlfArea/list">
				<i class="icon-file"></i><br/><span>用户信息管理</span>
			</a> --%>
			<a href="${ctx}/area/xlfArea/list">
				<i class="icon-compass"></i><br/><span>区域信息管理</span>
			</a>
			
		</div>
	</div>
</body>
</html>