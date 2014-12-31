package cn.zcib.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Role")
public class Role {
	@Id
	private int ID;
	private String Name;
	private byte HaveAdd;
	private byte HaveUpdate;
	private byte HaveDelete;
	private byte HaveQuery;
	private byte HaveImport;
	private byte HaveExport;
	private byte HaveClassMgr;
	private byte HaveCheckR;//奖励审核
	private byte HaveCheckP;//处罚审核
	private byte DataProcMgr;
	private byte AuthorityMgr;
	private byte DepMgr;
	private byte MajorMgr;
	private byte ClassMgr;
	private byte RewardMgr;
	private byte ArchiveMgr;
	private byte PaymentMgr;
	private byte MaintenanceMgr;
	private String Remark;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public byte getHaveAdd() {
		return HaveAdd;
	}
	public void setHaveAdd(byte haveAdd) {
		HaveAdd = haveAdd;
	}
	public byte getHaveUpdate() {
		return HaveUpdate;
	}
	public void setHaveUpdate(byte haveUpdate) {
		HaveUpdate = haveUpdate;
	}
	public byte getHaveDelete() {
		return HaveDelete;
	}
	public void setHaveDelete(byte haveDelete) {
		HaveDelete = haveDelete;
	}
	public byte getHaveQuery() {
		return HaveQuery;
	}
	public void setHaveQuery(byte haveQuery) {
		HaveQuery = haveQuery;
	}
	public byte getHaveImport() {
		return HaveImport;
	}
	public void setHaveImport(byte haveImport) {
		HaveImport = haveImport;
	}
	public byte getHaveExport() {
		return HaveExport;
	}
	public void setHaveExport(byte haveExport) {
		HaveExport = haveExport;
	}
	public byte getHaveClassMgr() {
		return HaveClassMgr;
	}
	public void setHaveClassMgr(byte haveClassMgr) {
		HaveClassMgr = haveClassMgr;
	}
	public byte getHaveCheckR() {
		return HaveCheckR;
	}
	public void setHaveCheckR(byte haveCheckR) {
		HaveCheckR = haveCheckR;
	}
	public byte getHaveCheckP() {
		return HaveCheckP;
	}
	public void setHaveCheckP(byte haveCheckP) {
		HaveCheckP = haveCheckP;
	}
	public byte getDataProcMgr() {
		return DataProcMgr;
	}
	public void setDataProcMgr(byte dataProcMgr) {
		DataProcMgr = dataProcMgr;
	}
	public byte getAuthorityMgr() {
		return AuthorityMgr;
	}
	public void setAuthorityMgr(byte authorityMgr) {
		AuthorityMgr = authorityMgr;
	}
	public byte getDepMgr() {
		return DepMgr;
	}
	public void setDepMgr(byte depMgr) {
		DepMgr = depMgr;
	}
	public byte getMajorMgr() {
		return MajorMgr;
	}
	public void setMajorMgr(byte majorMgr) {
		MajorMgr = majorMgr;
	}
	public byte getClassMgr() {
		return ClassMgr;
	}
	public void setClassMgr(byte classMgr) {
		ClassMgr = classMgr;
	}
	public byte getRewardMgr() {
		return RewardMgr;
	}
	public void setRewardMgr(byte rewardMgr) {
		RewardMgr = rewardMgr;
	}
	public byte getArchiveMgr() {
		return ArchiveMgr;
	}
	public void setArchiveMgr(byte archiveMgr) {
		ArchiveMgr = archiveMgr;
	}
	public byte getPaymentMgr() {
		return PaymentMgr;
	}
	public void setPaymentMgr(byte paymentMgr) {
		PaymentMgr = paymentMgr;
	}
	public byte getMaintenanceMgr() {
		return MaintenanceMgr;
	}
	public void setMaintenanceMgr(byte maintenanceMgr) {
		MaintenanceMgr = maintenanceMgr;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
}
