<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<s:text name="%{getText('webroot_site')}"/>/css/right.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<%=path %>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/webs_a/loadSelect.js"></script>
<script type="text/javascript" src="<%=path %>/js/webs_a/bjgl.js"></script>
<script>
window.onload = loadDepartment();
</script>
</head>
<body>
<div style="width:90%;height:50px;margin: 10px auto;text-align: center;">
	<form action="">
	<table style="height:100%;width:100%;margin: 0 auto;text-align: center;">
		<tr><td><h1 style="font-size: large;">班级信息</h1></td></tr>
		<tr><td style="background-color: red; width:90%; height:1px;"><!-- split --></td></tr>
		<tr>
		<td>
		系别：<select id="departSelect" style="width:110px;" onchange="getMajorByDept()"><option>--请选择--</option></select>
		专业<select id="majorSelect" style="width:110px;"><option>--请选择--</option></select>
		<input type="button" value="搜索" onclick="getFullClassesByMajor()"/>
		</td>
		</tr>
	</table>
	</form>
</div>
<div id="classes" style="width:90%;height:77%;margin: 10px auto;text-align: center;">
</div>
</body>
</html>
