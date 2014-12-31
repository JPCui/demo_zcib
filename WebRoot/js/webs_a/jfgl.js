
function getJfsByClass()
{
	var clazz = $("#classSelect option:selected").text();
	var act = webroot_site+"/webs_a/getJfsByClass.act";
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
function backList(data)
{
	$(window.parent.frames["ifright"].document).find("#list").html(data);
}