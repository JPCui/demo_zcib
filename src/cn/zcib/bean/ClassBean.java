package cn.zcib.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Class")
public class ClassBean{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	private String Name;
	private String Assistant;
	private String Adviser;
	private String Monitor;
	private char[] MajorID;
	private String ClassAssistant;
	
	public ClassBean(){}
	public ClassBean(String Name)
	{
		this.Name = Name;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAssistant() {
		return Assistant;
	}
	public void setAssistant(String assistant) {
		Assistant = assistant;
	}
	public String getAdviser() {
		return Adviser;
	}
	public void setAdviser(String adviser) {
		Adviser = adviser;
	}
	public String getClassAssistant() {
		return ClassAssistant;
	}
	public void setClassAssistant(String classAssistant) {
		ClassAssistant = classAssistant;
	}
	public String getMonitor() {
		return Monitor;
	}
	public void setMonitor(String monitor) {
		Monitor = monitor;
	}
	public char[] getMajorID() {
		return MajorID;
	}
	public void setMajorID(char[] majorID) {
		MajorID = majorID;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
}
