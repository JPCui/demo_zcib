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
Tr.C{
	background-color: rgb(255,255,255);
}
tr.T{
	background-color: rgb(191,229,213);
}
td{
	height: 20px;
	font-size: 12px;
	word-break: break-all;
}
td input{
	width: 100%;
}
td select{
	width: 100%;
}
td textarea{
	text-align:left;
	width: 100%;
}
</style>
<script type="text/javascript" src="<%=path %>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/ajaxfileupload.js"></script>
<script type="text/javascript" src="<%=path %>/js/common/tools.js"></script>
<script type="text/javascript" src="<%=path %>/js/webs_a/dagl.js"></script>

<script type="text/javascript">
function toEdit(edit)
{
	$( "td.e"+edit ).each(function (n,obj) {
		obj.innerHTML = "<input type='text' title='" + obj.innerHTML + "' value='" + obj.innerHTML + "'/>";
	});
	$( "td.remark"+edit ).each(function (n,obj) {
		obj.innerHTML = "<textarea rows='2' cols='50' style='width:100%;text-align:left;' title='" + obj.innerHTML + "'>"+ obj.innerHTML +"</textarea>";
	});
	$( "td.YN"+edit ).each(function (n,obj) {
		var inner = obj.innerHTML;
		var s = "";
		if(inner.indexOf("是") != -1)
		{
			s = "<select style='width:100%;text-align:left;' title='" + inner + "'>"
				+ "<option value='1' selected='selected'>是</option>"
				+ "<option value='0'>否</option>"
				+ "</select>";
		}else{
			s = "<select style='width:100%;text-align:left;' title='" + inner + "'>"
				+ "<option value='1'>是</option>"
				+ "<option value='0' selected='selected'>否</option>"
				+ "</select>";
		}
		obj.innerHTML = s;
	});
	
	$("#edit"+edit).css("display","none");
	$("#submit"+edit).css("display","");
	$("#cancel"+edit).css("display","");
	$("#delete"+edit).css("display","none");
	$("#print"+edit).css("display","none");
}

