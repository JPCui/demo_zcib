<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
%>
<html>
<head>
<title></title>
<style type="text/css">
*{
	padding: 0px;
	margin: 0px;
	font-size: 12px;
	text-align: center;
}
body{
	background-color: rgb(244, 255, 251);
}
td{
	text-align: center;
}
</style>
<script type="text/javascript" src="<%=path %>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/ajaxfileupload.js"></script>
<script type="text/javascript" src="<%=path %>/js/common/tools.js"></script>
<script type="text/javascript" src="<%=path %>/js/webs_a/loadSelect.js"></script>
<script type="text/javascript" src="<%=path %>/js/webs_a/bjgl.js"></script>
<script type="text/javascript" src="<%=path %>/js/webs_a/dagl.js"></script>
<script type="text/javascript" src="<%=path %>/js/webs_a/jcgl.js"></script>
<script type="text/javascript" src="<%=path %>/js/webs_a/jfgl.js"></script>
</head>
<body>
<div id="right" style="width:95%;height:95%;text-align: center;">
<img src="<%=request.getContextPath()%>/img/common/Logo.JPG" width="100%" height="100%"/>
</div>
</body>
</html>
