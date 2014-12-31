<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE style PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html version="-//W3C//DTD HTML 4.01 Transitional//EN">
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
	font-size: 12px;
	text-align: center;
}
td input{
	width: 100%;
	height: 20px;
	text-align: left;
}
td select{
	width: 100%;
	height: 20px;
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
<link href="<%=path %>/css/right.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../../../js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="../../../js/common/tools.js"></script>
<script type="text/javascript">
<!--
function loadDepartMajor3(currDepart)
{
	//项目名 + namespace + url + 处理后缀
	var url = webroot_site+"/common/getAllDepartsJson.act";
	$.ajax({
		type : "POST",
		url : url,
		//成功后，调用函数
		success : function(data){
			$.each(data.jsonMap,function(key,value){
				var option;
				if(currDepart == value.Name)
				{
					option = "<option title='"+value.ID+"' value='"+value.Name+"' selected='selected'>"+value.Name+"</option>";
				}
				else
				{
					option = "<option title='"+value.ID+"' value='"+value.Name+"'>"+value.Name+"</option>";
				}
				$("#departSelect3").append(option);//这句。。。
			});
		}
	});
}
function getNameBySid()
{
	var Sid = $("input[name='Sid']").val();
	var url = webroot_site+"/common/getNameBySid.act";
	$.ajax({
		type : "POST",
		url : url,
		data : "Sid="+Sid,
		//成功后，调用函数
		success : function(data){
			$("input[name='Sid']").attr("value",data);
		},
		error : function(data){
			alert("请输入正确的学号");
		}
	});
} 
window.onload = function(){
	var url = webroot_site+"/common/getAllConfigJson.act";
	var currValue = $("#PunishName").val();
	$.ajax({
		type : "POST",
		url : url,
		//成功后，调用函数
		success : function(data){
			$.each(data.jsonMap,function(key,value){
				var option = "";
				if(""!=value.PunishRank && null!=value.PunishRank)
				if(currValue == value.PunishRank)
				{
					option = "<option selected='selected'>"+value.PunishRank+"</option>";
				}
				else
				{
					option = "<option>"+value.PunishRank+"</option>";
				}
				$("#PunishName").append(option);//这句。。。
			});
		}
	});
};
function submitForm()
{
	//checkForm();
	var Department = $("select[name='Department']").val();
	var Sid = $("input[name='Sid']").val();
	var Name = $("input[name='Name']").val();
	var Rank = $("input[name='Rank']").val();
	var PunishName = $("select[name='PunishName']").val();
	var CheckState = $("select[name='CheckState']").val();
	var Reason = $("input[name='Reason']").val();
	var Remark = $("textarea[name='Remark']").val();
	var act = $("#form").attr("action");
	$.ajax({
		type : "POST",
		url : act,
		data : {"Department":Department,"Sid":Sid,"Name":Name,"Rank":Rank,
			"PunishName":PunishName,"flag":CheckState,"Reason":Reason,"Remark":Remark},
		//成功后，调用函数
		success : function(data){
			alert(data);
		}
	});
}
function checkForm()
{
	var url = webroot_site+"/common/checkCfForm.act";
	var depart = $("#departSelect3").val();
	var Sid = $("#Sid").val();
	$.ajax({
		type : "POST",
		url : url,
		data : {"Department":depart,"Sid":Sid},
		//成功后，调用函数
		success : function(data){
			if(data!="1")
			{
				alert(data);return false;
			}else{
				return true;
			}
		}
	});
}
loadDepartMajor3("");
//-->
</script>
</head>
		<div style="margin-top: 20px;">
		<h1 style="font-size: large;">信息录入</h1>
		</div>
<s:form id="form" namespace="/webs_a" action="addCf" method="post">
<table id="table" align="center" border="0" cellpadding="0" cellspacing="1" width="550px" style="margin:20px auto;background-color: green;">
	<tr>
		<td>系部</td>
		<td><select id="departSelect3" name="Department"></select></td>
		<td>学号</td>
		<td><input name="Sid" type="text"/></td>
	</tr>
	<tr>
		<td>姓名</td>
		<td><input name="Name" type="text"/></td>
		<td>级别</td>
		<td><input name="Rank" type="text"/></td>
	</tr>
	<tr>
		<td>处罚名称</td>
		<td><select id="PunishName" name="PunishName">
		</select></td>
		<td>审核状态</td>
		<td><select name="flag">
			<option value="-1" selected="selected">未审核</option>
			<option value="1">生效</option>
			<option value="0">不生效</option>
		</select></td>
	</tr>
	<tr>
		<td>原因</td>
		<td colspan="3"><input type="text" name="Reason"/></td>
	</tr>
	<tr>
		<td>描述</td>
		<td colspan="3"><textarea name="Remark" style="width:100%;height:100px; overflow:scroll; text-align: left;"></textarea></td>
	</tr>
</table>
<div style="margin:20px auto;width: 210px;height: 100px;">
<div style="float: left;"><input type="button" value="提交" onclick="submitForm()"/></div>
<div style="float: right;"><input type="reset"/></div>
</div>
</s:form>
</html>

