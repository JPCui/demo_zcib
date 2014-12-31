<%@page import="cn.zcib.bean.Reward"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" rev="stylesheet" href="../../css/style.css" type="text/css" media="all" />
<style type="text/css">
#mytable {
 border:1px solid #C1DAD7;
border-collapse:collapse;
cellspacing:2;
} 
#mytable td { 
border-right: 1px solid #C1DAD7; 
border-bottom: 1px solid #C1DAD7; 
background: #fff; 
font-size:11px; 
padding: 6px 6px 6px 12px; 
color: #4f6b72; 
} 
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >奖励记录</th>
  </tr>
  <tr>
    <td class="CPanel">		
		<TABLE border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr>
			<td width="100%">
				<fieldset style="height:100%;">
				<legend>记录列表</legend>
					<table align="center" id="mytable" >
						<tr>
							<td width="200" align="center" valign="middle">奖励名称</td>
							<td width="200" align="center" valign="middle">奖励级别</td>
							<td width="200" align="center" valign="middle">提交时间</td>
							<td width="200" align="center" valign="middle">奖励原因</td>
							<td width="250" align="center" valign="middle">详细描述</td>
							<td width="250" align="center" valign="middle">状态</td>
					   </tr>
						<s:iterator value="#request.list" id="l">
						<tr>
							<td width="200" align="center" valign="middle">${l.prize }</td>
							<td width="200" align="center" valign="middle"><%=((Reward)request.getAttribute("l")).getRank() %></td>
							<td width="200" align="center" valign="middle">${l.time }</td>
							<td width="200" align="center" valign="middle">${l.reason }</td>
							<td width="200" align="center" valign="middle">${l.remark }</td>
							<td width="200" align="center" valign="middle">
								<s:if test='#l.CheckState == 1'><font color="green">已通过</font></s:if>
								<s:elseif test='#l.CheckState == 0'><font color="red">未通过</font></s:elseif>
								<s:else><font color="blue">未审核</font></s:else>
							</td>
					   </tr>
					   </s:iterator>
					</table>  
				</fieldset>	
			</td>
		</tr>
		</TABLE>
	 </td>
  </tr>
  </table>

</div>

</body>
</html>
