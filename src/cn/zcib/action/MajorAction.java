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

import cn.zcib.bean.Major;
import cn.zcib.service.MajorService;

import com.opensymphony.xwork2.ActionSupport;

public class MajorAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	@Resource private @Qualifier("majorService") MajorService majorService;

	private Map<String, Object> jsonMap;
	private String Msg;
	
	private String Campus;
	private String DepID;
	private String Education;
	private String ID;
	private String Name;
	private String Tuition;

	public String add()
	{
		Major ma = new Major();
		try {
			ma.setCampus((byte) (Campus.getBytes()[0]-'0'));
			ma.setDepID(DepID.toCharArray());
			ma.setEducation(Education.charAt(0));
			ma.setID(ID.toCharArray());
			ma.setName(Name.toCharArray());
			ma.setTuition(Float.parseFloat(Tuition));
			Msg = majorService.addMajor(ma);
		} catch (NumberFormatException e) {
			Msg = "<font color='red'>学制、学费的格式错误或检查其它输入是否错误</font>";
		} catch (IndexOutOfBoundsException e) {
			Msg = "<font color='red'>学制不能为空，其它错误请联系管理员</font>";
		}
		ActionUtil.saveRequest("Msg", Msg);
		return ActionUtil.LIST;
	}
	
	public String update()
	{
		Major ma = new Major();
		try {
			ma.setCampus((byte) (Campus.getBytes()[0]-'0'));
			ma.setDepID(DepID.toCharArray());
			ma.setEducation(Education.charAt(0));
			ma.setID(ID.toCharArray());
			ma.setName(Name.toCharArray());
			ma.setTuition(Float.parseFloat(Tuition));
			Msg = majorService.updateMajor(ma);
		} catch (NumberFormatException e) {
			Msg = "<font color='red'>学制、学费的格式错误或检查其它输入是否错误</font>";
		}
		ActionUtil.saveRequest("Msg", Msg);
		return ActionUtil.LIST;
	}
	
	public String delete()
	{
		Msg = majorService.delMajor(ID.toCharArray());
		ActionUtil.saveRequest("Msg", Msg);
		return ActionUtil.LIST;
	}
	
	public String getMajorByDept()
	{
		List<Map<String, Object>> list = majorService.getMajorByDept(DepID);
		ActionUtil.saveRequest(ActionUtil.LIST, list);
		ActionUtil.saveRequest("Sum", list.size());
		return ActionUtil.LIST;
	}
	public String getMajorByCampus()
	{
		List<Map<String, Object>> list = majorService.getMajorByCampus(Campus);
		ActionUtil.saveRequest(ActionUtil.LIST, list);
		ActionUtil.saveRequest("Sum", list.size());
		return ActionUtil.LIST;
	}
	public String getMajorJsonByDept()
	{
		List<Major>list = majorService.getMajorJsonByDept(DepID);
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

	public MajorService getMajorService() {
		return majorService;
	}

	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}

	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}
	
	public String getDeptID() {
		return DepID;
	}
	
	public void setDeptID(String deptID) {
		DepID = deptID;
	}
	public String getMsg() {
		
		try {
			Msg = URLDecoder.decode(Msg, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			Msg = "";
		} catch (NullPointerException e) {
			Msg = "";
		}
		return Msg;
	}

	public void setMsg(String msg) {
		try {
			Msg = URLEncoder.encode(msg, "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
		}
	}

	public String getCampus() {
		return Campus;
	}

	public void setCampus(String campus) {
		Campus = campus;
	}

	public String getDepID() {
		return DepID;
	}

	public void setDepID(String depID) {
		DepID = depID;
	}

	public String getEducation() {
		return Education;
	}

	public void setEducation(String education) {
		Education = education;
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

	public String getTuition() {
		return Tuition;
	}

	public void setTuition(String tuition) {
		Tuition = tuition;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
