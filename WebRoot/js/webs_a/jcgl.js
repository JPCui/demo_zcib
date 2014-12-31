var webroot_site = webroot_site+"";
//奖惩管理
function getJlsByClass()
{
	var clazz = $("#classSelect option:selected").text();
	var act = webroot_site+"/webs_a/getJlsByClass.act";
	$.ajax({
		type : "POST",
		data : "clazz="+clazz,
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		dataType: "html",
		url : act,
		//成功后，调用函数
		success : backList
	});
}
function getCfsByClass()
{
	var clazz = $("#classSelect option:selected").text();
	var act = webroot_site+"/webs_a/getCfsByClass.act";
	$.ajax({
		type : "POST",
		data : "clazz="+clazz,
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		dataType: "html",
		url : act,
		//成功后，调用函数
		success : backList
	});
}
function loadBean(act,data)
{
	act = webroot_site+"/webs_a/"+act+".act";
	$.ajax({
		type : "GET",
		data : data,
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		dataType: "html",
		url : act,
		//成功后，调用函数
		success : backList
	});
}
function backList(data)
{
	$(window.parent.frames["ifright"].document).find("#list").html(data);
}