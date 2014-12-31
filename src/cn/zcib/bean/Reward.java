package cn.zcib.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Reward")
public class Reward {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	@Column(length=13)
	private char[] Number;
	private String Name;
	private String Department;
	@Column(length=13)
	private char[] Rank;
	@Column(columnDefinition = "varchar(20) DEFAULT '' COMMENT '奖励名称'")
	private String Prize;
	@Column(columnDefinition = "datetime DEFAULT NULL COMMENT '奖励时间'")
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
	public char[] getRank() {
		return Rank;
	}
	public void setRank(char[] rank) {
		Rank = rank;
	}
	public String getPrize() {
		return Prize;
	}
	public void setPrize(String prize) {
		Prize = prize;
	}
	public Date getTime() {
		return Time;
	}
	public void setTime(Date time) {
		Time = time;
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
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	
}
