package cn.zcib.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zcib.bean.Punish;
import cn.zcib.bean.Reward;
import cn.zcib.dao.BaseDao;
import cn.zcib.service.JCService;

@Transactional(propagation=Propagation.REQUIRED)
public class JCServiceImpl implements JCService
{
	//通过spring注入
	@Resource private @Qualifier("baseDao") BaseDao baseDao;
	
	@Override
	public String addCf(Punish punish)
	{
		if(baseDao.insert(punish)==1)return "添加成功";
		else return "添加失败";
	}
	@Override
	public String addJl(Reward reward)
	{
		if(baseDao.insert(reward)==1)return "添加成功";
		else return "添加失败";
	}
	
	@Override
	public int checkJL(String ID,int flag)
	{
		baseDao.exeSql("update Reward set CheckState="+flag+" where ID="+ID);
		return 1;
	}
	
	@Override
	public int checkCf(String ID,int flag)
	{
		baseDao.exeSql("update Punish set CheckState="+flag+" where ID="+ID);
		return 1;
	}
	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, String> getJlByID(String ID){
		String sql = "select " +
				"re.ID,re.Number,sb.Name,re.Rank,re.Prize,re.Time,re.CheckState,re.Reason,re.Remark " +
				"from Reward as re,Class as cl,StuBaseInfo as sb " +
				"where re.Number=sb.Number and sb.Class=cl.Name and re.ID="+ID;
		List<Object[]> list = baseDao.querySql(sql);
		HashMap<String, String> map = new HashMap<String, String>();
		Object[] obj = list.get(0);
		if(list.size() > 0)
		{
			int j = 0;
			map.put("ID", obj[j++]+"");
			map.put("sid", obj[j++]+"");	map.put("name", obj[j++]+"");
			map.put("rank", obj[j++]+"");	map.put("title",obj[j++]+"");
			map.put("time",  obj[j++]+"");	map.put("flag",obj[j++]+"");
			map.put("reason",  obj[j++]+"");map.put("remark",obj[j++]+"");
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reward> getJlsBySid(String Sid)
	{
		String hql = "from Reward where Number='" + Sid + "'";
		return baseDao.queryHql(hql);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Punish> getCfsBySid(String Sid)
	{
		String hql = "from Punish where Number='" + Sid + "'";
		return baseDao.queryHql(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HashMap<String, String>> getJlsByClass(String clazz,int sort) {
		String sql = "select " +
				"re.ID,re.Number,sb.Name,re.Rank,re.Prize,re.Time,re.CheckState,re.Reason,re.Remark " +
				"from Reward as re,Class as cl,StuBaseInfo as sb " +
				"where re.Number=sb.Number and sb.Class=cl.Name and cl.Name='"+clazz+"' ";
		if(2 == sort){
			sql += " and re.CheckState=-1";
		}
		else if(3 == sort){
			sql += " and re.CheckState=1";
		}
		else if(4 == sort){
			sql += " and re.CheckState=0";
		}
		else{
			sql += " order by Number ASC";
		}
		List<Object[]> list = baseDao.querySql(sql);
		List<HashMap<String, String>> mapList = new ArrayList<HashMap<String, String>>();
		for(int i=0; i<list.size(); i++){
			HashMap<String, String> map = new HashMap<String, String>();
			Object[] obj = list.get(i);
			int j = 0;
			map.put("ID", obj[j++]+"");
			map.put("sid", obj[j++]+"");	map.put("name", obj[j++]+"");
			map.put("rank", obj[j++]+"");	map.put("title",obj[j++]+"");
			map.put("time",  obj[j++]+"");	map.put("flag",obj[j++]+"");
			map.put("reason",  obj[j++]+"");map.put("remark",obj[j++]+"");
			mapList.add(map);
		}
		return mapList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, String> getCfByID(String ID){
		String sql = "select " +
				"pu.ID,pu.Number,sb.Name,pu.Rank,pu.PunishName,pu.Time,pu.CheckState,pu.Remark,pu.Reason " +
				"from Punish as pu,StuBaseInfo as sb " +
				"where pu.Number=sb.Number and pu.ID="+ID;
		List<Object[]> list = baseDao.querySql(sql);
		HashMap<String, String> map = new HashMap<String, String>();
		if(list.size()>0)
		{
			Object[] obj = list.get(0);
			if(list.size() > 0)
			{
				int j = 0;
				map.put("ID", obj[j++]+"");
				map.put("sid", obj[j++]+"");	map.put("name", obj[j++]+"");
				map.put("rank", obj[j++]+"");	map.put("title",obj[j++]+"");
				map.put("time",  obj[j++]+"");	map.put("flag",obj[j++]+"");
				map.put("remark",obj[j++]+"");	map.put("reason",obj[j++]+"");
			}
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HashMap<String, String>> getCfsByClass(String clazz,int sort) {
		String sql = "select " +
				"pu.ID,pu.Number,sb.Name,pu.Rank,pu.PunishName,pu.Time,pu.CheckState,pu.Remark " +
				"from Punish as pu,Class as cl,StuBaseInfo as sb " +
				"where pu.Number=sb.Number and sb.Class=cl.Name and cl.Name='"+clazz+"' ";
		if(sort == 2){
			sql += " and pu.IsEffect=1";
		}
		else if(sort == 3){
			sql += " and pu.IsEffect=0";
		}
		else{
			sql += " order by Number ASC";
		}
		List<Object[]> list = baseDao.querySql(sql);
		List<HashMap<String, String>> mapList = new ArrayList<HashMap<String, String>>();
		for(int i=0; i<list.size(); i++){
			HashMap<String, String> map = new HashMap<String, String>();
			Object[] obj = list.get(i);
			int j = 0;
			map.put("ID", obj[j++]+"");
			map.put("sid", obj[j++]+"");	map.put("name", obj[j++]+"");
			map.put("rank", obj[j++]+"");	map.put("title",obj[j++]+"");
			map.put("time",  obj[j++]+"");	map.put("flag",obj[j++]+"");
			map.put("remark",obj[j++]+"");
			mapList.add(map);
		}
		return mapList;
	}
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

}