function cancelEdit(id)
{
	$( "td.e"+id ).each(function (n,obj) {
		obj.innerHTML = obj.getElementsByTagName("input")[0].title;
	});
	$( "td.remark"+id ).each(function (n,obj) {
		obj.innerHTML = obj.getElementsByTagName("textarea")[0].title;
	});
	$( "td.YN"+id ).each(function (n,obj) {
		obj.innerHTML = obj.getElementsByTagName("select")[0].title;
	});
	
	$("#edit"+id).css("display","");
	$("#submit"+id).css("display","none");
	$("#cancel"+id).css("display","none");
	$("#delete"+id).css("display","");
	$("#print"+id).css("display","");
}
//提交学生表,并更新
function submitEdit(Number)
{
	//StuBase
	var Password = $("#Password").text();
	var Name = $("#Name").find("input").attr("value");
	var Enrolment = $("#Enrolment").find("input").attr("value");
	var DepID = $("#DepID").text();
	var Clazz = $("#Clazz").text();

	var Photo = $("#Photo").attr("title");
	//StuDetail
	var Sex = $("#Sex").find("input").attr("value");
	var IDCard = $("#IDCard").find("input").attr("value");
	var Birthday = $("#Birthday").find("input").attr("value");
	var Nation = $("#Nation").find("input").attr("value");
	var PolStatus = $("#PolStatus").find("input").attr("value");
	
	var Native = $("#Native").find("input").attr("value");
	var Dormitory = $("#Dormitory").find("input").attr("value");
	var PosCode = $("#PosCode").find("input").attr("value");
	var Phone = $("#Phone").find("input").attr("value");
	var Ydyy = $("#Ydyy").find("input").attr("value");

	var HomAddress = $("#HomAddress").find("input").attr("value");
	var Kslb = $("#Kslb").find("input").attr("value");
	var Rxcj = $("#Rxcj").find("input").attr("value");
	var Rxrq = $("#Rxrq").find("input").attr("value");
	var Xszz = $("#Xszz").find("select").val();

	var EduLevel = $("#EduLevel").find("input").attr("value");
	var Remark = $("#Remark").find("textarea").attr("value");
	
	//项目名 + namespace + url + 处理后缀
	var privilege = $(window.parent.frames["ifhead"].document).find("#privilege").attr("name");
	var url = "/demo_zcib/" + privilege + "/oper_stu_updateStu.act";
	$.ajax({
		type : "POST",
		data : {
			"Number":Number,
			//StuBaseInfo
			"pwd":Password,"Name":Name,"Sex":Sex,"Enrolment":Enrolment,"DepID":DepID,
			"Clazz":Clazz,
			
			//StuDetailInfo
			"Dormitory":Dormitory,"Photo":Photo,"EduLevel":EduLevel,"PolStatus":PolStatus,"Nation":Nation,
			"Birthday":Birthday,"Native":Native,"IDCard":IDCard,"HomAddress":HomAddress,"PosCode":PosCode,
			"Phone":Phone,"Xszz":Xszz,"Kslb":Kslb,"Ydyy":Ydyy,"Rxcj":Rxcj,
			"Rxrq":Rxrq,"Remark":Remark
		},
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		dataType: "html",
		url : url,
		//成功后，调用函数
		success : function(data){
			alert("提示："+data);
			if(data=="更新成功")
			{
				getStuFull(Number);
			}
		}
	});
}
//提交更新社会关系表,并更新
function submitREdit(id)
{
	var Number = $("#Number").text();
	var Name = $("#Name"+id).find("input").attr("value");
	var Relation = $("#Relation"+id).find("input").attr("value");
	var Age = $("#Age"+id).find("input").attr("value");
	var PoliticalStatus = $("#PoliticalStatus"+id).find("input").attr("value");
	var Company = $("#Company"+id).find("input").attr("value");
	var Phone = $("#Phone"+id).find("input").attr("value");
	var Remark = $("#Remark"+id).find("textarea").attr("value");

	var privilege = $(window.parent.frames["ifhead"].document).find("#privilege").attr("name");
	//项目名 + namespace + url + 处理后缀
	var url = "/demo_zcib/" + privilege + "/oper_stu_updateRelation.act";
	$.ajax({
		type : "POST",
		data : {"id":id,"Name":Name,"Relation":Relation,"Age":Age,"PolStatus":PoliticalStatus,
			"Company":Company,"Phone":Phone,"Remark":Remark,"Number":Number},
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		dataType: "html",
		url : url,
		//成功后，调用函数
		success : function(data){
			alert(data);
			if(data=="更新成功")
			{
				getStuFull(Number);
			}
		}
	});
}

function delRelation()
{
	var privilege = $(window.parent.frames["ifhead"].document).find("#privilege").attr("name");
	var url = "/demo_zcib/" + privilege + "/oper_stu_delRelation.act";
	$.ajax({
		type : "POST",
		data : {"id":id},
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		dataType: "html",
		url : url,
		//成功后，调用函数
		success : function(data){
			alert(data);
			if(data=="更新成功")
			{
				getStuFull(Number);
			}
		}
	});
}

function addR()
{
	$( "#abs" ).css("display","");
	$( "#abs_r" ).css("display","");
}
function cancelR()
{
	$( "#abs" ).css("display","none");
	$( "#abs_r" ).css("display","none");
}
function submitR()
{
	var id = 0;
	var Number = $("#Number").text();
	var Name = $("#Name"+id).attr("value");
	var Relation = $("#Relation"+id).attr("value");
	var Age = $("#Age"+id).attr("value");
	var PoliticalStatus = $("#PoliticalStatus"+id).attr("value");
	var Company = $("#Company"+id).attr("value");
	var Phone = $("#Phone"+id).attr("value");
	var Remark = $("#Remark"+id).attr("value");

	var privilege = $(window.parent.frames["ifhead"].document).find("#privilege").attr("name");
	//项目名 + namespace + url + 处理后缀
	var url = "/demo_zcib/" + privilege + "/oper_stu_addRelation.act";
	$.ajax({
		type : "GET",
		data : {"Name":Name,"Relation":Relation,"Age":Age,"PolStatus":PoliticalStatus,
			"Company":Company,"Phone":Phone,"Remark":Remark,"Number":Number},
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		dataType: "html",
		url : url,
		//成功后，调用函数
		success : function(data){
			alert(data);
			if(data=="社会关系添加成功")
			{
				getStuFull(Number);
			}
		}
	});
}

