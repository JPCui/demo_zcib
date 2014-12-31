function loadHtmlAjax(url)
{
	//url = "/demo_zcib/webs/s/"+url;
	$.ajax({
		async:false,
		url : url,
		//成功后，调用函数
		success : backList
	});
}
function loadActAjax(url,params)
{
	var privilege = $(window.parent.frames["ifhead"].document).find("#privilege").attr("name");
	//项目名 + namespace + url + 处理后缀
	url = "/demo_zcib/" + privilege + "/" + url + ".act";
	if(null != params)
	{
		url += "?" + params;
	}
	$.ajax({
		type : "POST",
		url : url,
		//成功后，调用函数
		success : backList
	});
}
//返回信息
function backList(data)
{
	$("#dright").html(data);
}
