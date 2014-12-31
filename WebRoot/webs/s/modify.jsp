<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" rev="stylesheet" href="../../css/webs_s/style.css" type="text/css" media="all" />
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
font-size:11px; 
padding: 6px 6px 6px 12px; 
color: #4f6b72; 
} 
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
#need {margin: 20px auto 0;width: 610px;}
#need li {height: 26px;width: 600px;font: 12px/26px Arial, Helvetica, sans-serif;background: #FFD;border-bottom: 1px dashed #E0E0E0;display: block;cursor: text;padding: 7px 0px 7px 10px!important;padding: 5px 0px 5px 10px;}
#need li:hover,#need li.hover {background: #FFE8E8;}
#need input {line-height: 14px;background: #FFF;height: 14px;width: 200px;border: 1px solid #E0E0E0;vertical-align: middle;padding: 6px;}
#need label {padding-left: 30px;}
#need label.old_password {background-position: 0 -277px;}
#need label.new_password {background-position: 0 -1576px;}
#need label.rePassword {background-position: 0 -1638px;}
#need label.email {background-position: 0 -429px;}
#need dfn {display: none;}
#need li:hover dfn, #need li.hover dfn {display:inline;margin-left: 7px;color: #676767;
</style>
<script type="text/javascript">
function suckerfish(type, tag, parentId) {
if (window.attachEvent) {
window.attachEvent("onload", function() {
var sfEls = (parentId==null)?document.getElementsByTagName(tag):document.getElementById(parentId).getElementsByTagName(tag);
type(sfEls);
});
}
}
hover = function(sfEls) {
for (var i=0; i<sfEls.length; i++) {
sfEls[i].onmouseover=function() {
this.className+=" hover";
}
sfEls[i].onmouseout=function() {
this.className=this.className.replace(new RegExp(" hover\\b"), "");
}
}
}
suckerfish(hover, "li");
</script>
</head>

<body class="ContentBody">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >密码修改</th>
  </tr>
  <tr>
    <td class="CPanel">		
		<TABLE border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>基本信息</legend>
				<form action="" method="post" align="center">	
				<ol id="need">
			
<li><label class="old_password">原始密码：</label> <input name='old_password' type='password' id='old_password' /><span id="a1"></span></li>
<li><label class="new_password">新的密码：</label> <input name='new_password' type='password' id='new_password' /><span id="a2"></span></li>
<li><label class="rePassword">重复密码：</label> <input type='password' id='rePassword' /><span id="a3"></span></li>
</ol> 
<input type="submit" name="Submit" value="确认修改" onclick="checkuser()"/>

</ol>

	</form>
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