function print(clas)
{
}

</script>
</head>
<body style="margin:0 auto;width:90%;">
<center>
<div style="display: none;">
<b id="Password">${bean.Password }</b>
<b id="DepID">${bean.DepID }</b>
</div>
<div id="abs" style="display:none;position:fixed;top:0;left:0;width:100%;height:100%;filter:alpha(opacity=50);-moz-opacity:0.5;-khtml-opacity: 0.5;opacity: 0.5; background-color: grey;"></div>
<div id="loading" style="display:none;position:fixed;left:0;top:100px;width:100%;height:20px;line-height:20px;filter:alpha(opacity=50);-moz-opacity:0.5;-khtml-opacity: 0.5;opacity: 0.5; background-color: yellow;">
<marquee vspace="3" direction="right">正在加载。。。</marquee>
</div>
<table border="0" cellpadding="0" cellspacing="1" width="640" style="margin:0 auto;background-color: green;">
<tr class="T"><td colspan="6" style="height:15px;background-color: rgb(191, 229, 213);">基本信息</td></tr>
<tr class="C">
	<td valign="middle" width="92">学 号</td><td id="Number" width="133">${bean.ID}</td>
	<td valign="middle" width="110">姓 名</td><td id="Name" class="e${bean.ID }" colspan="2">${bean.Name}</td>
	<td rowspan="6" width="103" valign="middle" style="">
	<div style="position: relative;border: 1px solid rgb(217,217,217);">
		<img id="Photo" title="${bean.Photo}" src="<%=path %>/img/stu/${bean.Photo}" onerror="this.src='<%=path %>/img/stu/photo_blank.jpg'" border="0" height="120" width="100">
		<a onclick="editPhoto()" style="border: 1px solid rgb(217,217,217);background-color: rgb(242,242,242);position: absolute;bottom:0px;right:0px;" href="javascript:;">
		更换</a>
	</div>
	<div id="abs_photo" style="display:none;position:fixed;top:0;left:0;width:100%;height:100%;background: transparent;">
		<div style="margin:50 auto;height:70%;width:60%; background-color: rgb(255,251,240);">
		<div style="float:left;width: 100%;">
			<img id="showPic" name="showPic" alt="图片预览" src="<%=path %>/img/stu/photo_blank.jpg" border="1px solid grey" height="120" width="100"><br><br>
			<input id="PhotoInput" name="PhotoInput" onchange="viewPic(this)" style="" type="file"/>
			<br>
		</div>
		<div style="float:left;width:20%;height:20px;"></div>
		<div style="float:left;width:30%;height:20px;"><input type="button" value="确定" onclick="updatePhoto()"></div>
		<div style="float:left;width:30%;height:20px;"><input type="button" value="取消" onclick="cancelPhoto()"></div>
		<div style="float:left;width:20%;height:20px;"></div>
		</div>
	</div>
	</td>
</tr><tr class="C">
	<td valign="middle">性别</td><td id="Sex" class="e${bean.ID }">${bean.Sex}</td>
	<td valign="middle">民族</td><td id="Nation" class="e${bean.ID }" colspan="2">${bean.Nation}</td>
</tr><tr class="C">
	<td valign="middle">学籍状态</td><td id="Enrolment" class="e${bean.ID }">${bean.Enrolment}</td>
	<td valign="middle">出生日期</td><td id="Birthday" class="e${bean.ID }" colspan="2">${bean.Birthday}</td>
