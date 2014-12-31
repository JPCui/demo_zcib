
function flushVerifyCode()
{
	$("#imgVerifyCode").attr("src", "/demo_zcib/util/VerifyCode.act?time="+new Date().getTime());
}