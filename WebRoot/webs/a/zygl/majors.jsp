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
<script type="text/javascript" src="<%=path %>/js/webs_a/loadSelect.js"></script>
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
//基于当前选中的条目的系名加载所有系名
function loadDepartBaseCurr(currDepart)
{
	//项目名 + namespace + url + 处理后缀
	var url = webroot_site+"/webs_a/getAllDepartsJson.act";
	$.ajax({
		type : "POST",
		url : url,
		//成功后，调用函数
		success : function(data){
			$("#departSelect2").empty();
			$.each(data.jsonMap,function(key,value){
				var option;
				if(currDepart == value.Name)
				{
					option = "<option value='"+value.ID+"' selected='selected'>"+value.Name+"</option>";
				}
				else
				{
					option = "<option value='"+value.ID+"'>"+value.Name+"</option>";
				}
				$("#departSelect2").append(option);
			});
		}
	});
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
	var Campus = $("#Campus"+index).text();
	var Tuition = $("#Tuition"+index).text();
	var Education = $("#Education"+index).text();
	var Depart = $("#Depart"+index).text();
	loadDepartBaseCurr(Depart);
	
	$("input[name='ID']").attr("value",ID);
	$("input[name='Name']").attr("value",Name);
	$("select[name='Campus']").find("option[text='"+Campus+"']").attr("selected","selected");
	$("input[name='Tuition']").attr("value",Tuition);
	$("input[name='Education']").attr("value",Education);
	$("input[name='Depart']").attr("value",Depart);
	return 1;
}
//ADD按钮事件
function btnAdd(){
	var hide_t = document.getElementById("hide_t");
	
	hide_t.innerHTML = "专业信息添加";
	var act = $("#addAct").attr("action");
	$("#form").attr("action",act);
	
	$("#reset").click();//重置，清空已存在的数据
	loadDepartBaseCurr("");
	displayBox();
}
//Update按钮事件
function btnUpdate(){
	var hide_t = document.getElementById("hide_t");
	
	hide_t.innerHTML = "专业信息修改";
	var act = $("#updateAct").attr("action");
	$("#form").attr("action",act);
	
	if(getPreValue()==1){
		displayBox();
	}
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
	var Depart = $("#Depart"+index).text();
	/*
	//这里通过加载系别时间较长，需要通过一些方法延迟
	loadDepartBaseCurr(Depart);
	alert(DepID);
	var DepID = $("#departSelect2").find("option[selected]").val();*/
	window.location.href = act + "?" + "DepID=" + DepID + "&" + "ID=" + ID;//跳转到该act，返回到本页及错误信息
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
	<table border="1px" cellspacing="0px" style="width:100%;margin:0px 0px;">
		<tr style="font-weight: bold; height:20px;">
		<td width="50px">选择</td>
		<td style="width: 70px;">专业编号</td>
		<td>专业名称</td>
		<td>校区</td>
		<td>学制</td>
		<td>学费</td>
		<td>隶属系别</td>
	</tr>
	<s:iterator value="#request.list" id="l" status="i">
	   <tr>
	    <td><input title="<s:property value='#i.index'/>" type="radio" name="IDradio"/></td>
	     <td id="ID<s:property value='#i.index'/>"><s:property value="#l.ID"/></td>
	     <td id="Name<s:property value='#i.index'/>"><s:property value="#l.Name"/></td>
	     <td id="Campus<s:property value='#i.index'/>">${l.Campus=="true"?"主区":"北区" }</td>
	     <td id="Education<s:property value='#i.index'/>"><s:property value="#l.Education"/></td>
	     <td id="Tuition<s:property value='#i.index'/>"><s:property value="#l.Tuition"/></td>
	     <td id="Depart<s:property value='#i.index'/>"><s:property value="#l.Depart"/></td>
	    </tr>
    </s:iterator>
	</table>
</form>
</div>
<div style="margin:10px auto;width:100%;height: 10%;line-height: 10%;">
		<div style="float: left;width: 100px;"><br></div>
		<div style="float: left;width: 150px;line-height: 100%;">注：共搜索到[${Sum }]个专业</div>
		<div style="float: right;width: 100px;"><br></div>
		<div style="float: right;width: 100px;"><input type="button" onclick="btnDelete()" value="删除"/></div>
		<div style="float: right;width: 100px;"><input type="button" onclick="btnUpdate()" value="修改"/></div>
		<div style="float: right;width: 100px;"><input type="button" onclick="btnAdd()" value="添加"/></div>
</div>
<!-- ADD BOX -->
<div id="hide">
<div id="hide_t"></div>
<s:form id="addAct" namespace="/webs_a" action="oper_major_add" method="post"></s:form>
<s:form id="updateAct" namespace="/webs_a" action="oper_major_update" method="post"></s:form>
<s:form id="delAct" namespace="/webs_a" action="oper_major_delete" method="post"></s:form>
<div id="hide_c">
<form id="form" action="" method="post">
	<table id="" border="1px" cellspacing="0px" style="">
		<tr>
			<td style="width: 200px;">专业编号</td>
			<td><input name="ID" readonly="readonly" type="text"/></td>
		</tr>
		<tr>
			<td>专业名称</td>
		    <td><input name="Name" type="text"/></td>
		</tr>
		<tr>
			<td>校区</td>
		    <td><select name="Campus">
		    	<option value="1">主区</option>
		    	<option value="0">北区</option>
		    </select></td>
		</tr>
		<tr>
			<td>学制</td>
		    <td><input name="Education" type="text"/></td>
		</tr>
		<tr>
			<td>学费</td>
		    <td><input name="Tuition" type="text"/></td>
	    </tr>
		<tr>
			<td>隶属系别</td>
		    <td><select id="departSelect2" name="DepID">
		    </select></td>
	    </tr>
	</table>
	<table>
	    <tr>
			<td><input id="submit" type="submit" value="提交"/></td>
			<td><input id="reset" type="reset" value="重置"/></td>
			<td><input type="button" onclick="hideBox()" value="取消"/></td>
		</tr>
	</table>
</form>
</div>
</div>
</body>
</html>