package cn.zcib.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.zcib.bean.Major;

/**
 * @author REAL
 * @param <T>
 */
public interface MajorService{

	List<Map<String, Object>> getMajorByDept(String Pertain);

	ArrayList<Map<String, Object>> getMajorByCampus(String Campus);

	String updateMajor(Major major);

	String delMajor(Serializable id);

	String addMajor(Major major);

	List<Major> getMajorJsonByDept(String DepID);

}