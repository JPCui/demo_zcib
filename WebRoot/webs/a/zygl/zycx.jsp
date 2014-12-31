<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>bjcx</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<s:text name="%{getText('webroot_site')}"/>/css/right.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<%=path %>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/webs_a/loadSelect.js"></script>
<script type="text/javascript" src="<%=path %>/js/webs_a/bjgl.js"></script>
<script>
function searchMajor()
{
	var i = $("#search option:selected").attr("value");
	if(i==1){
		getMajorByCampus();
	}
	else if(i==2){
		getMajorByDept();
	}
}
function getMajorByCampus()
{
	var act = $("#actCampus").attr("action");
	var Campus = $("#Campus option:selected").attr("value");
	act = act + "?" + "Campus=" + Campus;
	$("#frame").attr("src",act);
}
function getMajorByDept()
{
	var act = $("#actDept").attr("action");
	var DeptID = $("#departSelect option:selected").attr("value");
	act = act + "?" + "DeptID=" + DeptID;
	$("#frame").attr("src",act);
}
window.onload = loadDepartment();
</script>
</head>
<body>
<div style="display: none;">
<s:form id="actDept" namespace="/webs_a" action="getMajorByDept"></s:form>
<s:form id="actCampus" namespace="/webs_a" action="getMajorByCampus"></s:form>
</div>
<div style="width:90%;height:50px;margin: 10px auto;text-align: center;">
	<form>
	<table style="height:100%;width:100%;margin: 0 auto;text-align: center;">
		<tr><td colspan="5"><h1 style="font-size: large;">专业信息搜索</h1></td></tr>
		<tr><td colspan="5" style="background-color: red; width:90%; height:1px;"><!-- split --></td></tr>
		<tr>
		<td style="width:100px;"><br></td>
		<td>搜索条件：<select id="search">
			<option value="2">按系别查询</option>
			<option value="1">按校区查询</option>
		</select></td>
		<td>
		校区：<select id="Campus" style="width:110px;">
		<option value="1">主区</option>
		<option value="0">北区</option>
		</select>
		</td>
		<td>
		系别：<select id="departSelect" style="width:110px;"><option>--请选择--</option></select>
		<input type="button" value="搜索" onclick="searchMajor()"/>
		</td>
		<td style="width:100px;"><br></td>
		</tr>
	</table>
	</form>
	<iframe id="frame" src="" style="width: 100%;height: 400px;"></iframe>
</div>
</body>
</html>
