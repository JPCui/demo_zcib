<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path404 = request.getContextPath();
String basePath404 = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path404;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta content="IE=8" http-equiv="X-UA-Compatible"/>
<title>404</title>
<style>
#error{
height:300px;
width:400px;
margin:40px auto;
background:url('<%=path404 %>/img/404.jpg') no-repeat top center;
padding-top:1px;
}
.exp{
color:#888;
margin-top:220px;
}
#btn_save{
margin:20px auto 0 157px;
}
</style>
</head>
<body>

<div class="list center">
	<div id="error">
	<div class="exp">
	很抱歉，您访问的网页暂时无法提供服务。<br/>
	我们大致猜测，您可能不小心访问了错误的页面。<br/>
	这也可能是或许是我们的故障如果您确信这是我们的问题，请告诉我们。
	</div>
	<a class="save f12 b" id="btn_save" href="<%=basePath404 %>">返回主页</a>
	<a>正在返回...</a>
	</div>
	
	<div class="invisible-clear"></div>
</div>
<div class="invisible-clear"></div>
</body>
</html>