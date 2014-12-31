package cn.zcib.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Punish")
public class Punish {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	private char[] Number;
	private String Name;
	private String Department;
	private char[] Rank;
	private String PunishName;
	private Date Time;
	private int CheckState;
	private String Reason;
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
	public char[] getRank() {
		return Rank;
	}
	public void setRank(char[] rank) {
		Rank = rank;
	}
	public Date getTime() {
		return Time;
	}
	public void setTime(Date time) {
		Time = time;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getPunishName() {
		return PunishName;
	}
	public void setPunishName(String punishName) {
		PunishName = punishName;
	}
	public int getCheckState() {
		return CheckState;
	}
	public void setCheckState(int checkState) {
		CheckState = checkState;
	}
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
}
