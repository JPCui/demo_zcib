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
cellspacing:2；
} 
#mytable td { 
border-right: 1px solid #C1DAD7; 
border-bottom: 1px solid #C1DAD7; 
background: #fff; 
font-size:13px; 
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
		<th class="tablestyle_title" >学生信息</th>
	</tr>
	<tr>
		<td class="CPanel">
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%;">
	<tr>
		<td width="100%">
				<fieldset style="height:100%;">
<table align="center" id="mytable" >
<tr class="T"><td colspan="6" style="height:15px;background-color: rgb(191, 229, 213);">基本信息</td></tr>
<tr class="C">
	<td valign="middle" width="92">学 号</td><td id="Number" width="133">${bean.ID}</td>
	<td valign="middle" width="110">姓 名</td><td id="Name" class="e${bean.ID }" colspan="2">${bean.Name}</td>
	<td rowspan="5" width="103" valign="middle" style="">
	<div style="position: relative;border: 1px solid rgb(217,217,217);">
		<img id="Photo" title="${bean.Photo}" src="<%=path %>/img/stu/${bean.Photo}" onerror="this.src='<%=path %>/img/stu/photo_blank.jpg'" border="0" height="120" width="100">
	</div>
	</td>
</tr><tr class="C">
	<td valign="middle">性别</td><td id="Sex" class="e${bean.ID }">${bean.Sex}</td>
	<td valign="middle">民族</td><td id="Nation" class="e${bean.ID }" colspan="2">${bean.Nation}</td>
</tr><tr class="C">
	<td valign="middle">身份证号</td><td id="IDCard" class="e${bean.ID }">${bean.IDCard}</td>
	<td valign="middle">联系电话</td><td id="Phone" class="e${bean.ID }" colspan="2">${bean.Phone}</td>
</tr><tr class="C">
	<td valign="middle">籍贯</td><td id="Native" class="e${bean.ID }">${bean.Native}</td>
	<td valign="middle">学籍状态</td><td id="Enrolment" class="e${bean.ID }" colspan="2">${bean.Enrolment }</td>
</tr><tr class="C">
	<td align="center">考生类别</td><td id="Kslb" class="e${bean.ID }">${bean.Kslb}</td>
	<td valign="middle">入学年份</td><td id="Rxrq" class="e${bean.ID }" colspan="2">${bean.Rxnf}</td>
</tr><tr class="C">
	<td valign="middle">出生日期</td><td id="Birthday" class="e${bean.ID }">${bean.Birthday}</td>
	<td valign="middle">享受资助</td>
	<td id="Xszz" class="YN${bean.ID }">${bean.Xszz=="true"?"是":"否"}</td>
	<td valign="middle">宿 舍</td><td id="Dormitory" class="e${bean.ID }">${bean.Dormitory}</td>
</tr><tr class="C">
	<td valign="middle">家庭地址</td><td id="HomAddress" class="e${bean.ID }" colspan="3">${bean.HomAddr}</td>
	<td width="100">邮政编码</td><td id="PosCode" class="e${bean.ID }">${bean.PosCode}</td>
</tr><tr class="C">
	<td valign="middle">入学成绩</td><td id="Rxcj" class="e${bean.ID }">${bean.Rxcj}</td>
	<td valign="middle">政治面貌</td><td id="PolStatus" class="e${bean.ID }">${bean.PolStatus}</td>
	<td align="center">培养层次</td><td id="EduLevel" class="e${bean.ID }">${bean.EduLevel }</td>
</tr><tr class="C">
	<td valign="middle">院(系)/部</td><td id="Dept">${bean.Depart}</td>
	<td valign="middle">专业</td><td id="Major">${bean.Major}</td>
	<td valign="middle">行政班级</td><td id="Clazz">${bean.Class}</td>
</tr><tr class="C">
	<td valign="middle">异动原因</td><td id="Ydyy" class="e${bean.ID }" colspan="5">${bean.Ydyy }</td>
</tr><tr class="C">
	<td valign="middle">备 注</td><td id="Remark" class="remark${bean.ID }" colspan="5">${bean.Remark}</td>
<tr class="T"><td colspan="6" style="height:15px;background-color: rgb(191, 229, 213);">社会信息</td></tr>
<s:iterator value="#request.list" status="i">
<tr class="C" style="display: none;">
	<td valign="middle">ID</td><td>${ID }</td>
</tr>
<s:if test="#i.index != 0"><tr class="C"><td colspan="6" style="height:15px"><br></td></tr></s:if>
<tr class="C">
	<td valign="middle">姓名</td><td id="Name${ID }" class="e${ID }" colspan="2">${Name }</td>
	<td valign="middle">关系</td><td id="Relation${ID }" class="e${ID }" colspan="2">${Relation }</td>
</tr><tr class="C">
	<td valign="middle">年龄</td><td id="Age${ID }" class="e${ID }" colspan="2">${Age }</td>
	<td valign="middle">政治面貌</td><td id="PoliticalStatus${ID }" class="e${ID }" colspan="2">${PoliticalStatus }</td>
</tr><tr class="C">
	<td valign="middle">工作单位</td><td id="Company${ID }" class="e${ID }" colspan="2">${Company }</td>
	<td valign="middle">联系方式</td><td id="Phone${ID }" class="e${ID }" colspan="2">${Phone }</td>
</tr><tr class="C">
	<td valign="middle">备 注</td><td id="Remark${ID }" class="remark${ID }" colspan="5">${Remark}</td>
</tr>
</s:iterator>
					</table>
				</fieldset>	
			</TD>			
		</TR>		
		</TABLE>
	 </td>
  </tr>	
	 </td>
  </tr>
  </table>

</div>

</body>
</html>
