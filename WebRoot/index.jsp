<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生信息管理系统登陆</title>
<style>
body{ margin: 0; padding: 0px; }
a {text-decoration: NONE}
a:link {color:black}
a:visited{color:black} 
a:active{color:black} 
#cent{
  width:900px;
  height:370px;
  position:relative;
  background-image:url("<%=path %>/img/webs_s/bj.jpg");
}

.yuan{border:2px;
solid: #C0C0C0;
-moz-border-radius:10px;
-webkit-border-radius:10px;
border-radius:10px;
margin-left:450px;
top:30px;
position:relative;
padding:5px;
background-image:url("<%=path %>/img/webs_s/3.png");
width:400px;
height:300px;
behavior: url(iecss3.htc);
} 
.STYLE1 {
  font-size: 11pt;
  font-weight: bold;
}
</style>
<script type="text/javascript" src="<%=path %>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/ajax/verifyCode.js"></script>
<script type="text/javascript" src="<%=path %>/js/ajax/login.js"></script>
<script type="text/javascript">
function checkuser()
{
	
  var user=document.getElementById("t_user");
  if(user.value==''||user.value==null)
  {
 document.getElementById("y_user").innerHTML="<font color='red'>此项为必填项</font>";
  }
}
</script>
</head>

<div style="width:900px;height:620px; border:#8E8E8E 2px solid; margin-left:220px; margin-top:0px; position:relative; ">
   <div style="width:900px;height:150px;border:red 0px solid; margin-left:0px; margin-top:0px; position:relative; ">
	<img style="position:absolute;left:0px;top:0px;width:100%;height:100%;z-Index:-1; border:0" src="<%=path %>/img/webs_s/zcib.jpg"/>
    </div>
  <div id="cent">
    
     <div class='yuan'> 
      <s:form id="LoginForm" name="" method="post" action="login" namespace="/webs_s">
        <table  style="margin:auto; width:100%;">
        <tr>
        <td width="200">&nbsp;</td>
        <td  colspan="2">&nbsp;</td>
      </tr>
      <tr>
        <td width="200">&nbsp;</td>
        <td  colspan="2">&nbsp;</td>
      </tr>
         <tr>
        <td width="200">&nbsp;</td>
        <td  colspan="2">&nbsp;</td>
      </tr>
      <tr>
        <td height="30"><div align="right" class="STYLE1">权&nbsp; 限：</div></td>
        <td height="30">
		<select id="privilege" onchange="changeAction()" style="height:25px; width:150px;">
			<option selected="selected" title="/webs_s/login.act">学生</option>
			<option title="/webs_a/login.act">管理员</option>
		</select>
        </td>
        <td></td>
      </tr>
      <tr>
        <td height="35"><div align="right" class="STYLE1">学&nbsp; 号：</div></td>
        <td height="35" colspan="2"><input type="text" name="id" id="id" onfocus="checkuser()" style="height:25px; width:150px; font-size:15pt; font-weight:bold;" /><span id="y_user"></span></td>
      </tr>
      <tr>
        <td height="35"><div align="right" class="STYLE1">密&nbsp; 码：</div></td>
        <td height="35" colspan="2"><input type="password" name="pwd" id="pwd" style="height:25px; width:150px; font-size:15pt; font-weight:bold;" /></td>
      </tr>
      <tr>
        <td height="35"><div align="right" class="STYLE1">验证码：</div></td>
        <td width="150" height="40"><input type="text" name="verifyCode" style="height:25px; width:150px; font-size:15pt; font-weight:bold;" /></td>
        <td width="100"><img id="imgVerifyCode" src="<%=path %>/util/VerifyCode.act" onclick="flushVerifyCode()"/></td>
      </tr>
      <tr>
        <td height="35">&nbsp;</td>
        <td height="30" colspan="1"><input type="submit" value="登陆" onclick="getok()"/></td>
        <td height="30" colspan="1"><font id="info" style='color:red;'>${ErrMsg }</font></td>
      </tr>
    </table>
      </s:form>
    </div>
   
    </div>
    <div style="width:900px;height:80px; border:solid margin-left:0px; margin-top:0px; position:relative; text-align:center;">
      <hr>
      <br>
      <table align="center">
        <tr>
          </td>&nbsp;</td>
          </td>&nbsp;</td>
        </tr>
      <tr>
      </td><a href="http://www.zcib.edu.cn">中原工学院信息商务学院</a>&nbsp;邮编：451191</td>
    </tr>
    <tr>
      <td>版权所有：<a href="http://www.zcib.edu.cn/jyjx.aspx">中原工学院信息商务学院教务科技处</a></td>
    </tr>
    <tr>
      <td>技术支持：<a href="http://www.zcib.edu.cn/cs.aspx">中原工学院信息商务学院计算机科学系</a> &nbsp;开发时间：2013-12-30</td>
    </tr>
      </table>
    </div>
</div>
</html>