package cn.zcib.util;

import java.io.PrintWriter;

public class WebUtil {
	public static void addReport(String msg, PrintWriter out, boolean flag){
		if(flag)
		{
			//将信息输出到前台页面
			out.println(msg);
			//将全部缓冲区信息输出
			out.flush();
		}
		else
		{
			//将信息输出到前台页面
			out.println(msg);
		}
	}
	
}
