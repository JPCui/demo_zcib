<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE style PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<style>
<!--
*{
margin: 0px;
font-size: 12px;

}
body{
topMargin: 0px;
leftMargin: 0px;
}
#headmsg{
margin:35px 0px 0px 0px;
width: 250px;
height:25px;
line-height:25px;
overflow: hidden;

font-size: 13px;
text-align:right;
}
#head{
}
-->
</style>

</head>
<body>
<div id="head">
<div style="left: 0px; top: 0px; width: 100px; height: 7px; visibility: hidden; position: absolute; z-index: -1;"></div>
<table width="100%" height="82px" cellpadding="0" cellspacing="0" border="0" style="overflow: hidden;">
<tr>
<td width="268px" nowrap="nowrap" background="<%=request.getContextPath()%>/img/index/banner.gif"><br/></td>
<td width="25%" background="<%=request.getContextPath()%>/img/index/banner_centerl.gif"><br/></td>
<td width="400px" nowrap="nowrap" background="<%=request.getContextPath()%>/img/index/banner_centerl.gif"><br/></td>
<td width="25%" background="<%=request.getContextPath()%>/img/index/banner_centerl.gif"><br/></td>
<td width="200px" nowrap="nowrap" background="<%=request.getContextPath()%>/img/index/banner_centerl.gif" align="right" valign="bottom">
	<table width="280px" height="100%">
	<tr>
		<td valign="bottom" align="right" style="text-align: right;">用户名:<font color="blue">${LoginName}</font>
		|
		权限:
		<font color="blue">
		<s:if test=" #session.IsAdmin == 1 ">
			<a id="privilege" name="webs_a">管理员</a>
		</s:if>
		<s:elseif test=" #session.IsAdmin == 0 ">
			<a id="privilege" name="webs_s">学生</a>
		</s:elseif>
		<s:else>	
			<font color="red">错误</font>
		</s:else>
		</font>
		</td>
		</tr>
	</table>
</td>
</tr>
</table>
</div>
</body>
</html>
