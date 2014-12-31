<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE style PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#stuBaseList tr{
	height: 20px;
}
</style>
<link href="<s:text name="%{getText('webroot_site')}"/>/css/table.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<%=path %>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/webs_a/dagl.js"></script>
</head>
<div style="margin:0 auto;width:90%;height: 400px; border:solid 1px grey;text-align:center; overflow-y: scroll;">
	<table id="stuBaseList" border="1px" cellspacing="0px" style="width:100%;margin:0px;">
		<tr style="font-weight: bold; height:20px;">
		<td height="30px" class="d2">学号</td>
		<td class="d3">姓名</td>
		<td class="d4">性别</td>
		<td class="d5">民族</td>
		<td class="d9">家庭住址</td>
		<td class="d10">联系电话</td>
		<td class="d12" colspan="2">操作</td>
	</tr>
	<s:iterator value="#request.list" id="l">
	   <tr>
	     <td><s:property value="#l['Number']"/></td>
	     <td><s:property value="#l['Name']"/></td>
	     <td><s:property value="#l['Sex']"/></td>
	     <td><s:property value="#l['Nation']"/></td>
	     <td><s:property value="#l['HomeAddress']"/></td>
	     <td><s:property value="#l['tel']"/></td>
	     <td><a href="javascript:;" id="${l['Number']}" style="text-decoration:none;" onclick="getStuFull(this.id)">[详细]</a></td>
	     <td><a href="javascript:;" id="${l['Number']}" style="text-decoration:none;" onclick="delStu(this.id)">[删除]</a></td>
	    </tr>
    </s:iterator>
	</table>
</div>
</html>