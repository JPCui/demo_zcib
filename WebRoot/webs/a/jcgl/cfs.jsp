<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE style PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<style>
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
#s b{
	cursor: pointer;
}
</style>
<link href="<s:text name="%{getText('webroot_site')}"/>/css/right.css" type="text/css" rel="stylesheet">
<script type="text/javascript">
<!--
$(document).ready(function(){
	$("input[name='sort']").change(function()
	{
		var clazz = this.id;
		$("tr.s").each(function(){
			this.style.display="none";
		});
		$("tr."+clazz).each(function(){
			this.style.display="";
		});
	});
});
//-->
</script>
</head>
<table id="table" align="center" border="0" cellpadding="0" cellspacing="1" width="640px" style="margin:20px auto;background-color: green;">
	<tr id="sort" style="font-weight: bold;">
		<td colspan="5"><form id="ss">
		<b onclick="">
		<input id="s" value="s" name="sort" type="radio" checked="checked" onchange="select(this.id);"/><label for="s">按学号排序</label></b>
		<b onclick="">
		<input id="s-1" value="s-1" name="sort" type="radio" onchange="select(this.id);"/><label for="s-1">只显示未审核</label></b>
		<b onclick="">
		<input id="s1" value="s1" name="sort" type="radio" onfocus="select(this.id)"/><label for="s1">只显示已通过</label></b>
		<b onclick="">
		<input id="s0" value="s0" name="sort" type="radio" onfocus="select(this.id)"/><label for="s0">只显示未通过</label></b>
		</form></td>
	</tr>
	<tr style="font-weight: bold;">
		<td>学号</td>
		<td>姓名</td>
		<td>标题</td>
		<td>状态</td>
	</tr>
	<s:iterator value="#request.list" id="l">
	<tr class="s s${l['flag'] }">
	<td>${l['sid'] }</td>
	<td>${l['name'] }</td>
	<td><a href="javascript:;" onclick="loadBean('getCf','ID='+${ID })">${l['title'] }</a></td>
	<td>
		<s:if test='#l["flag"] == 1'><font color="green">已通过(${l['flag'] })</font></s:if>
		<s:elseif test='#l["flag"] == 0'><font color="red">未通过(${l['flag'] })</font></s:elseif>
		<s:else><font color="blue">未审核(${l['flag'] })</font></s:else>
	</td>
	</tr>
	</s:iterator>
</table>
