package cn.zcib.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Payment")
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private char[] Number;
	@Column(name="Class")
	private String Clazz;
	private char[] Session;
	private float Amount;
	private Date Time;
	private char[] State;
	private String Remark;
	public char[] getNumber() {
		return Number;
	}
	public void setNumber(char[] number) {
		Number = number;
	}
	public char[] getSession() {
		return Session;
	}
	public void setSession(char[] session) {
		Session = session;
	}
	public float getAmount() {
		return Amount;
	}
	public void setAmount(float amount) {
		Amount = amount;
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
	public char[] getState() {
		return State;
	}
	public void setState(char[] state) {
		State = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClazz() {
		return Clazz;
	}
	public void setClazz(String clazz) {
		Clazz = clazz;
	}
	
}
