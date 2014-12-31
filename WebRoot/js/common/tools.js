var webroot_site = "/demo_zcib";
//获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
var curWwwPath=window.document.location.href;
//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
//获取主机地址，如： http://localhost:8083
var localhostPath=curWwwPath.substring(0,pos);
//检验照片格式与大小
function checkPhoto(img)
{
	$("<img/>") // 在内存中创建一个img标记
	    .attr("src", $(img).attr("src"))
	    .load(function() {
	    	//加载后获取图片尺寸
	    	//var picRealWidth = this.width, picRealHeight = this.height;
	        //alert(picRealHeight + "--" + picRealWidth);
	    });
}
//
function isFileSuffix(fileName,suffix)
{
	var suf = fileName.substr(fileName.lastIndexOf("."));
	if(suffix == "picure")
	{
		if(suf == '.bmp' || suf=='.gif' || suf=='.jpeg' || suf=='.png' || suf=='.jpg')
		{
			return true;
		}
	}else if(suf == suffix)
		return true;
	return false;
}