package cn.zcib.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.zcib.bean.ClassBean;

/**
 * @author REAL
 * @param <T>
 */
public interface ClassService{

//	Object getPage(int currentPage, int pageSize);

	Map<String, Object> getClassByMajor(String MajorNumber);

	List<HashMap<String, String>> getFullClassByMajor(String majorID);

	HashMap<String, String> getClassFull(String ClassID);

	String update(ClassBean object);

	String delete(String id);

	String add(ClassBean object);

	List<ClassBean> getClassByDept(String depart);

	List<ClassBean> getClassByAssis(String assistant);

}