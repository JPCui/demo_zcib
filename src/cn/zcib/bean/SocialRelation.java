package cn.zcib.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SocialRelation")
public class SocialRelation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	private char[] Number;
	private String Name;
	private String Relation;
	private int Age;
	private String PoliticalStatus;
	private String Company;
	private String Phone;
	private String Remark;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public char[] getNumber() {
		return Number;
	}
	public void setNumber(char[] number) {
		Number = number;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getRelation() {
		return Relation;
	}
	public void setRelation(String relation) {
		Relation = relation;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getPoliticalStatus() {
		return PoliticalStatus;
	}
	public void setPoliticalStatus(String politicalStatus) {
		PoliticalStatus = politicalStatus;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	
}
