var webroot_site = "/demo_zcib";
function addClass()
{
	var privilege = $(window.parent.frames["ifhead"].document).find("#privilege").attr("name");
	var AdvID = $("input[name='AdvID']").attr("value");
	var AssisID = $("input[name='AssisID']").attr("value");
	var ClaAssis = $("input[name='ClaAssis']").attr("value");
	var MajorID = $("#majorSelect option:selected").attr("value");
	var Monitor = $("input[name='Monitor']").attr("value");
	var Name = $("input[name='Name']").attr("value");
	//项目名 + namespace + url + 处理后缀
	var url = "/demo_zcib/" + privilege + "/oper_class_addClass.act";
	$.ajax({
		type : "POST",
		data : {"Adv":AdvID,"Assis":AssisID,"ClaAssis":ClaAssis,"MajorID":MajorID,"Monitor":Monitor,"Name":Name},
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		dataType: "html",
		url : url,
		//成功后，调用函数
		success : function(data){
			alert(data);
		}
	});
}
function getFullClassesByMajor()
{
	var MajorID = $("#majorSelect option:selected").attr("value");
	var act = webroot_site+"/webs_a/getFullClassByMajor.act";
	$.ajax({
		type : "POST",
		data : "MajorID="+MajorID,
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		dataType: "html",
		url : act,
		//成功后，调用函数
		success : backFullClasses
	});
}
function backFullClasses(data)
{
	$(window.parent.frames["ifright"].document).find("#classes").html(data);
}

function lookClass(Name)
{
	var act = webroot_site+"/webs_a/getClassFull.act";
	$.ajax({
		type : "POST",
		data : "Name="+Name,
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		dataType: "html",
		url : act,
		//成功后，调用函数
		success : backFullClass
	});
}
function backFullClass(data)
{
	$("#classes").html(data);
}