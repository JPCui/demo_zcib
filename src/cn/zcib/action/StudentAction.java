package cn.zcib.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

import cn.zcib.bean.SocialRelation;
import cn.zcib.bean.StuBase;
import cn.zcib.bean.StuDetail;
import cn.zcib.service.StudentService;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class StudentAction extends ActionSupport
{
	@Resource private @Qualifier("studentService") StudentService studentService;

	private String verifyCode;
	private String message;
	
	private File PhotoInput;
	private String PhotoInputFileName;
	private String PhotoInputContentType;

	private String id;
	private String Number;
	private String pwd;
	private String Name;
	private String Sex;
	private String Enrolment;
	private String DepID;
	private String Clazz;
	
	private String Dormitory;
	private String Photo;
	private String EduLevel;
	private String PolStatus;
	private String Nation;
	
	private String Birthday;
	private String Native;
	private String IDCard;
	private String HomAddress;
	private String PosCode;
	
	private String Phone;
	private String Xszz;
	private String Kslb;
	private String Ydyy;
	private String Rxcj;

	private String Rxrq;
	private String Remark;

	//SocialRelation
	private String Age;
	private String Relation;
	private String Company;

	public void updatePhoto()
	{
		String msg = studentService.updatePhoto(PhotoInput, PhotoInputFileName, Number);
		ActionUtil.toWeb(msg);
	}
	
	public void addStu() throws Exception
	{
		if("".equals(Number.trim())||null==Number||"null".equals(Number.trim()))
		{
			ActionUtil.toWeb("学号不能为空");
			return;
		}
		try {
			StuBase sb = new StuBase();
			StuDetail sd = new StuDetail();
			
			sb.setClazz(Clazz);
			sb.setDepID(("".equals(DepID.trim())||null==DepID||"null"==DepID)?null:DepID.toCharArray());
			sb.setEnrolment(Enrolment);
			sb.setName(Name);
			sb.setNumber(Number.toCharArray());
			sb.setPassword("123");
			sb.setSex(Sex==null?null:Sex.toCharArray());

			try{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				sd.setBirthday( sdf.parse(Birthday.substring(0, 10)) );
			}catch (Exception e) {
				sd.setBirthday( new Date() );
			}
			sd.setDormitory(Dormitory==null?null:Dormitory.toCharArray());
			sd.setEducateLevel(EduLevel);
			sd.setHomeAddress(HomAddress);
			sd.setIDCard(IDCard);
			
			sd.setKslb(Kslb);
			sd.setNation(Nation);
			sd.setNative(Native);
			sd.setNumber(Number.toCharArray());
			sd.setPhone(Phone);
			
			sd.setPhoto(Photo);
			sd.setPoliticalStatus(PolStatus);
			sd.setPostalCode(PosCode==null?null:PosCode.toCharArray());
			sd.setRemark(Remark);
			try {
				sd.setRxcj( Float.parseFloat(Rxcj));
			} catch (Exception e) {
				sd.setRxcj( 0 );
			}
			
			sd.setRxnf(Rxrq==null?null:Rxrq.toCharArray());
			try {
				sd.setXszz(new Byte(Xszz));
			} catch (Exception e) {
				sd.setXszz(new Byte("0"));
			}
			sd.setYdyy(Ydyy);
		
			String status = studentService.addStu(sb,sd);
			ActionUtil.toWeb(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updateStu() throws Exception
	{
		if(Number==null)
		{
			System.out.println(Number);
			ActionUtil.toWeb("学号不能为空");
			return;
		}
		try {
			StuBase sb = new StuBase();
			StuDetail sd = new StuDetail();

			sb.setClazz(Clazz);
			sb.setDepID(("".equals(DepID.trim())||null==DepID||"null"==DepID)?null:DepID.toCharArray());
			sb.setEnrolment(Enrolment);
			sb.setName(Name);
			sb.setNumber(Number.toCharArray());
			sb.setPassword("123");
			sb.setSex(("".equals(Sex.trim())||null==Sex||"null"==Sex)?null:Sex.toCharArray());
			
			try{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				sd.setBirthday( sdf.parse(Birthday.substring(0, 10)) );
			}catch (Exception e) {
				sd.setBirthday( new Date() );
			}
			sd.setDormitory(Dormitory==null?null:Dormitory.toCharArray());
			sd.setEducateLevel(EduLevel);
			System.out.println("Home:"+HomAddress);
			sd.setHomeAddress(HomAddress);
			sd.setIDCard(IDCard);
			
			sd.setKslb(Kslb);
			sd.setNation(Nation);
			sd.setNative(Native);
			sd.setNumber(Number.toCharArray());
			sd.setPhone(Phone);
			
			sd.setPhoto(Photo);
			sd.setPoliticalStatus(PolStatus);
			sd.setPostalCode(PosCode.toCharArray());
			sd.setRemark(Remark);
			sd.setRxcj( Float.parseFloat(Rxcj));

			sd.setRxnf(Rxrq==null?null:Rxrq.toCharArray());
			try {
				sd.setXszz(new Byte(Xszz));
			} catch (Exception e) {
				sd.setXszz(new Byte("0"));
			}
			sd.setYdyy(Ydyy);
		
			String status = studentService.updateStu(sb,sd);
			ActionUtil.toWeb(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addRelation()
	{
		SocialRelation sr = new SocialRelation();
		sr.setAge(Integer.parseInt(Age));
		sr.setCompany(Company);
		sr.setName(Name);
		sr.setNumber(Number.toCharArray());
		sr.setPhone(Phone);
		sr.setPoliticalStatus(PolStatus);
		sr.setRelation(Relation);
		sr.setRemark(Remark);
		String status = studentService.addRelation(sr);
		ActionUtil.toWeb(status);
	}
	
	public void updateRelation()
	{
		SocialRelation sr = new SocialRelation();
		sr.setAge(Integer.parseInt(Age));
		sr.setCompany(Company);
		sr.setID(Integer.parseInt(id));
		sr.setName(Name);
		sr.setNumber(Number.toCharArray());
		sr.setPhone(Phone);
		sr.setPoliticalStatus(PolStatus);
		sr.setRelation(Relation);
		sr.setRemark(Remark);
		String status = studentService.updateRelation(sr);
		ActionUtil.toWeb(status);
	}
	
	public String delRelation()
	{
		SocialRelation sr = new SocialRelation();
		sr.setID(Integer.parseInt(id));
		return studentService.delRelation(sr);
	}
	
	public String getStuFull()
	{
		HashMap<String,String> clazzMap = studentService.getStuFull(id);
		List<SocialRelation> relationList = studentService.getRelation(id);
		ActionUtil.saveRequest(ActionUtil.BEAN, clazzMap);
		ActionUtil.saveRequest(ActionUtil.LIST, relationList);
		return ActionUtil.BEAN;
	}
	
	public String login()
	{
		if("".equals( id.trim() )){
			ActionUtil.saveRequest("ErrMsg","用户id为空");
			return ActionUtil.TOLOGIN;
		}else if("".equals( pwd.trim() )){
			ActionUtil.saveRequest("ErrMsg","密码为空");
			return ActionUtil.TOLOGIN;
		}else if("".equals( verifyCode.trim() )){
			ActionUtil.saveRequest("ErrMsg","验证码为空");
//			return ActionUtil.TOLOGIN;
		}
		
		//2，进行验证码的验证
		try {
			String serverCode = (String)ActionUtil.getBySession("SERVER_VERIFY_CODE");
			if(!serverCode.equals(verifyCode))
			{
				ActionUtil.saveRequest("ErrMsg", "验证码错误");
//				return ActionUtil.TOLOGIN;
			}
		} catch (NullPointerException e) {
			ActionUtil.saveRequest("ErrMsg", "验证码错误");
			return ActionUtil.TOLOGIN;
		}
		
		//3，通过事务层进行验证登录
		StuBase stu = (StuBase)studentService.login(id, pwd);
		if( stu == null)
		{
			ActionUtil.saveRequest("ErrMsg", "用户名或密码错误");
			return ActionUtil.FAIL;
		}

		ActionUtil.saveBySession("LoginId",new String(stu.getNumber()));
		ActionUtil.saveBySession("LoginName",stu.getName());
		ActionUtil.saveBySession("LoginPwd",stu.getPassword());
		ActionUtil.saveBySession("IsAdmin",0);
		
		return ActionUtil.SUCCESS;
	}
	
	public String getStusByClass() throws UnsupportedEncodingException
	{
//		String clazz = ActionUtil.getRequest().getParameter("Class");
		List<HashMap<String, String>> list = studentService.getStusByClass(Clazz);
		ActionUtil.saveRequest(ActionUtil.LIST, list);
		return ActionUtil.LIST;
	}
	
	public void delStu()
	{
		String status = studentService.delStu(Number);
		ActionUtil.toWeb(status);
	}
	
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getIDCard() {
		return IDCard;
	}

	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}

	public String getNation() {
		return Nation;
	}

	public void setNation(String nation) {
		Nation = nation;
	}

	public String getPolStatus() {
		return PolStatus;
	}

	public String getYdyy() {
		return Ydyy;
	}

	public void setYdyy(String ydyy) {
		Ydyy = ydyy;
	}

	public void setPolStatus(String polStatus) {
		PolStatus = polStatus;
	}

	public String getNative() {
		return Native;
	}

	public void setNative(String native1) {
		Native = native1;
	}

	public String getDormitory() {
		return Dormitory;
	}

	public void setDormitory(String dormitory) {
		Dormitory = dormitory;
	}

	public String getPosCode() {
		return PosCode;
	}

	public void setPosCode(String posCode) {
		PosCode = posCode;
	}

	public String getPhone() {
		return Phone;
	}

	public String getBirthday() {
		return Birthday;
	}

	public void setBirthday(String birthday) {
		Birthday = birthday;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getHomAddress() {
		return HomAddress;
	}

	public void setHomAddress(String homAddress) {
		HomAddress = homAddress;
	}

	public String getKslb() {
		return Kslb;
	}

	public void setKslb(String kslb) {
		Kslb = kslb;
	}

	public String getRxcj() {
		return Rxcj;
	}

	public void setRxcj(String rxcj) {
		Rxcj = rxcj;
	}

	public String getRxrq() {
		return Rxrq;
	}

	public void setRxrq(String rxrq) {
		Rxrq = rxrq;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	public String getEduLevel() {
		return EduLevel;
	}

	public void setEduLevel(String eduLevel) {
		EduLevel = eduLevel;
	}
	
	public String getEnrolment() {
		return Enrolment;
	}

	public void setEnrolment(String enrolment) {
		Enrolment = enrolment;
	}

	public String getDepID() {
		return DepID;
	}

	public void setDepID(String depID) {
		DepID = depID;
	}

	public String getClazz() {
		return Clazz;
	}

	public void setClazz(String clazz) {
		Clazz = clazz;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}

	public String getRelation() {
		return Relation;
	}

	public void setRelation(String relation) {
		Relation = relation;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}
	public File getPhotoInput() {
		return PhotoInput;
	}

	public void setPhotoInput(File photoInput) {
		PhotoInput = photoInput;
	}

	public String getPhotoInputFileName() {
		return PhotoInputFileName;
	}

	public void setPhotoInputFileName(String photoInputFileName) {
		PhotoInputFileName = photoInputFileName;
	}

	public String getPhotoInputContentType() {
		return PhotoInputContentType;
	}

	public void setPhotoInputContentType(String photoInputContentType) {
		PhotoInputContentType = photoInputContentType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getXszz() {
		return Xszz;
	}

	public void setXszz(String xszz) {
		Xszz = xszz;
	}

}
