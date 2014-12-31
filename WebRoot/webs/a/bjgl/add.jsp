<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE style PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=path %>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/webs_a/loadSelect.js"></script>
<script type="text/javascript" src="<%=path %>/js/webs_a/bjgl.js"></script>
<style type="text/css">
Tr{
	background-color: rgb(255,255,255);
}
tr.T{
	background-color: rgb(191,229,213);
}
td{
	height: 20px;
	line-height: 20px;
	font-size: 12px;
	text-align: center;
}
td input{
	width: 100%;
}
td select{
	width: 100%;
}
#stuBaseList tr{
	margin: 0;
	padding: 0;
	height: 30px;
}
#stuBaseList tr td input{
	width: 100%;
	height: 100%;
}
</style>
<link href="<s:text name="%{getText('webroot_site')}"/>/css/right.css" type="text/css" rel="stylesheet">
</head>
<body style="margin:0 auto;width:90%;">
<script type="text/javascript">
window.onload = loadDepartment();
</script>
<div style="margin-top: 20px;">
<h1 style="font-size: large;">信息录入</h1>
</div>
<div style="margin:0 auto;width:100%;height: 400px;overflow-y: scroll;text-align: center;padding:10px;">
<form>
	<table id="stuBaseList" border="1px" cellspacing="0px" style="margin:0 auto;width:50%;margin:0px auto;">
		<tr style="font-weight: bold;">
			<td style="width: 200px;">班级名称</td>
			<td id="Class"><input name="Name" type="text"/></td>
		</tr>
		<tr>
			<td>所属系别</td>
		    <td id="DepartName"><select id="departSelect" onchange="getMajorByDept()"><option>--请选择--</option></select></td>
		</tr>
		<tr>
			<td>所属专业</td>
		    <td id="MajorName"><select id="majorSelect" name="MajorID"><option>--请选择--</option></select></td>
		</tr>
		<tr>
			<td>班主任（ID）</td>
		    <td id="Header"><input name="AdvID" type="text"/></td>
	    </tr>
		<tr>
			<td>辅导员（ID）</td>
		    <td id="Fudaoyuan"><input name="AssisID" type="text"/></td>
		</tr>
		<tr>
			<td>班助</td>
		    <td id="ClaAssis"><input name="ClaAssis" type="text"/></td>
		</tr>
		<tr>
			<td>班长</td>
		    <td id="Banzhang"><input name="Monitor" type="text"/></td>
		</tr>
	    <tr id="oper_btn">
			<td><input type="button" value="提交" onclick="addClass()"/></td>
			<td><input type="reset" value="重置"/></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>