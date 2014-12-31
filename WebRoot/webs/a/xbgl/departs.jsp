<%@page import="java.net.URLDecoder"%>
<%@page import="cn.zcib.bean.Department"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE style PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
input{
	text-decoration: none;
	font-size: 12px;
	width: 40px;
}
</style>
<link href="<%=path %>/css/hide.css" type="text/css" rel="stylesheet">
<link href="<%=path %>/css/right.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<%=path %>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
//隐藏区域
function hideBox()
{
	var abs = document.getElementById("abs");
	var hide = document.getElementById("hide");
	abs.style.display = "none";
	hide.style.display = "none";
}
//显示区域
function displayBox()
{
	var abs = document.getElementById("abs");
	var hide = document.getElementById("hide");
	abs.style.display = "";
	hide.style.display = "block";
}
//获取被选中的条目序号
function getSelectedIndex()
{
	return $("input[name='IDradio']:checked").attr("title");
}
//Update获取原来的值
function getPreValue()
{
	var index = getSelectedIndex();
	if(index == null)
	{
		alert("请选择一条记录");
		return 0;
	}
	var ID = $("#ID"+index).text();
	var Name = $("#Name"+index).text();
	var Header = $("#Header"+index).text();
	var ViceHeader = $("#ViceHeader"+index).text();
	var PartySecretary = $("#PartySecretary"+index).text();
	
	$("input[name='ID']").attr("value",ID);
	$("input[name='Name']").attr("value",Name);
	$("input[name='Header']").attr("value",Header);
	$("input[name='ViceHeader']").attr("value",ViceHeader);
	$("input[name='PartySecretary']").attr("value",PartySecretary);
	return 1;
}
//ADD按钮事件
function btnAdd(){
	var hide_t = document.getElementById("hide_t");
	
	hide_t.innerHTML = "系部信息添加";
	var act = $("#addAct").attr("action");
	$("#form").attr("action",act);
	
	$("#reset").click();//重置，清空已存在的数据
	displayBox();
}
//Update按钮事件
function btnUpdate(){
	var hide_t = document.getElementById("hide_t");
	
	hide_t.innerHTML = "系部信息修改";
	var act = $("#updateAct").attr("action");
	$("#form").attr("action",act);
	
	if(getPreValue()==1) displayBox();
}
//Delete按钮事件
function btnDelete(){
	var act = $("#delAct").attr("action");
	var index = getSelectedIndex();
	if(index == null)
	{
		alert("请选择一条记录");
		return 0;
	}
	var ID = $("#ID"+index).text();
	window.location.href = act + "?" + "ID=" + ID;//跳转到该act，返回到本页及错误信息
	//window.location.reload();
}
</script>
</head>
<body style="margin:0 auto;width:80%;height:100%;">
<div id="abs" style="display:none;position:fixed;top:0;left:0;width:100%;height:100%;filter:alpha(opacity=50);-moz-opacity:0.5;-khtml-opacity: 0.5;opacity: 0.5; background-color: grey;"></div>
<div style="width: 100%;height: 20px;font-size: 16px;">
<%
String Msg = "";
if(request.getAttribute("Msg") != null)
{
	Msg = URLDecoder.decode(request.getAttribute("Msg").toString(), "UTF-8");
	Msg = URLDecoder.decode(Msg, "UTF-8");
}
%>
<%=Msg  %>
</div>
<div style="margin:0px auto;width:100%;height: 80%; border:solid 1px grey; overflow-y: scroll;">
<form>
	<table id="stuBaseList" border="1px" cellspacing="0px" style="width:100%;margin:0px 0px;">
		<tr style="font-weight: bold; height:20px;">
		<td width="50px">选择</td>
		<td style="width: 70px;">系部编号</td>
		<td>系部名称</td>
		<td>系主任</td>
		<td>副主任</td>
		<td>书记</td>
	</tr>
	<s:iterator value="#request.list" id="l" status="i">
	   <tr>
	    <td><input title="<s:property value="#i.index"/>" type="radio" name="IDradio"/></td>
	     <td id="ID<s:property value="#i.index"/>"><%=((Department)request.getAttribute("l")).getID() %></td>
	     <td id="Name<s:property value="#i.index"/>"><%=((Department)request.getAttribute("l")).getName() %></td>
	     <td id="Header<s:property value="#i.index"/>"><s:property value="#l.Header"/></td>
	     <td id="ViceHeader<s:property value="#i.index"/>"><s:property value="#l.ViceHeader"/></td>
	     <td id="PartySecretary<s:property value="#i.index"/>"><s:property value="#l.PartySecretary"/></td>
	    </tr>
    </s:iterator>
	</table>
</form>
</div>
<div style="margin:10px auto;width:100%;height: 10%;line-height: 10%;">
		<div style="float: left;width: 100px;"><br></div>
		<div style="float: left;width: 150px;line-height: 100%;">注：共有[${Sum }]个系部</div>
		<div style="float: right;width: 100px;"><br></div>
		<div style="float: right;width: 100px;"><input type="button" onclick="btnDelete()" value="删除"/></div>
		<div style="float: right;width: 100px;"><input type="button" onclick="btnUpdate()" value="修改"/></div>
		<div style="float: right;width: 100px;"><input type="button" onclick="btnAdd()" value="添加"/></div>
</div>
<!-- ADD BOX -->
<div id="hide">
<div id="hide_t"></div>
<s:form id="addAct" namespace="/webs_a" action="oper_depart_add" method="post"></s:form>
<s:form id="updateAct" namespace="/webs_a" action="oper_depart_update" method="post"></s:form>
<s:form id="delAct" namespace="/webs_a" action="oper_depart_delete" method="post"></s:form>
<div id="hide_c">
<s:form id="form" action="" method="post">
	<table id="" border="1px" cellspacing="0px" style="">
		<tr>
			<td style="width: 200px;">系部编号</td>
			<td><input name="ID" readonly="readonly" type="text"/></td>
		</tr>
		<tr>
			<td>系部名称</td>
		    <td><input name="Name" type="text"/></td>
		</tr>
		<tr>
			<td>系主任</td>
		    <td><input name="Header" type="text"/></td>
		</tr>
		<tr>
			<td>副主任</td>
		    <td><input name="ViceHeader" type="text"/></td>
		</tr>
		<tr>
			<td>书记</td>
		    <td><input name="PartySecretary" type="text"/></td>
	    </tr>
	</table>
	<table>
	    <tr>
			<td><input id="submit" type="submit" value="提交"/></td>
			<td><input id="reset" type="reset" value="重置"/></td>
			<td><input type="button" onclick="hideBox()" value="取消"/></td>
		</tr>
	</table>
</s:form>
</div>
</div>
</body>
</html>