<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE style PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<style>
<!--
-->
</style>
<link href="<s:text name="%{getText('webroot_site')}"/>/css/left.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<s:text name="%{getText('webroot_site')}"/>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<s:text name="%{getText('webroot_site')}"/>/js/common/leftMenu.js"></script>
<script type="text/javascript">
function changeFrameSrc(src)
{
	src = "/demo_zcib/webs/a/"+src+".jsp";
	$("#ifright",window.parent.document).attr("src",src);
}
function changeFrameAct(act)
{
	act = "/demo_zcib/webs_a/"+act+".act";
	$("#ifright",window.parent.document).attr("src",act);
}
</script>
</head>
<body>
<div id="left">
<s:if test="#session.Role.ArchiveMgr">
<div class="submenu" onclick="changeMenu(this)">
	<b>档案管理→</b>
	<ul style="display: none;">
		<li><a id="dagl/dacx" href="javascript:;" onclick="changeFrameSrc(this.id)">
		档案查询</a></li>
		<li><a id="dagl/add" href="javascript:;" onclick="changeFrameSrc(this.id)">
		档案录入</a></li>
		<li><a id="" href="javascript:;" onclick="changeFrameSrc('dagl/dacx')">
		档案修改</a></li>
	</ul>
</div>
</s:if>
<s:if test="#session.Role.DepMgr">
<div class="submenu" onclick="changeMenu(this)">
	<b id="getAllDeparts" onclick="changeFrameAct(this.id)">系部管理→</b>
</div></s:if>
<s:if test="#session.Role.MajorMgr">
<div class="submenu" onclick="changeMenu(this)">
	<b id="zygl/zycx" onclick="changeFrameSrc(this.id)">专业管理→</b>
</div></s:if>
<s:if test="#session.Role.ClassMgr">
<div class="submenu" onclick="changeMenu(this)">
	<b>班级管理→</b>
	<ul style="display: none;">
		<li><a id="bjgl/bjcx" href="javascript:;" onclick="changeFrameSrc(this.id)">班级查询</a></li>
		<li><a id="bjgl/add" href="javascript:;" onclick="changeFrameSrc(this.id)">班级录入</a></li>
		<li><a id="bjgl/bjcx" href="javascript:;" onclick="changeFrameSrc(this.id)">班级修改</a></li>
	</ul>
</div></s:if>
<s:if test="#session.Role.RewardMgr">
<div class="submenu" onclick="changeMenu(this)">
	<b>奖惩管理→</b>
	<ul style="display: none;">
		<li><a id="jcgl/jlcx" href="javascript:;" onclick="changeFrameSrc(this.id)">奖励查询</a></li>
		<li><a id="jcgl/cfcx" href="javascript:;" onclick="changeFrameSrc(this.id)">惩罚查询</a></li>
		<li><a id="jcgl/addcf" href="javascript:;" onclick="changeFrameSrc(this.id)">惩罚录入</a></li>
	</ul>
</div></s:if>
<s:if test="#session.Role.PaymentMgr">
<div class="submenu" onclick="changeMenu(this)">
	<b>交费管理→</b>
	<ul style="display: none;">
		<li><a id="jfgl/jfcx" href="javascript:;" onclick="changeFrameSrc(this.id)">查询</a></li>
		<li><a id="jfgl/add" href="javascript:;" onclick="changeFrameSrc(this.id)">缴费</a></li>
	</ul>
</div></s:if>
<div class="submenu" onclick="changeMenu(this)" style="display: none;">
	<b>系统设置→</b>
	<ul style="display: none;">
		<li><a id="sys/update" href="javascript:;" onclick="changeFrameSrc(this.id)">状态设置</a></li>
	</ul>
</div>
</div>
</body>
</html>