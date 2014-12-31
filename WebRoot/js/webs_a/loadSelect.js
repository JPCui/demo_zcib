var webroot_site = "/demo_zcib";
function loadDepartment()
{
	var privilege = $(window.parent.frames["ifhead"].document).find("#privilege").attr("name");
//	var privilege = "webs_a";
	//项目名 + namespace + url + 处理后缀
	var url = webroot_site+"/" + privilege + "/getAllDepartsJson.act";
	$.ajax({
		type : "POST",
		url : url,
		//成功后，调用函数
		success : backDept
	});
}
//返回信息
function backDept(data)
{
	$.each(data.jsonMap,function(key,value){
		var option = "<option value='"+value.ID+"'>"+value.Name+"</option>";
		$(window.parent.frames["ifright"].document).find("#departSelect").append(option);//这句。。。
	});
}
function getMajorByDept()
{
	var privilege = $(window.parent.frames["ifhead"].document).find("#privilege").attr("name");
	var DeptID = $("#departSelect option:selected").attr("value");
	//项目名 + namespace + url + 处理后缀
	var url = webroot_site+"/" + privilege + "/getMajorJsonByDept.act";
	$.ajax({
		type : "POST",
		data : "DeptID="+DeptID,
		url : url,
		//成功后，调用函数
		success : backMajor
	});
}
function backMajor(data)
{
	$(window.parent.frames["ifright"].document).find("#majorSelect").empty();
	$(window.parent.frames["ifright"].document).find("#majorSelect").append("<option>--请选择--</option>");
	$(window.parent.frames["ifright"].document).find("#classSelect").empty();
	$(window.parent.frames["ifright"].document).find("#classSelect").append("<option>--请选择--</option>");
	$.each(data.jsonMap,function(key,value){
		var option = "<option value='"+value.ID+"'>"+value.Name+"</option>";
		//alert(value.ID+".."+value.Name);
		$(window.parent.frames["ifright"].document).find("#majorSelect").append(option);
	});
}
function loadDepartMajor(currDepart,currMajor)
{
	var privilege = $(window.parent.frames["ifhead"].document).find("#privilege").attr("name");
//	var privilege = "webs_a";
	//项目名 + namespace + url + 处理后缀
	var url = webroot_site+"/" + privilege + "/getAllDepartsJson.act";
	$.ajax({
		type : "POST",
		url : url,
		//成功后，调用函数
		success : function(data){
			$.each(data.jsonMap,function(key,value){
				var option;
				if(currDepart == value.Name)
				{
					option = "<option value='"+value.ID+"' selected='selected'>"+value.Name+"</option>";
				}
				else
				{
					option = "<option value='"+value.ID+"'>"+value.Name+"</option>";
				}
				$(window.parent.frames["ifright"].document).find("#departSelect2").append(option);//这句。。。
			});
			getMajorByDept2(currMajor);
		}
	});
}
function getMajorByDept2(currValue)
{
	var privilege = $(window.parent.frames["ifhead"].document).find("#privilege").attr("name");
	var DeptID = $("#departSelect2 option:selected").attr("value");
	//项目名 + namespace + url + 处理后缀
	var url = webroot_site+"/" + privilege + "/getMajorJsonByDept.act";
	$.ajax({
		type : "GET",
		data : "DeptID="+DeptID,
		url : url,
		//成功后，调用函数
		success : function(data){
			var majorSelect2 = $(window.parent.frames["ifright"].document).find("#majorSelect2");
			majorSelect2.empty();
			majorSelect2.append("<option>--请选择--</option>");
			$.each(data.jsonMap,function(key,value){
				var option;
				if(currValue == value.Name)
				{
					option = "<option value='"+value.ID+"' selected='selected'>"+value.Name+"</option>";
				}
				else
				{
					option = "<option value='"+value.ID+"'>"+value.Name+"</option>";
				}
				$(window.parent.frames["ifright"].document).find("#majorSelect2").append(option);
			});
		}
	});
}
function getClassByMajor()
{
	var privilege = $(window.parent.frames["ifhead"].document).find("#privilege").attr("name");
	var MajorID = $("#majorSelect option:selected").attr("value");
	//项目名 + namespace + url + 处理后缀
	var url = webroot_site+"/" + privilege + "/getClassByMajor.act";
	$.ajax({
		type : "POST",
		data : "MajorID="+MajorID,
		url : url,
		//成功后，调用函数
		success : backClass
	});
}
function backClass(data)
{
	$(window.parent.frames["ifright"].document).find("#classSelect").empty();
	$(window.parent.frames["ifright"].document).find("#classSelect").append("<option>--请选择--</option>");
	$.each(data.jsonMap,function(key,value){
		var option = "<option value='"+value.Name+"'>"+value.Name+"</option>";
		//alert(value.ID+".."+value.Name);
		$(window.parent.frames["ifright"].document).find("#classSelect").append(option);
	});
}