<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="struts" uri="/struts-tags"%>
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
  height:390px;
  border:0;
  margin-left:0px; 
  margin-top:0px;
  position:relative;
  background-image:url("<%=request.getContextPath()%>/img/index/bj.jpg");
}
.STYLE1 {
  font-size: 11pt;
  font-weight: bold;
}
</style>
</head>

<div style="width:900px;height:640px; border:#8E8E8E 2px solid; margin-left:220px; margin-top:0px; position:relative; ">
   <div style="width:900px;height:150px;border:red 0px solid; margin-left:0px; margin-top:0px; position:relative; ">
	<img style="position:absolute;left:0px;top:0px;width:100%;height:100%;z-Index:-1; border:0" src="img/index/zcib.jpg"/>
    </div>
  <div id="cent">
    <div style="width:900px;height:70px;position:relative; ">
    </div>
     <div style="width:500px;height:200px;margin-left:400px;background-image:url(img/index/login.png);">
       <div style="width:300px;height:200px;margin-left:150px;">
      <form id="form1" name="form1" method="post" action="">
        <table width="300" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="250">&nbsp;</td>
        <td  colspan="2">&nbsp;</td>
      </tr>
      <tr>
        <td height="40"><div align="right" class="STYLE1">帐&nbsp; 号：</div></td>
        <td height="40" colspan="2"><input type="text" name="t_user" style="height:25px; width:150px; font-size:15pt; font-weight:bold;" /></td>
      </tr>
      <tr>
        <td height="40"><div align="right" class="STYLE1">密&nbsp; 码：</div></td>
        <td height="40" colspan="2"><input type="password" name="t_pwd" style="height:25px; width:150px; font-size:15pt; font-weight:bold;" /></td>
      </tr>
      <tr>
        <td height="40"><div align="right" class="STYLE1">验证码：</div></td>
        <td width="150" height="40"><input type="text" name="textfield3" style="height:25px; width:85px; font-size:15pt; font-weight:bold;" /></td>
        <td width="150">&nbsp;</td>
      </tr>
      <tr>
        <td height="40">&nbsp;</td>
        <td height="40" colspan="2"><input type="submit" name="Submit" value="登陆"/></td>
      </tr>
    </table>
      </form>
      </div>
    </div>
    <div style="width:800px;height:100px;margin-left:20px; margin-top:0px; position:relative;  text-align:left;">
      <table width="500" border="0" cellpadding="0" cellspacing="0">
        <tr>
        <td width="50">&nbsp;</td>
      </tr>
      <tr>
        <td ><select onchange="if (this.selectedIndex!=0) window.open(this.value)" style="height:25px; width:150px;">
          <option selected>校内常用站点</option>
          <option value="http://61.163.83.198/jiaowuchu/">学生名单打印</option>
          <option value="http://61.163.83.198/jwweb/">教务系统</option>
        </td>
          </tr>
          <tr><td>&nbsp;&nbsp;</td></tr>
          <tr>
        <td width="200"><select onchange="if (this.selectedIndex!=0) window.open(this.value)" style="height:25px; width:150px;">
          <option selected>部门系部导航</option>
          <option value="http://www.zcib.edu.cn/yuanban.aspx">学院办公室</option>
          <option value="http://www.zcib.edu.cn/jyjx.aspx">教务科技处</option>
          <option value="http://www.zcib.edu.cn/xsgz.aspx">学生工作处</option>
          <option value="http://www.zcib.edu.cn/rsc.aspx">组织人事处</option>
          <option value="http://www.zcib.edu.cn/cwc.aspx">财务资产处</option>
          <option value="http://www.zcib.edu.cn/jyjx.aspx">教务科技处</option>
          </select>
        </td>
          </tr>
       </table>
      
    </div>
    </div>
    <div style="width:900px;height:100px; border:solid margin-left:0px; margin-top:0px; position:relative; text-align:center;">
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