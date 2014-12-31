package cn.zcib.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Department")
public class Department {
	@Id
	private char[] ID;
	private char[] Name;
	private String Header;
	private String ViceHeader;
	private String PartySecretary;
	
	public Department(char[] ID,char[] Name)
	{
		this.ID = ID;
		this.Name = Name;
	}
	public Department(){}
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
	public String getHeader() {
		return Header;
	}
	public void setHeader(String header) {
		Header = header;
	}
	public String getViceHeader() {
		return ViceHeader;
	}
	public void setViceHeader(String viceHeader) {
		ViceHeader = viceHeader;
	}
	public String getPartySecretary() {
		return PartySecretary;
	}
	public void setPartySecretary(String partySecretary) {
		PartySecretary = partySecretary;
	}
	
}
