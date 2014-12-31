var PRO_NAME = "/demo_zcib";
/*
function login()
{
	//验证码验证
	isRightCode();
	//登录验证
	checkLogin();
}
//登录验证
function checkLogin()
{
	var id = $("#id").attr("value");
	var pwd = $("#pwd").attr("value");
	var inputVerifyCode = $("#inputVerifyCode").attr("value");
	var data = "id=" + id + "&pwd=" + pwd + "&inputVerifyCode=" + inputVerifyCode;
	$.ajax({
		type : "POST",
		url : PRO_NAME+"/adminAction_login.html",
		data : data,
		//成功后，调用函数
		success : backLogin
	});
}
//验证登录返回信息
function backLogin(data)
{
	$("#info").html(data);
}
*/
//
function changeAction()
{
	var act = $("#privilege option:selected").attr("title");
	act = PRO_NAME + act;
	$("#LoginForm").attr("action",act);
	
}