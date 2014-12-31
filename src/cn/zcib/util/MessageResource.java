package cn.zcib.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageResource {

	public static String getZH_CN(String key)
	{
		Locale locale = new Locale("zh", "CN");
		ResourceBundle rb = ResourceBundle.getBundle("messageResource", locale);
		return rb.getString(key);
	}
	
}
