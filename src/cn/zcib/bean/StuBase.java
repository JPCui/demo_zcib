package cn.zcib.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 学生基本信息类，主类
 * @notice 在保存的时候必须由副类进行
 * @author REAL
 */
@Entity
@Table(name="StuBaseInfo")
public class StuBase {
	@Id
	@Column
	private char[] Number;
	@Column
	private String Password;
	private String Name;
	@Column
	private char[] Sex;
	private String Enrolment;
	private char[] DepID;
	@Column(name="Class")
	private String Clazz;
	
	public char[] getNumber() {
		return Number;
	}
	public void setNumber(char[] number) {
		Number = number;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public char[] getSex() {
		return Sex;
	}
	public void setSex(char[] sex) {
		Sex = sex;
	}
	public String getEnrolment() {
		return Enrolment;
	}
	public void setEnrolment(String enrolment) {
		Enrolment = enrolment;
	}
	public String getClazz() {
		return Clazz;
	}
	public void setClazz(String clazz) {
		Clazz = clazz;
	}
	public char[] getDepID() {
		return DepID;
	}
	public void setDepID(char[] depID) {
		DepID = depID;
	}
}
