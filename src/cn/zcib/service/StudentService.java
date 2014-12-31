package cn.zcib.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import cn.zcib.bean.SocialRelation;
import cn.zcib.bean.StuBase;
import cn.zcib.bean.StuDetail;


/**
 * @author REAL
 * @param <T>
 */
public interface StudentService{

	StuBase login(String id, String pwd);

	List<HashMap<String, String>> getStusByClass(String clazz);

	HashMap<String, String> getStuFull(String id);

	String updateStu(StuBase sb,StuDetail sd);
	
	List<SocialRelation> getRelation(String id);

	String updateRelation(SocialRelation sr);
	
	String delRelation(SocialRelation sr);

	String updatePhoto(File file, String fileName, String Number);

	String addStu(StuBase sb, StuDetail sd);

	String delStu(String Number);

	String addRelation(SocialRelation sr);

	String checkSidIsDepart(String Sid, String Depart);
}