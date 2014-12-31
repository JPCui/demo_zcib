package cn.zcib.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

import cn.zcib.service.ConfigService;

import com.opensymphony.xwork2.ActionSupport;

public class ConfigAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	@Resource private @Qualifier("configService") ConfigService configService;
	
	private Map<String, Object> jsonMap;
	private String Msg;
	
	public String getAllConfig()
	{
		ActionUtil.saveRequest(ActionUtil.LIST, configService.getAllConfig());
		return ActionUtil.LIST;
	}
	
	public String getAllConfigJson()
	{
		List<Map<String, Object>> li = configService.getAllConfigJson();
		jsonMap = new HashMap<String, Object>();
		jsonMap.put(ActionUtil.JSONMAP, li);
		return SUCCESS;
	}
	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}

	public String getMsg() {
		try {
			Msg = URLDecoder.decode(Msg, "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			Msg = "";
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		return Msg;
	}

	public void setMsg(String msg) {
		try {
			Msg = URLEncoder.encode(msg, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ConfigService getConfigService() {
		return configService;
	}

	public void setConfigService(ConfigService configService) {
		this.configService = configService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
