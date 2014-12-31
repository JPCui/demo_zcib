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
<script type="text/javascript" src="<%=path %>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/webs_a/loadSelect.js"></script>
<script type="text/javascript">
function initBtn()
{
	var Edit = document.getElementById("edit");
	var Submit = document.getElementById("submit");
	var Cancel = document.getElementById("cancel");
	var Print = document.getElementById("print");
	
	Edit.style.display = "";
	Submit.style.display = "none";
	Cancel.style.display = "none";
	Print.style.display = "";
}
function toEdit()
{
	var Class = document.getElementById("Class");
	Class.innerHTML = "<input id='ClassE' type='text' title='" + Class.innerHTML + "' value='" + Class.innerHTML + "'/>";
	
	var Header = document.getElementById("Header");
	Header.innerHTML = "<input id='HeaderE' type='text' title='" + Header.innerHTML + "' value='" + Header.innerHTML + "'/>";
	
	var Fudaoyuan = document.getElementById("Fudaoyuan");
	Fudaoyuan.innerHTML = "<input id='FudaoyuanE' type='text' title='" + Fudaoyuan.innerHTML + "' value='" + Fudaoyuan.innerHTML + "'/>";

	var ClaAssis = document.getElementById("ClaAssis");
	ClaAssis.innerHTML = "<input id='ClaAssisE' type='text' title='" + ClaAssis.innerHTML + "' value='" + ClaAssis.innerHTML + "'/>";
	
	var Banzhang = document.getElementById("Banzhang");
	Banzhang.innerHTML = "<input id='BanzhangE' type='text' title='" + Banzhang.innerHTML + "' value='" + Banzhang.innerHTML + "'/>";
	
	var Depart = document.getElementById("Depart");
	var Depart2 = Depart.innerHTML;
	Depart.innerHTML = "<select id='departSelect2' title='"+Depart2+"' onchange='getMajorByDept2(this.value)'></select>";
	
	var Major = document.getElementById("Major");
	var Major2 = Major.innerHTML;
	Major.innerHTML = "<select id='majorSelect2' title='"+Major2+"'></select>";
	loadDepartMajor(Depart2,Major2);//第二个select要等到ajax执行结束才能执行

	var Edit = document.getElementById("edit");
	var Submit = document.getElementById("submit");
	var Cancel = document.getElementById("cancel");
	var Print = document.getElementById("print");
	
	Edit.style.display = "none";
	Submit.style.display = "";
	Cancel.style.display = "";
	Print.style.display = "none";
}

function cancelEdit()
{
	initBtn();
	var Class = document.getElementById("Class");
	Class.innerHTML = Class.getElementsByTagName("input")[0].title;
	
	var Header = document.getElementById("Header");
	Header.innerHTML = Header.getElementsByTagName("input")[0].title;
	
	var Fudaoyuan = document.getElementById("Fudaoyuan");
	Fudaoyuan.innerHTML = Fudaoyuan.getElementsByTagName("input")[0].title;
	
	var ClaAssis = document.getElementById("ClaAssis");
	ClaAssis.innerHTML = ClaAssis.getElementsByTagName("input")[0].title;
	
	var Banzhang = document.getElementById("Banzhang");
	Banzhang.innerHTML = Banzhang.getElementsByTagName("input")[0].title;
	
	var Depart = document.getElementById("Depart");
	Depart.innerHTML = Depart.getElementsByTagName("select")[0].title;
	
	var Major = document.getElementById("Major");
	Major.innerHTML = Major.getElementsByTagName("select")[0].title;
}

function submitEdit()
{
	var ID = $("#ID").text();
	var AdvID = $("#HeaderE").attr("value");
	var AssisID = $("#FudaoyuanE").attr("value");
	var ClaAssis = $("#ClaAssisE").attr("value");
	var MajorID = $("#majorSelect2 option:selected").attr("value");
	var Monitor = $("#BanzhangE").attr("value");
	var Name = $("#ClassE").attr("value");
	var privilege = $(window.parent.frames["ifhead"].document).find("#privilege").attr("name");
	//项目名 + namespace + url + 处理后缀
	var url = "/demo_zcib/" + privilege + "/oper_class_update.act";
	$.ajax({
		type : "POST",
		data : {"ID":ID,"Adv":AdvID,"Assis":AssisID,"ClaAssis":ClaAssis,"MajorID":MajorID,"Monitor":Monitor,"Name":Name},
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		dataType: "html",
		url : url,
		//成功后，调用函数
		success : function(data){
			alert(data);
			if(data=="更新成功")
			{
				getFullClassesByMajor();
			}
		}
	});
}

function del()
{
	var ID = $("#ID").text();
	var privilege = "/"+$(window.parent.frames["ifhead"].document).find("#privilege").attr("name");
	//项目名 + namespace + url + 处理后缀
	var url = "/demo_zcib" + privilege + "/oper_class_del.act";
	$.ajax({
		type : "POST",
		data : "ID="+ID,
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		url : url,
		dataType: "html",
		//成功后，调用函数
		success : function(data){
			alert(data);
			//如果status是1。。
		}
	});
}

window.onload = initBtn;
window.onload = initBtn();
</script>
<div style="margin:0 auto;width:100%;height: 400px;overflow-y: scroll;text-align: center;padding:10px;">
<div id="ID" style="display: none;">${bean.ID }</div>
	<table id="stuBaseList" border="1px" cellspacing="0px" style="margin:0 auto;width:50%;margin:0px auto;">
		<tr style="font-weight: bold;">
			<td style="width: 200px;">班级名称</td>
			<td id="Class">${bean.Name}</td>
		</tr>
		<tr>
			<td>所属系别</td>
		    <td id="Depart" title="${bean.DepartID }">${bean.Depart }</td>
		</tr>
		<tr>
			<td>所属专业</td>
		    <td id="Major" title="${bean.MajorID }">${bean.Major }</td>
		</tr>
		<tr>
			<td>班主任</td>
		    <td id="Header">${bean.Adviser }</td>
	    </tr>
		<tr>
			<td>辅导员</td>
		    <td id="Fudaoyuan">${bean.Assistant }</td>
		</tr>
		<tr>
			<td>班助</td>
		    <td id="ClaAssis">${bean.ClaAssis }</td>
		</tr>
		<tr>
			<td>班长</td>
		    <td id="Banzhang">${bean.Monitor }</td>
		</tr>
	</table>
	<table border="0px" cellspacing="0px" style="margin:0 auto;width:50%;margin:20px auto;">
	    <tr id="oper_btn">
			<td id="print"><a onclick="del()" style="background:green; color:#fff; z-index:1;" href="javascript:;">删除</a></td>
			<td id="edit"><a onclick="toEdit()" style="background:green; color:#fff; z-index:1;" href="javascript:;">修改</a></td>
			<td id="submit"><a onclick="submitEdit()" style="background:green; color:#fff; z-index:1;" href="javascript:;">提交</a></td>
			<td id="cancel"><a onclick="cancelEdit()" style="background:green; color:#fff; z-index:1;" href="javascript:;">取消</a></td>
		</tr>
	</table>
</div>
</body>
</html>