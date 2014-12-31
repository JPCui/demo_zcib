//控制menu的折叠
function changeMenu(su)
{
	var uls = document.getElementById("left").getElementsByTagName("ul");
	for(var i=0; i<uls.length; i++)
	{
		uls[i].style.display = "none";
	}
	var bs = document.getElementById("left").getElementsByTagName("b");
	for(var i=0; i<bs.length; i++)
	{
		bs[i].innerHTML=bs[i].innerHTML.replace("↓","→");
	}
	
	var tag_b = su.getElementsByTagName("b")[0];
	tag_b.innerHTML = tag_b.innerHTML.replace("→","↓");
	
	var tag_ul = su.getElementsByTagName("ul")[0];
	tag_ul.style.display = "block";
	tag_ul.style.border = "0px";
}

//frame之间的调用
function loadframe(act,params)
{
	var privilege = $(window.parent.frames["ifhead"].document).find("#privilege").attr("name");
	//项目名 + namespace + url + 处理后缀
	act = "/demo_zcib/" + privilege + "/" + act + ".act";
	if(null != params)
	{
		act += "?" + params;
	}
	$.ajax({
		type : "POST",
		url : act,
		//成功后，调用函数
		success : backframe
	});
}
function backframe(data)
{
	$(window.parent.frames["ifright"]).find("#right").html(data);
}