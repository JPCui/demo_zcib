package cn.zcib.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Major")
public class Major {
	@Id
	private char[] ID;
	private char[] Name;
	private byte Campus;
	private char Education;
	private float Tuition;
	private char[] DepID;

	public Major()
	{}
	public Major(char[] ID,char[] Name)
	{
		this.ID = ID;
		this.Name = Name;
	}
	public char[] getID() {
		return ID;
	}
	public void setID(char[] iD) {
		ID = iD;
	}
	public char[] getName() {
		return Name;
	}
	public void setName(char[] name) {
		Name = name;
	}
	public byte getCampus() {
		return Campus;
	}
	public void setCampus(byte campus) {
		Campus = campus;
	}
	public char getEducation() {
		return Education;
	}
	public void setEducation(char education) {
		Education = education;
	}
	public float getTuition() {
		return Tuition;
	}
	public void setTuition(float tuition) {
		Tuition = tuition;
	}
	public char[] getDepID() {
		return DepID;
	}
	public void setDepID(char[] depID) {
		DepID = depID;
	}
	
}
