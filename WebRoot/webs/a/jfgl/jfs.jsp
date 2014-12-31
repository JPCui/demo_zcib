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
#sort b{
	float: left;
	margin:5px;
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
<table id="table" align="center" border="0" cellpadding="0" cellspacing="1" style="width:80%;margin:20px auto;background-color: green;">
	<tr id="sort" style="font-weight: bold;">
		<td colspan="7">
		<b onclick="">
		<label for="s">按学号查询：</label><input id="Number" type="text"/></b>
		<b onclick="">
		<input id="s-1" value="s-1" name="sort" type="radio" onchange="select(this.id);"/><label for="s-1">只显示未审核</label></b>
		<b onclick="">
		<input id="s1" value="s1" name="sort" type="radio" onfocus="select(this.id)"/><label for="s1">只显示已通过</label></b>
		<b onclick="">
		<input id="s0" value="s0" name="sort" type="radio" onfocus="select(this.id)"/><label for="s0">只显示未通过</label></b>
		</td>
	</tr>
	<tr style="font-weight: bold;">
		<td>学号</td>
		<td>姓名</td>
		<td>班级</td>
		<td>缴费金额</td>
		<td>缴费时间</td>
		<td>学费状态</td>
		<td width="200px">备注</td>
	</tr>
	<s:iterator value="#request.list" id="l">
	<tr class="${l['id'] } ">
		<td>${l['sid'] }</td>
		<td>${l['name'] }</td>
		<td>${l['clazz'] }</td>
		<td>${l['amount'] }</td>
		<td>${l['time'] }</td>
		<td>${l['status'] }</td>
		<td>${l['remark'] }</td>
	</tr>
	</s:iterator>
	<tr>
		<td colspan="6" align="left" style="text-align: left;">统计信息：全班共有 ${DebtNum } 位学生欠费</td>
		<td>[<a href="javascript:;" onclick="">显示欠费人员名单</a>]</td>
	</tr>
</table>
