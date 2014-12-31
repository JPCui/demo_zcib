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
	background-color: yellow;
}
#s b:HOVER{
	background-color: grey;
}
</style>
<link href="<s:text name="%{getText('webroot_site')}"/>/css/right.css" type="text/css" rel="stylesheet">
<script type="text/javascript">
<!--
function check(ID,flag)
{
	var act = webroot_site+"/webs_a/oper_jc_checkJL.act";
	$.ajax({
		type : "POST",
		data : {"ID":ID,"flag":flag},
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		dataType: "html",
		url : act,
		//成功后，调用函数
		success : function(data){
		if(data == "list") getJlsByClass();
		else alert(data);
		}
	});
}
//-->
</script>
</head>
<table id="table" align="center" border="0" cellpadding="0" cellspacing="1" width="640px" style="margin:20px auto;background-color: green;">
	<tr style="font-weight: bold;">
		<td>学号</td>
		<td>${bean.sid }</td>
	</tr>
	<tr>
		<td>姓名</td>
		<td>${bean.name }</td>
	</tr>
	<tr>
		<td>标题</td>
		<td>${bean.title }</td>
	</tr>
	<tr>
		<td>级别</td>
		<td>${bean.rank }</td>
	</tr>
	<tr>
		<td>原因</td>
		<td>${bean.reason }</td>
	</tr>
	<tr>
		<td>描述</td>
		<td>${bean.remark }</td>
	</tr>
	<tr>
		<td>状态</td>
		<td>
		<s:if test='#request.bean.flag == 1'><font color="green"> 已通过(${bean.flag })</font></s:if>
		<s:elseif test='#request.bean["flag"] == "0"'><font color="red">未通过(${bean.flag })</font></s:elseif>
		<s:else><font color="blue">未审核(${bean.flag })</font></s:else>
		</td>
	</tr>
	<tr>
		<td><input value="批准" onclick="check(${bean.ID},1)" type="button"/></td>
		<td><input value="不批准" onclick="check(${bean.ID},0)" type="button"/></td>
	</tr>
</table>
