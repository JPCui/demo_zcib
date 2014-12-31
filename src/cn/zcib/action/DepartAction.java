package cn.zcib.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

import cn.zcib.bean.Department;
import cn.zcib.service.DepartService;

import com.opensymphony.xwork2.ActionSupport;

public class DepartAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	@Resource private @Qualifier("departService") DepartService departService;
	
	private Map<String, Object> jsonMap;
	private String Msg;
	
	private String ID;
	private String Name;
	private String Header;
	private String ViceHeader;
	private String PartySecretary;
	
	public String add()
	{
		Department de = new Department();
		de.setHeader(Header);
		de.setID(ID.toCharArray());
		de.setName(Name.toCharArray());
		de.setPartySecretary(PartySecretary);
		de.setViceHeader(ViceHeader);
		Msg = departService.addDepartment(de);
		ActionUtil.saveRequest("Msg", Msg);
		return ActionUtil.LIST;
	}
	
	public String update()
	{
		Department de = new Department();
		de.setHeader(Header);
		de.setID(ID.toCharArray());
		de.setName(Name.toCharArray());
		de.setPartySecretary(PartySecretary);
		de.setViceHeader(ViceHeader);
		Msg = departService.updateDepartment(de);
		ActionUtil.saveRequest("Msg", getMsg());
		return ActionUtil.LIST;
	}
	
	public String delete()
	{
		Msg = departService.delDepartment(ID.toCharArray());
		ActionUtil.saveRequest("Msg", Msg);
		return ActionUtil.LIST;
	}

	public String getAllDeparts()
	{
		List<Department> list = departService.getDepartments();
		ActionUtil.saveRequest(ActionUtil.LIST, list);
		ActionUtil.saveRequest("Sum", list.size());
		ActionUtil.saveRequest("Msg", Msg);
		return ActionUtil.LIST;
	}
	
	public String getAllDepartsJson()
	{
		List<Department> list = departService.getDepartments();
		List<Map<String,Object>>li = new ArrayList<Map<String,Object>>();
		for (int i=0; i<list.size(); i++) {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("ID", new String(list.get(i).getID()));
			map.put("Name", new String(list.get(i).getName()));
			li.add(map);
		}
		jsonMap = new HashMap<String, Object>();
		jsonMap.put("jsonMap", li);
		return SUCCESS;
	}
	
	public DepartService getDepartService() {
		return departService;
	}

	public void setDepartService(DepartService departService) {
		this.departService = departService;
	}

	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getHeader() {
		return Header;
	}

	public void setHeader(String header) {
		Header = header;
	}

	public String getPartySecretary() {
		return PartySecretary;
	}

	public void setPartySecretary(String partySecretary) {
		PartySecretary = partySecretary;
	}

	public String getViceHeader() {
		return ViceHeader;
	}

	public void setViceHeader(String viceHeader) {
		ViceHeader = viceHeader;
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
	
}
