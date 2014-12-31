<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path%>">
<title><s:text name="%{getText('webroot_name')}"/></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="<%=path %>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/common/loadAjax.js"></script>

<style type="text/css">
*{
	padding: 0px;
	margin: 0px;
	font-size: 12px;
	text-align: center;
}
</style>
</head>
<frameset rows="82px,*,25px" style="width: 100%;" frameborder="no" framespacing="0px">
	<s:if test=" #session.IsAdmin == 1 ">
		<frame src="<%=path %>/webCommon/head.jsp" name="ifhead" marginwidth="0" marginheight="0" frameborder="0"></frame>
		<frameset cols="155px,*">
			<!-- 管理员目录 -->
			<frame src="<%=path %>/webs/a/common/left.jsp" marginwidth="0" marginheight="0" frameborder="0"></frame>
			<frame src="<%=path %>/webCommon/right.jsp" id="ifright" name="ifright" marginwidth="0" marginheight="0" frameborder="0"></frame>
		</frameset>
	</s:if>
	<s:elseif test=" #session.IsAdmin == 0 ">
		<frame src="<%=path %>/webs/s/common/top.jsp" name="ifhead" marginwidth="0" marginheight="0" frameborder="0"></frame>
		<frameset cols="155px,*">
		<!-- 学生目录 -->
		<frame src="<%=path %>/webs/s/common/left.jsp" marginwidth="0" marginheight="0" frameborder="0"></frame>
		<frame src="<%=path %>/webs/s/common/right.jsp" name="mainFrame" marginwidth="0" marginheight="0" frameborder="0"></frame>
		</frameset>
	</s:elseif>
	<s:else>
		<!-- 404 -->
		<frame src="<%=path %>/webCommon/exception/404.jsp" marginwidth="0" marginheight="0" frameborder="0"></frame>
	</s:else>
	<frame src="<%=path %>/webCommon/bottom.jsp" marginwidth="0" marginheight="0" frameborder="0"></frame>
</frameset>

</html>