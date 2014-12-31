package cn.zcib.action;

import java.io.IOException;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class ActionUtil{
	public static String SUCCESS = "success";
	public static String FAIL = "fail";
	public static String INPUT = "input";
	public static String TOLOGIN = "tologin";
	public static String LIST = "list";
	public static String RELIST = "relist";
	public static String BEAN = "bean";
	public static String MAP = "map";
	public static String JSONMAP = "jsonMap";
	public static String _404 = "404";
	
	public static void toWeb(String msg)
	{
		ServletActionContext.getResponse().setContentType("text/plain;charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter().write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 保存信息到request
	 * @param user
	 * @return 
	 */
	//保存用户信息到request
	public static int saveRequest(String key, Object value)
	{
		ServletActionContext.getRequest().setAttribute(key, value);
		return 1;
	}
	public static Object getRequest(String key)
	{
		return ServletActionContext.getRequest().getAttribute(key);
	}
	/**
	 * 保存信息到session
	 * @param user
	 * @return 
	 */
	public static void saveBySession(String key, Object obj)
	{
		Map<String,Object> session = ActionContext.getContext().getSession();
		session.put(key, obj);
	}

	public static Object getBySession(String key) {
		Map<String,Object> session = ActionContext.getContext().getSession();
		return session.get(key);
	}
}
