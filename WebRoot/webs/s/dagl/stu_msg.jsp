<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<style>
td{
	text-align: center;
}
#stuBaseList .d1{
	width: 15px;
}
#stuBaseList .d2{
	width: 120px;
}
#stuBaseList .d3{
	width: 80px;
}
#stuBaseList .d4{
	width: 60px;
}
#stuBaseList .d5{
	width: 60px;
}
#stuBaseList .d6{
	width: 120px;
}
#stuBaseList .d7{
	width: 180px;
}
#stuBaseList .d8{
	width: 200px;
}
#stuBaseList .d9{
	width: 200px;
}
#stuBaseList .d10{
	width: 140px;
}
#stuBaseList .d11{
	width: 140px;
}
#stuBaseList .d12{
	width: 140px;
}
</style>
<script>
//下面的函数通过按钮的onclick调用就是不成功
function toPage()
{
alert("跳转");
	if(document.getElementById("pageNum").value!="" && document.getElementById("pageNum").value!=null)
	{
		var pageNum = document.getElementById("pageNum").value;
		loadModel("studentBaseAction_getPage.html?currentPage="+pageNum+"&pageSize=${pageBean.pageSize}");
	}
}
</script>

<table id="stuBaseList" border="1px" cellspacing="0px">
	<tr style="font-weight: bold;">
		<td class="d1"></td>
		<td class="d1"><input id="${ss.id}" type="checkbox"/></td>
	</tr>
	<tr>
		<td class="d2">学号</td>
		<td class="d2">${ss.sid}</td>
	</tr>
	<tr>
		<td class="d3">姓名</td>
		<td class="d3">${ss.name}</td>
	</tr>
	<tr>
		<td class="d4">性别</td>
		<td class="d4">${sb.gender }</td>
	</tr>
	<tr>
		<td class="d5">民族</td>
		<td class="d5">${sb.nation}</td>
	</tr>
	<tr>
		<td class="d6">生日</td>
		<td class="d6">${sb.birthday}</td>
	</tr>
	<tr>
		<td class="d7">身份证</td>
		<td class="d7">${sb.IDnum}</td>
	</tr>
	<tr>
		<td class="d8">籍贯</td>
		<td class="d8">${sb.origin_place}</td>
	</tr>
	<tr>
		<td class="d9">住址</td>
		<td class="d9">${sb.address}</td>
	</tr>
	<tr>
		<td class="d9">邮编</td>
		<td class="d9">${sb.postcode}</td>
	</tr>
	<tr>
		<td class="d10">联系电话</td>
		<td class="d10">${sb.tel}</td>
	</tr>
	<tr>
		<td class="d11">家庭联系电话</td>
		<td class="d11">${sb.home_tel}</td>
	</tr>
	<tr>
		<td class="d12">邮箱地址</td>
		<td class="d12">${sb.mail}</td>
	</tr>

</table>