</tr><tr class="C">
	<td valign="middle">宿 舍</td><td id="Dormitory" class="e${bean.ID }">${bean.Dormitory}</td>
	<td valign="middle">籍贯</td><td id="Native" class="e${bean.ID }" colspan="2">${bean.Native}</td>
</tr><tr class="C">
	<td align="center">培养层次</td><td id="EduLevel" class="e${bean.ID }">${bean.EduLevel }</td>
	<td valign="middle">身份证号</td><td id="IDCard" class="e${bean.ID }" colspan="2">${bean.IDCard}</td>
</tr><tr class="C">
	<td valign="middle">政治面貌</td><td id="PolStatus" class="e${bean.ID }">${bean.PolStatus}</td>
	<td valign="middle">联系电话</td><td id="Phone" class="e${bean.ID }" colspan="2">${bean.Phone}</td>
</tr><tr class="C">
	<td width="100">邮政编码</td><td id="PosCode" class="e${bean.ID }">${bean.PosCode}</td>
	<td valign="middle">家庭地址</td><td id="HomAddress" class="e${bean.ID }" colspan="3">${bean.HomAddr}</td>
</tr><tr class="C">
	<td valign="middle">学籍状态</td><td id="Enrolment" class="e${bean.ID }">${bean.Enrolment }</td>
	<td align="center">考生类别</td><td id="Kslb" class="e${bean.ID }">${bean.Kslb}</td>
	<td valign="middle">异动原因</td><td id="Ydyy" class="e${bean.ID }">${bean.Ydyy }</td>
</tr><tr class="C">
	<td valign="middle">毕业类别</td><td>本科/专科</td>
	<td valign="middle">录取专业</td><td>${bean.Major }</td>
	<td valign="middle">招生季节</td><td>秋季</td>
</tr><tr class="C">
	<td valign="middle">入学成绩</td><td id="Rxcj" class="e${bean.ID }">${bean.Rxcj}</td>
	<td valign="middle">入学年份</td><td id="Rxrq" class="e${bean.ID }">${bean.Rxnf}</td>
	<td valign="middle">入学方式</td><td>---</td>
</tr><tr class="C">
	<td valign="middle">培养类别</td><td>---</td>
	<td valign="middle">享受资助</td>
	<td id="Xszz" class="YN${bean.ID }">${bean.Xszz=="true"?"是":"否"}</td>
	<td valign="middle">学 制</td><td id="Education">${bean.Education}</td>
</tr><tr class="C">
	<td valign="middle">办学形式</td><td>国家任务</td>
	<td valign="middle">异动原因</td><td id="EduLevel" class="e${bean.ID }">${bean.Ydyy }</td>
	<td align="center">学费</td><td id="Education" class="e${bean.ID }">${bean.Tuition}</td>
</tr><tr class="C">
	<td valign="middle">院(系)/部</td><td id="Dept" colspan="2">${bean.Depart}</td>
	<td valign="middle">专业</td><td id="Major" colspan="2">${bean.Major}</td>
