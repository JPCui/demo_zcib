<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE style PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="description" content="This is my page">
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
td input{
	width: 100%;
}
td select{
	width: 100%;
}
</style>
<link href="<s:text name="%{getText('webroot_site')}"/>/css/right.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<s:text name="%{getText('webroot_site')}"/>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/webs_a/loadSelect.js"></script>
<script type="text/javascript" src="<%=path %>/js/webs_a/dagl.js"></script>
<script type="text/javascript">
window.onload = loadDepartment();
</script>
</head>
<body style="margin:0 auto;width:90%;height:90%;">
<center>
<div style="margin-top: 20px;">
<h1 style="font-size: large;">档案录入</h1>
</div>
<div id="abs" style="display:none;position:fixed;top:0;left:0;width:100%;height:100%;filter:alpha(opacity=50);-moz-opacity:0.5;-khtml-opacity: 0.5;opacity: 0.5; background-color: grey;"></div>
<form action="">
<table align="center" border="0" cellpadding="0" cellspacing="1" width="640px" style="margin:20px auto;background-color: green;">
<tr class="T"><td colspan="6" style="height:15px;background-color: rgb(191, 229, 213);">基本信息</td></tr>
<tr>
	<td width="100">学号</td><td><input name="Number" type="text"/></td>
	<td width="100">姓名</td><td colspan="2" width="200px"><input name="Name" type="text"/></td>
	<td rowspan="6" width="103" style="">
		<div style="position: relative;border: 1px solid rgb(217,217,217);">
			<span id="PhotoSpan"><img id="Photo" title="${bean.Photo}" src="<%=path %>/img/stu/photo_blank.jpg" border="0" height="120" width="100"></span>
			<a onclick="editPhoto()" style="border: 1px solid rgb(217,217,217);background-color: rgb(242,242,242);position: absolute;bottom:0px;right:0px;" href="javascript:;">
			更换</a>
		</div>
		<div id="abs_photo" style="display:none;position:fixed;top:0;left:0;width:100%;height:100%;background: transparent;">
			<div style="margin:50 auto;height:70%;width:60%; background-color: rgb(255,251,240);">
			<div style="float:left;width: 100%;">
				<img id="showPic" name="showPic" alt="图片预览" src="<%=path %>/img/stu/photo_blank.jpg" border="1px solid grey" height="120" width="100"><br><br>
				<input id="PhotoInput" onchange="viewPic(this.form.PhotoFile)" style="" type="file"/>
				<input id="Photo" name="Photo" type="text"/>
				<!-- 先提交信息再更新Photo -->
				<br>
			</div>
			<div style="float:left;width:20%;height:20px;"></div>
			<div style="float:left;width:30%;height:20px;"><input type="button" value="确定" onclick="submitPhoto()"></div>
			<div style="float:left;width:30%;height:20px;"><input type="button" value="取消" onclick="cancelPhoto()"></div>
			<div style="float:left;width:20%;height:20px;"></div>
			</div>
		</div>
	</td>
</tr><tr>
	<td>性别</td><td><input name="Sex" type="text"/></td>
	<td>学籍状态</td><td colspan="2"><input name="Enrolment" type="text"/></td>
</tr><tr>
	<td>民族</td><td><input name="Nation" type="text"/></td>
	<td>出生日期</td><td colspan="2"><input name="Birthday" type="text"/></td>
</tr><tr>
	<td>宿 舍</td><td><input name="Dormitory" type="text"/></td>
	<td>籍贯</td><td colspan="2"><input name="Native" type="text"/></td>
</tr><tr>
	<td>培养层次</td><td id="EduLevel"><input name="EduLevel" type="text"/></td>
	<td>身份证号</td><td id="IDCard" colspan="2"><input name="IDCard" type="text"/></td>
</tr><tr>
	<td>政治面貌</td><td><input name="PolStatus" type="text"/></td>
	<td>联系电话</td><td colspan="2"><input name="Phone" type="text"/></td>
</tr><tr>
	<td>邮政编码</td><td><input name="PosCode" type="text"/></td>
	<td>家庭地址</td><td colspan="3"><input name="HomAddress" type="text"/></td>
</tr><tr>
	<td>学籍状态</td><td>=====</td>
	<td>考生类别</td><td><input name="Kslb" type="text"/></td>
	<td width="100px">异动原因</td><td><input name="Ydyy" type="text"/></td>
</tr><tr>
	<td>毕业类别</td><td>本科/专科</td>
	<td>录取专业</td><td><input name="Enrolment" type="text"/></td>
	<td>招生季节</td><td>秋季</td>
</tr><tr>
	<td>入学成绩</td><td><input name="Rxcj" type="text"/></td>
	<td>入学年份</td><td><input name="Rxrq" type="text"/></td>
	<td>入学方式</td><td>---</td>
</tr><tr>
	<td>享受资助</td><td>
		<select name="Xszz"><option>--请选择--</option>
			<option value="0">否</option>
			<option value="1">是</option>
		</select>
	</td>
	<td>学制</td><td>---</td>
	<td>培养类别</td><td>---</td>
</tr><tr>
	<td>培养层次</td><td><input name="EduLevel" type="text"/></td>
	<td align="center">学费</td><td>---</td>
	<td>办学形式</td><td>国家任务</td>
</tr><tr>
	<td>院(系)/部</td><td id="Dept" colspan="2">
		<select id="departSelect" name="DepID" onchange="getMajorByDept()"><option>--请选择--</option></select>
	</td>
	<td>专业</td><td id="Major" colspan="2">
		<select id="majorSelect" onchange="getClassByMajor()"><option>--请选择--</option></select>
	</td>
</tr><tr>
	<td align="center">辅导员</td><td id="Assis">---</td>
	<td>行政班级</td><td id="Clazz">
		<select id="classSelect" name="Clazz"><option>--请选择--</option></select>
	</td>
	<td>校区</td><td>---
	<!-- 
		<select id="Campus">
			<option>--请选择--</option>
			<option value="1">主区</option><option value="0">北区</option>
		</select>
		 -->
	</td>
</tr><tr>
	<td>备注</td><td colspan="5"><textarea name="Remark" rows='2' cols='50' style='width:100%;text-align:left;'></textarea></td>
</tr><tr class="T">
	<td colspan="3" style="height:15px">
		<input type="button" value="提交" onclick="addStu()"/>
	</td>
	<td colspan="3" style="height:15px">
		<input type="reset" value="重置"/>
	</td>
</tr>
</table>
</form>
</center>
</body>
</html>