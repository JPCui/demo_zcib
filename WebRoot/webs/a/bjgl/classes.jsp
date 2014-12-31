<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE style PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<style>
</style>
</head>
<body style="margin:0 auto;width:90%;">
<div style="margin:0 auto;width:100%;height: 400px; border:solid 1px grey; overflow-y: scroll;">
	<table id="stuBaseList" border="1px" cellspacing="0px" style="width:100%;margin:0px;">
		<tr style="font-weight: bold; height:20px;">
		<td height="30px" class="d1"></td>
		<td class="d3">班级名称</td>
		<td class="d5">班主任</td>
		<td class="d4">辅导员</td>
		<td class="d6">班长</td>
		<td class="d12">操作</td>
	</tr>
	<s:iterator value="#request.list" id="l">
	   <tr>
	    <td><input name="${l['Name']}" type="radio"/></td>
	     <td><s:property value="#l['Name']"/></td>
	     <td><s:property value="#l['Adviser']"/></td>
	     <td><s:property value="#l['Assistant']"/></td>
	     <td><s:property value="#l['Monitor']"/></td>
	     <td><a href="javascript:;" id="${l['Name']}" style="text-decoration:none;" onclick="lookClass(this.id)">[详细]</a></td>
	    </tr>
	    </s:iterator>
	</table>
</div>
</body>
</html>