package cn.zcib.util;

import java.io.UnsupportedEncodingException;

public class CharsetUtil {
	public static String UTF8_ISO8859(String s)
	{
		String s1 = s;
		try {
			s1 = new String(s.getBytes("UTF-8"),"ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s1;
	}
	public static String ISO8859_UTF8(String s)
	{
		String s1 = s;
		try {
			s1 = new String(s.getBytes(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s1;
	}
	
	public static void main(String args[])
	{
		System.out.println(CharsetUtil.ISO8859_UTF8("大家好"));
	}
}
