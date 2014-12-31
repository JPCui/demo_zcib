<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<style>
td{
	text-align: center;
}
</style>

<table id="stuBaseList" border="1px" cellspacing="0px">
	<tr>
		<td class="d">异动类别</td>
		<td class="d">异动原因</td>
		<td class="d">异动时间</td>
	</tr>
	<tr>
		<s:iterator value="#request.list" id="l">
		<td class="d">${l.change_type}</td>
		<td class="d">${l.change_reason}</td>
		<td class="d">${l.change_date}</td>
		</s:iterator>
	</tr>
</table>
