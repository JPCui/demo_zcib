<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>项目管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url(<%=path%>/img/webs_s/left.gif);
}
-->
</style>
<link href="<%=path %>/css/webs_s/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function tupian(idt){
    var nametu="xiaotu"+idt;
    var tp = document.getElementById(nametu);
    tp.src="../../../img/webs_s/ico05.gif";//图片ico04为白色的正方形
	
	for(var i=1;i<30;i++)
	{
	  //var nametu2="xiaotu"+i;
	  if(i!=idt*1)
	  {
	    var tp2=document.getElementById('xiaotu'+i);
		if(tp2!=undefined)
	    {tp2.src="../../../img/webs_s/ico06.gif";}//图片ico06为蓝色的正方形
	  }
	}
}

function list(idstr){
	var name1="subtree"+idstr;
	var name2="img"+idstr;
	var objectobj=document.all(name1);
	var imgobj=document.all(name2);
	
	
	//alert(imgobj);
	
	if(objectobj.style.display=="none"){
		for(var i=1;i<10;i++){
			var name3="img"+i;
			var name="subtree"+i;
			var o=document.all(name);
			if(o!=undefined){
				o.style.display="none";
				var image=document.all(name3);
				//alert(image);
				image.src="../../../img/webs_s/ico04.gif";
			}
		}
		objectobj.style.display="";
		imgobj.src="../../../img/webs_s/ico03.gif";
	}
	else{
		objectobj.style.display="none";
		imgobj.src="../../../img/webs_s/ico04.gif";
	}
}
</script>
</head>
<body>
<table style="width:100%;" border="0" cellpadding="0" cellspacing="0" class="left-table01">
<tr>
<td>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
	<td width="207" height="55" background="../../../img/webs_s/nav01.gif">
		<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td width="25%" rowspan="2"><img src="../../../img/webs_s/ico02.gif" width="35" height="35" /></td>
			<td width="75%" height="22" class="left-font01">您好，<span class="left-font02">${LoginName }</span></td>
		</tr>
		<tr>
			<td height="22" class="left-font01">[&nbsp;<a href="#" target="_top" class="left-font01">退出</a>&nbsp;]</td>
		</tr>
		</table>
	</td>
	</tr>
	</table>
	<!--  任务系统开始    -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
	<tr>
	<td height="29">
		<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td width="8%"><img name="img8" id="img8" src="../../../img/webs_s/ico04.gif" width="8" height="11" /></td>
			<td width="92%"><a href="javascript:;" class="left-font03" onClick="list('8');" >个人信息</a></td>
		</tr>
		</table>
	</td>
	</tr>
	</table>
	<table id="subtree8" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
	<tr>
		<td width="9%" height="21" ><img id="xiaotu21" src="../../../img/webs_s/ico06.gif" width="8" height="12" /></td>
		<td width="91%"><a href="<%=path %>/webs_s/getStuFull.act?id=${LoginId}" target="mainFrame" class="left-font03" onClick="tupian('21');">档案信息</a></td>
	</tr>
	<tr>
		<td width="9%" height="21" ><img id="xiaotu21" src="../../../img/webs_s/ico06.gif" width="8" height="12" /></td>
		<td width="91%"><a href="<%=path %>/webs/s/modify.jsp" target="mainFrame" class="left-font03" onClick="tupian('21');">修改密码</a></td>
	</tr>
	</table>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
	<tr>
	<td height="29">
		<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td width="8%"><img name="img7" id="img7" src="../../../img/webs_s/ico04.gif" width="8" height="11" /></td>
			<td width="92%"><a href="javascript:;" class="left-font03" onClick="list('7');" >奖惩记录</a></td>
		</tr>
		</table>
	</td>
	</tr>
	</table>
	<table id="subtree7" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
	<tr>
		<td width="9%" height="20" ><img id="xiaotu17" src="../../../img/webs_s/ico06.gif" width="8" height="12" /></td>
		<td width="91%"><a href="<%=path %>/common/getJlsBySid.act" target="mainFrame" class="left-font03" onClick="tupian('17');">奖励查询</a></td>
	</tr>
	<tr>
		<td width="9%" height="20" ><img id="xiaotu18" src="../../../img/webs_s/ico06.gif" width="8" height="12" /></td>
		<td width="91%"><a href="<%=path %>/common/getCfsBySid.act" target="mainFrame" class="left-font03" onClick="tupian('18');">惩罚查询</a></td>
	</tr>
	<tr>
		<td width="9%" height="20" ><img id="xiaotu18" src="../../../img/webs_s/ico06.gif" width="8" height="12" /></td>
		<td width="91%"><a href="<%=path %>/common/get.act?id=${LoginId}" target="mainFrame" class="left-font03" onClick="tupian('18');">上传获奖记录</a></td>
	</tr>
	</table>
</td>
</tr>
</table>
</body>
</html>