</tr><tr class="C">
	<td align="center">辅 导 员</td><td>---</td>
	<td valign="middle">行政班级</td><td id="Clazz">${bean.Class}</td>
	<td valign="middle">校区</td>
	<td id="Campus">
		${#bean.Campus==1?"主区":"北区" }
	</td>
</tr><tr class="C">
	<td valign="middle">备 注</td><td id="Remark" class="remark${bean.ID }" colspan="5">${bean.Remark}</td>
</tr><tr class="T">
	<td colspan="3" style="height:15px;background-color: rgb(191, 229, 213);">
		<a id="print${bean.ID }" onclick="print('${bean.ID }')" style="background:green; color:#fff; z-index:1;" href="javascript:;">打印</a>
		<a id="submit${bean.ID }" onclick="submitEdit('${bean.ID }')" style="display:none;background:green; color:#fff; z-index:1;" href="javascript:;">提交</a>
	</td>
	<td colspan="3" style="height:15px;background-color: rgb(191, 229, 213);">
		<a id="edit${bean.ID }" onclick="toEdit('${bean.ID }')" style="background:green; color:#fff; z-index:1;" href="javascript:;">修改</a>
		<a id="cancel${bean.ID }" onclick="cancelEdit('${bean.ID }')" style="display:none;background:green; color:#fff; z-index:1;" href="javascript:;">取消</a>
	</td>
</tr>

<tr class="C"><td colspan="6" style="height:15px;"><br></td></tr>
<tr class="T"><td colspan="6" style="height:15px;background-color: rgb(191, 229, 213);">社会信息<div style="float: right;cursor: pointer;" onclick="addR()">[增加]</div></td></tr>
<s:iterator value="#request.list" status="i">
<tr class="C" style="display: none;">
	<td valign="middle">ID</td><td>${ID }</td>
</tr>
<s:if test="#i.index != 0"><tr class="C"><td colspan="6" style="height:15px"><br></td></tr></s:if>
<tr class="C">
	<td valign="middle">姓名</td><td id="Name${ID }" class="e${ID }">${Name }</td>
	<td valign="middle">关系</td><td id="Relation${ID }" class="e${ID }" colspan="3">${Relation }</td>
</tr><tr class="C">
	<td valign="middle">年龄</td><td id="Age${ID }" class="e${ID }">${Age }</td>
	<td valign="middle">政治面貌</td><td id="PoliticalStatus${ID }" class="e${ID }" colspan="3">${PoliticalStatus }</td>
</tr><tr class="C">
	<td valign="middle">工作单位</td><td id="Company${ID }" class="e${ID }">${Company }</td>
	<td valign="middle">联系方式</td><td id="Phone${ID }" class="e${ID }" colspan="3">${Phone }</td>
</tr><tr class="C">
	<td valign="middle">备 注</td><td id="Remark${ID }" class="remark${ID }" colspan="5">${Remark}</td>
</tr>
<tr class="T">
	<td colspan="3" style="height:15px">
		<a id="delete${ID }" onclick="delRelation('${ID }')" style="background:green; color:#fff; z-index:1;" href="javascript:;">删除</a>
		<a id="submit${ID }" onclick="submitREdit('${ID }')" style="display: none; background:green; color:#fff; z-index:1;" href="javascript:;">提交</a>
	</td>
	<td colspan="3" style="height:15px">
		<a id="edit${ID }" onclick="toEdit('${ID }')" style="background:green; color:#fff; z-index:1;" href="javascript:;">修改</a>
		<a id="cancel${ID }" onclick="cancelEdit('${ID }')" style="display:none; background:green; color:#fff; z-index:1;" href="javascript:;">取消</a>
	</td>
</tr>
</s:iterator>
</table>
<div id="abs_r" style="display:none;position:fixed;top:0;left:0;width:100%;height:100%;background: transparent;">
<div style="height:30%;width :700px; margin: 20px auto; padding: 40px;">
<table border="0" cellpadding="0" cellspacing="1" width="640" style="margin:0 auto;background-color: green;">
<tr class="C">
	<td valign="middle">姓名</td><td><input id="Name0" type="text"/></td>
	<td valign="middle">关系</td><td><input id="Relation0" type="text"/></td>
</tr><tr class="C">
	<td valign="middle">年龄</td><td><input id="Age0" type="text"/></td>
	<td valign="middle">政治面貌</td><td><input id="PoliticalStatus0" type="text"/></td>
</tr><tr class="C">
	<td valign="middle">工作单位</td><td><input id="Company0" type="text"/></td>
	<td valign="middle">联系方式</td><td><input id="Phone0" type="text"/></td>
</tr><tr class="C">
	<td valign="middle">备 注</td><td colspan="5"><textarea id="Remark0"></textarea></td>
</tr><tr class="C">
	<td colspan="2"><input type="button" value="提交" onclick="submitR()"/></td>
	<td colspan="2"><input type="button" value="取消" onclick="cancelR()"/></td>
</tr>
</table>
</div>
</div>
</center>
</body>
</html>