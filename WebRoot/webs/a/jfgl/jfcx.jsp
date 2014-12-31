<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>查询</title>
<link href="<s:text name="%{getText('webroot_site')}"/>/css/right.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<%=path %>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/webs_a/loadSelect.js"></script>
<script type="text/javascript" src="<%=path %>/js/webs_a/jfgl.js"></script>
<script>
window.onload = loadDepartment();
</script>
</head>
<body style="height: 90%;width: 100%;">
<div style="width:90%;height:50px;margin: 10px auto;text-align: center;">
	<form action="">
	<table style="height:100%;width:100%;margin: 0 auto;text-align: center;">
		<tr><td>
		<div style="margin-top: 20px;">
		<h1 style="font-size: large;">交费记录</h1>
		</div>
		</td></tr>
		<tr><td style="background-color: red; width:90%; height:1px;"><!-- split --></td></tr>
		<tr>
		<td>
		系别：<select id="departSelect" style="width:110px;" onchange="getMajorByDept()"><option>--请选择--</option></select>
		专业：<select id="majorSelect" style="width:110px;" onchange="getClassByMajor()"><option>--请选择--</option></select>
		班级：<select id="classSelect" name="class" style="width:110px;"><option>--请选择--</option></select>
		<input type="button" value="搜索" onclick="getJfsByClass()"/>
		</td>
		</tr>
	</table>
	</form>
</div>
<div id="list" style="width:100%;height:77%;margin: 10px auto;text-align: center;">
</div>
</body>
</html>
