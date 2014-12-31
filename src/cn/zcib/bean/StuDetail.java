package cn.zcib.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 学生在校信息类，副类
 * @notice 在保存的时候必须由副类进行
 * @author REAL
 */
@Entity
@Table(name="StuDetailInfo")
public class StuDetail {
	@Id
	private char[] Number;
	private char[] Dormitory;
	private String Photo;
	private String EducateLevel;
	private String PoliticalStatus;
	private String Nation;
	private Date Birthday;
	private String Native;
	private String IDCard;
	private String HomeAddress;
	private char[] PostalCode;
	private String Phone;
	private byte Xszz;
	private String Kslb;
	private String Ydyy;
	private float Rxcj;
	private char[] Rxnf;
	private String Remark;
	public char[] getNumber() {
		return Number;
	}
	public void setNumber(char[] number) {
		Number = number;
	}
	public char[] getDormitory() {
		return Dormitory;
	}
	public void setDormitory(char[] dormitory) {
		Dormitory = dormitory;
	}
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		Photo = photo;
	}
	public String getEducateLevel() {
		return EducateLevel;
	}
	public void setEducateLevel(String educateLevel) {
		EducateLevel = educateLevel;
	}
	public String getPoliticalStatus() {
		return PoliticalStatus;
	}
	public void setPoliticalStatus(String politicalStatus) {
		PoliticalStatus = politicalStatus;
	}
	public String getNation() {
		return Nation;
	}
	public void setNation(String nation) {
		Nation = nation;
	}
	public Date getBirthday() {
		return Birthday;
	}
	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}
	public String getNative() {
		return Native;
	}
	public void setNative(String native1) {
		Native = native1;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	public String getHomeAddress() {
		return HomeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		HomeAddress = homeAddress;
	}
	public char[] getPostalCode() {
		return PostalCode;
	}
	public void setPostalCode(char[] postalCode) {
		PostalCode = postalCode;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public byte getXszz() {
		return Xszz;
	}
	public void setXszz(byte xszz) {
		Xszz = xszz;
	}
	public String getKslb() {
		return Kslb;
	}
	public void setKslb(String kslb) {
		Kslb = kslb;
	}
	public String getYdyy() {
		return Ydyy;
	}
	public void setYdyy(String ydyy) {
		Ydyy = ydyy;
	}
	public float getRxcj() {
		return Rxcj;
	}
	public void setRxcj(float rxcj) {
		Rxcj = rxcj;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public char[] getRxnf() {
		return Rxnf;
	}
	public void setRxnf(char[] rxnf) {
		Rxnf = rxnf;
	}
}
