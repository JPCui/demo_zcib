package cn.zcib.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

import cn.zcib.bean.ClassBean;
import cn.zcib.service.ClassService;

import com.opensymphony.xwork2.ActionSupport;

public class ClassAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	@Resource private @Qualifier("classService") ClassService classService;
	private Map<String,Object> jsonMap;
	private String ID;
	private String DeptID;
	private String Name;
	private String Assis;
	private String ClaAssis;
	private String Adv;
	private String Monitor;
	private String MajorID;
	private String status;
	
	public void addClass()
	{
		ClassBean clazz = new ClassBean();
		clazz.setAdviser(Adv);
		clazz.setAssistant(Assis);
		clazz.setClassAssistant(ClaAssis);
		clazz.setMajorID(MajorID.toCharArray());
		clazz.setMonitor(Monitor);
		clazz.setName(Name);
		status = classService.add(clazz);
		try {
			ActionUtil.toWeb(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update()
	{
		ClassBean clazz = new ClassBean();
		clazz.setID(Integer.parseInt(ID) );
		clazz.setAdviser(Adv);
		clazz.setAssistant(Assis);
		clazz.setClassAssistant(ClaAssis);
		clazz.setMajorID(MajorID.toCharArray());
		clazz.setMonitor(Monitor);
		clazz.setName(Name);
		ActionUtil.toWeb( classService.update(clazz) );
	}
	
	public void del()
	{
		ActionUtil.toWeb( classService.delete(ID) );
	}
	
	//获取班级详细信息
	public String getClassFull()
	{
		HashMap<String,String> clazzMap = classService.getClassFull(Name);
		ActionUtil.saveRequest(ActionUtil.BEAN, clazzMap);
		System.out.println(clazzMap.values());
		return ActionUtil.BEAN;
	}
    
	public String getFullClassByMajor()
	{
		List<HashMap<String, String>> list = classService.getFullClassByMajor(MajorID);
		ActionUtil.saveRequest(ActionUtil.LIST, list);
		return ActionUtil.LIST;
	}
	
	public String getClassByMajor()
	{
//		System.out.println(MajorNumber+"..."+ActionUtil.getRequest().getAttribute("MajorNumber"));
		jsonMap = classService.getClassByMajor(MajorID);
		return SUCCESS;
	}

	public ClassService getClassService() {
		return classService;
	}

	public void setClassService(ClassService classService) {
		this.classService = classService;
	}

	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}

	public String getMajorID() {
		return MajorID;
	}

	public void setMajorID(String majorID) {
		MajorID = majorID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDeptID() {
		return DeptID;
	}

	public void setDeptID(String deptID) {
		DeptID = deptID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	public String getMonitor() {
		return Monitor;
	}

	public void setMonitor(String monitor) {
		Monitor = monitor;
	}

	public String getAssis() {
		return Assis;
	}

	public void setAssis(String assis) {
		Assis = assis;
	}

	public String getAdv() {
		return Adv;
	}

	public void setAdv(String adv) {
		Adv = adv;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getClaAssis() {
		return ClaAssis;
	}

	public void setClaAssis(String claAssis) {
		ClaAssis = claAssis;
	}

}
