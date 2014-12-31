var webroot_site = "/demo_zcib";
function addStu()
{
	//
	var Number = $("input[name='Number']").val();
	//StuBase
	var Name = $("input[name='Name']").val();
	var Enrolment = $("input[name='Enrolment']").val();
	var DepID = $("select[name='DepID']").val();
	var Clazz = $("select[name='Clazz']").val();

	var Photo = $("input[name='Photo']").attr("title");///////
	//StuDetail
	var Sex = $("input[name='Sex']").attr("value");
	var IDCard = $("input[name='IDCard']").attr("value");
	var Birthday = $("input[name='Birthday']").attr("value");
	var Nation = $("input[name='Nation']").attr("value");
	var PolStatus = $("input[name='PolStatus']").attr("value");
	
	var Native = $("input[name='Native']").attr("value");
	var Dormitory = $("input[name='Dormitory']").attr("value");
	var PosCode = $("input[name='PosCode']").attr("value");
	var Phone = $("input[name='Phone']").attr("value");
	var Ydyy = $("input[name='Ydyy']").attr("value");

	var HomAddress = $("input[name='HomAddress']").val();
	var Kslb = $("input[name='Kslb']").attr("value");
	var Rxcj = $("input[name='Rxcj']").attr("value");
	var Rxrq = $("input[name='Rxrq']").attr("value");
	var Xszz = $("select[name='Xszz']").val();

	var EduLevel = $("input[name='EduLevel']").attr("value");
	var Remark = $("textarea[name='Remark']").attr("value");
	
	//项目名 + namespace + url + 处理后缀
	var privilege = "/"+$(window.parent.frames["ifhead"].document).find("#privilege").attr("name");
	var url = webroot_site + privilege + "/oper_stu_addStu.act";
	$.ajax({
		type : "POST",
		data : {
			"Number":Number,
			//StuBaseInfo
			"Name":Name,"Sex":Sex,"Enrolment":Enrolment,"DepID":DepID,
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
		}
	});
}
function delStu(Number)
{
	var privilege = "/"+$(window.parent.frames["ifhead"].document).find("#privilege").attr("name");
	var url = webroot_site + privilege + "/oper_stu_delStu.act";
	$.ajax({
		type : "POST",
		data : {"Number":Number},
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		dataType: "html",
		url : url,
		//成功后，调用函数
		success : function(data){
			alert("提示："+data);
		}
	});
}
function getStusByClass()
{
	var clazz = $("#classSelect option:selected").text();
	var privilege = "/"+$(window.parent.frames["ifhead"].document).find("#privilege").attr("name");
	var act = webroot_site+privilege+"/getStusByClass.act";
	$.ajax({
		type : "POST",
		data : "clazz="+clazz,
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		dataType: "html",
		url : act,
		//成功后，调用函数
		success : backStus
	});
}
function backStus(data)
{
	$(window.parent.frames["ifright"].document).find("#stus").html(data);
}
//下面的函数通过按钮的onclick调用就是不成功
function toPage()
{
	if(document.getElementById("pageNum").value!="" && document.getElementById("pageNum").value!=null)
	{
		var pageNum = document.getElementById("pageNum").value;
		loadModel("studentBaseAction_getPage.html?currentPage="+pageNum+"&pageSize=${pageBean.pageSize}");
	}
}
function getStuFull(ID)
{
	var act = webroot_site+"/webs_a/getStuFull.act";
	$.ajax({
		type : "POST",
		data : "id="+ID,
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		dataType: "html",
		url : act,
		//成功后，调用函数
		success : backStuFull
	});
}
function backStuFull(data)
{
	$(window.parent.frames["ifright"].document).find("#stus").html(data);
}
function delStuByNumber(ID)
{
	var act = webroot_site+"/webs_a/oper_stu_delStuByID.act";
	$.ajax({
		type : "POST",
		data : "id="+ID,
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		dataType: "html",
		url : act,
		//成功后，调用函数
		success : backDelStatus
	});
}
function backDelStatus(data)
{
	alert(data);
}
function editPhoto()
{
	$( "#abs" ).css("display","");
	$( "#abs_photo" ).css("display","");
}
function getPicValue(inputPic)
{
	if(inputPic){
	    //ie
	    if (window.navigator.userAgent.indexOf("MSIE")>=1){
	        // IE下取得图片的本地路径
		    $("#showPic").attr("src",inputPic.value);
	    	return;
	    }
	    //firefox
	    else if(window.navigator.userAgent.indexOf("Firefox")>=1){
	        if(inputPic.files){
	            // Firefox下取得的是图片的数据
	            $("#showPic").attr("src",window.URL.createObjectURL(inputPic.files.item(0)));
	            return;
	        }
	        $("#showPic").attr("src",inputPic.value);
	        return;
	    }
	    //IE11与IE7、8也不一样
        $("#showPic").attr("src",window.URL.createObjectURL(inputPic.files.item(0)));
	    return;
	}	
}
function viewPic(inputPic)
{
	if(isFileSuffix($("#PhotoInput").val(),"picture"))alert("图片格式不对");//检查文件后缀
	getPicValue(inputPic);
	checkPhoto($("#showPic"));//检查照片尺寸
	
}
function cancelPhoto()
{
	$( "#abs" ).css("display","none");
	$( "#abs_photo" ).css("display","none");
}
function updatePhoto()
{
	$("#loading")
	.ajaxStart(function(){
        $("#loading").show();
    })//开始上传文件时显示一个图片
    .ajaxComplete(function(){
        $(this).hide();
    });//文件上传完成将图片隐藏起来
    $.ajaxFileUpload({
    	url: webroot_site+"/webs_a/oper_stu_updatePhoto.act",//用于文件上传的服务器端请求地址
        data: {
        	Number : $("#Number").text()
        },
        secureuri:false,//一般设置为false
        fileElementId:'PhotoInput',//文件上传空间的id属性  <input type="file" id="file" name="file" />
        dataType: 'content',//返回值类型 一般设置为json
        success: function (data)  //服务器成功响应处理函数
        {
            alert(data);//从服务器返回的json中取出message中的数据,其中message为在struts2中action中定义的成员变量
            if(typeof(data.error) != 'undefined')
            {
                if(data.error != '')
                {
                    alert(data.error+"...");
                }else
                {
                    alert(data.message+"///");
                }
            }
            //替换图片，不需要页面刷新
        	var src = $("#showPic").attr("src");
        	$("#Photo").attr("src", src );
        },
        error: function (data, status, e)//服务器响应失败处理函数
        {
            alert(e + " : " + data);
        }
    });
	
	cancelPhoto();
}