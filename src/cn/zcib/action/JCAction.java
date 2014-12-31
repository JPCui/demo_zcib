package cn.zcib.action;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

import cn.zcib.bean.Punish;
import cn.zcib.bean.Reward;
import cn.zcib.service.JCService;
import cn.zcib.service.StudentService;

import com.opensymphony.xwork2.ActionSupport;

public class JCAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	@Resource private @Qualifier("jcService") JCService jcService;
	@Resource private @Qualifier("studentService") StudentService studentService;

	private String ID;
	private String Sid;
	private String clazz;
	private String Rank;
	private String flag;
	private String Remark;
	private String Name;
	private String PunishName;
	private String Prize;
	private String Reason;
	private String Department;
	
	private int sort;
	
	public void checkCfForm()
	{
		ActionUtil.toWeb( studentService.checkSidIsDepart(Sid, Department) );
	}
	
	public void addJl()
	{
		Reward reward = new Reward();
		reward.setCheckState(Integer.parseInt(flag));
		reward.setDepartment(Department);
		reward.setName(Name);
		reward.setNumber(Sid.toCharArray());
		reward.setPrize(Prize);
		reward.setRank(Rank.toCharArray());
		reward.setReason(Reason);
		reward.setRemark(Remark);
		reward.setTime(new Date());
		ActionUtil.toWeb("添加成功");
	}
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public void addCf()
	{
		Punish punish = new Punish();
		try {
			punish.setCheckState(Integer.parseInt(flag));
		} catch (Exception e) {
			punish.setCheckState(-1);
		}
		punish.setDepartment(Department);
		punish.setName(Name);
		punish.setNumber(Sid.toCharArray());
		punish.setPunishName(PunishName);
		punish.setRank(Rank.toCharArray());
		punish.setReason(Reason);
		punish.setRemark(Remark);
		punish.setTime(new Date());
		ActionUtil.toWeb( jcService.addCf(punish) );
	}
	
	public void checkJL()
	{
		int f = -1;
		try {
			f = Integer.parseInt(flag);
		} catch (Exception e) {
		}
		if(jcService.checkJL(ID, f)==1)
		{
			ActionUtil.toWeb(ActionUtil.LIST);
			return;
		}
		ActionUtil.toWeb("更新失败，请联系管理员。。。");
	}
	
	public void checkCf()
	{
		int f = -1;
		try {
			f = Integer.parseInt(flag);
		} catch (Exception e) {
		}
		if(jcService.checkCf(ID, f)==1)
		{
			ActionUtil.toWeb(ActionUtil.LIST);
			return;
		}
		ActionUtil.toWeb("更新失败，请联系管理员。。。");
	}
	
	public String getJlsBySid()
	{
		//如果是学生，直接从session中获取Sid
		if(Integer.parseInt(ActionUtil.getBySession("IsAdmin").toString()) == 0)
			Sid = (String) ActionUtil.getBySession("LoginId");
		ActionUtil.saveRequest(ActionUtil.LIST,  jcService.getJlsBySid(Sid) );
		return ActionUtil.LIST;
	}
	public String getCfsBySid()
	{
		if(Integer.parseInt( ActionUtil.getBySession("IsAdmin").toString()) == 0)
			Sid = (String) ActionUtil.getBySession("LoginId");
		ActionUtil.saveRequest(ActionUtil.LIST,  jcService.getCfsBySid(Sid) );
		return ActionUtil.LIST;
	}
	
	public String getJlsByClass()
	{
		ActionUtil.saveRequest(ActionUtil.LIST, jcService.getJlsByClass(clazz,sort));
		return ActionUtil.LIST;
	}
	
	public String getJl()
	{
		ActionUtil.saveRequest(ActionUtil.BEAN, jcService.getJlByID(ID));
		return ActionUtil.BEAN;
	}
	
	public String getCf()
	{
		ActionUtil.saveRequest(ActionUtil.BEAN, jcService.getCfByID(ID));
		return ActionUtil.BEAN;
	}
	
	public String getCfsByClass()
	{
		ActionUtil.saveRequest(ActionUtil.LIST, jcService.getCfsByClass(clazz,sort));
		return ActionUtil.LIST;
	}

	public JCService getJcService() {
		return jcService;
	}

	public void setJcService(JCService jcService) {
		this.jcService = jcService;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getRank() {
		return Rank;
	}

	public void setRank(String rank) {
		Rank = rank;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	public String getSid() {
		return Sid;
	}

	public void setSid(String sid) {
		Sid = sid;
	}

	public String getPunishName() {
		return PunishName;
	}

	public void setPunishName(String punishName) {
		PunishName = punishName;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPrize() {
		return Prize;
	}

	public void setPrize(String prize) {
		Prize = prize;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}

}
