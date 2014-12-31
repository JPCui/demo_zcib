<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE style PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<style type="text/css">
#stuBaseList tr{
	margin: 0;
	padding: 0;
	height: 30px;
}
#stuBaseList tr td input{
	width: 100%;
	height: 100%;
}
#stuBaseList tr td select{
	width: 100%;
	height: 100%;
}
</style>
</head>
<body style="margin:0 auto;width:90%;">
<div id="hide">
<div id="hide_t">系部修改</div>
<div id="hide_c">
<form>
	<table id="" border="1px" cellspacing="0px" style="">
		<tr>
			<td style="width: 200px;">系部编号</td>
			<td id="Class"><input name="Name" type="text"/></td>
		</tr>
		<tr>
			<td>系主任</td>
		    <td id="DepartName"><select id="departSelect" onchange="getMajorByDept()"><option>--请选择--</option></select></td>
		</tr>
		<tr>
			<td>系部名称</td>
		    <td id="MajorName"><select id="majorSelect" name="MajorID"><option>--请选择--</option></select></td>
		</tr>
		<tr>
			<td>书记</td>
		    <td id="Header"><input name="AdvID" type="text"/></td>
	    </tr>
		<tr>
			<td>副主任</td>
		    <td id="Fudaoyuan"><input name="AssisID" type="text"/></td>
		</tr>
	</table>
	<table>
	    <tr>
			<td><input type="button" value="提交" onclick="addClass()"/></td>
			<td><input type="reset" value="重置"/></td>
			<td><input type="button" onclick="btnAddCancel()" value="取消"/></td>
		</tr>
	</table>
</form>
</div>
</div>
</body>
</html>