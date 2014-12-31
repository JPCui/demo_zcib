package cn.zcib.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Config")
public class Config {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	private String Education;
	private String EducationLevel;
	private String PunishRank;
	private String PunishRemark;
	private String RewardRank;
	private String RewardRemark;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getEducation() {
		return Education;
	}
	public void setEducation(String education) {
		Education = education;
	}
	public String getEducationLevel() {
		return EducationLevel;
	}
	public void setEducationLevel(String educationLevel) {
		EducationLevel = educationLevel;
	}
	public String getPunishRank() {
		return PunishRank;
	}
	public void setPunishRank(String punishRank) {
		PunishRank = punishRank;
	}
	public String getPunishRemark() {
		return PunishRemark;
	}
	public void setPunishRemark(String punishRemark) {
		PunishRemark = punishRemark;
	}
	public String getRewardRank() {
		return RewardRank;
	}
	public void setRewardRank(String rewardRank) {
		RewardRank = rewardRank;
	}
	public String getRewardRemark() {
		return RewardRemark;
	}
	public void setRewardRemark(String rewardRemark) {
		RewardRemark = rewardRemark;
	}
	
}
