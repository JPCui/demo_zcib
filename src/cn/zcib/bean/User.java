package cn.zcib.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	@Id
	private char[] ID;
	private String Name;
	private String Password;
	private byte IsPermit;
	private String Department;
	private int Count;
	private String RoleName;
	private Date AddTime;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Date getAddTime() {
		return AddTime;
	}
	public void setAddTime(Date addTime) {
		AddTime = addTime;
	}
	public char[] getID() {
		return ID;
	}
	public void setID(char[] iD) {
		ID = iD;
	}
	public int getCount() {
		return Count;
	}
	public void setCount(int count) {
		Count = count;
	}
	public byte getIsPermit() {
		return IsPermit;
	}
	public void setIsPermit(byte isPermit) {
		IsPermit = isPermit;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getRoleName() {
		return RoleName;
	}
	public void setRoleName(String roleName) {
		RoleName = roleName;
	}
	
}
