package cn.zcib.service;

import java.util.HashMap;
import java.util.List;

import cn.zcib.bean.Punish;
import cn.zcib.bean.Reward;

/**
 * @author REAL
 * @param <T>
 */
public interface JCService{
	
	public List<HashMap<String, String>> getJlsByClass(String clazz,int sort);
	public List<HashMap<String, String>> getCfsByClass(String clazz,int sort);
	int checkJL(String ID, int flag);
	HashMap<String, String> getCfByID(String ID);
	List<Punish> getCfsBySid(String Number);
	int checkCf(String ID, int flag);
	HashMap<String, String> getJlByID(String ID);
	List<Reward> getJlsBySid(String Sid);
	String addJl(Reward reward);
	String addCf(Punish punish);
	
}