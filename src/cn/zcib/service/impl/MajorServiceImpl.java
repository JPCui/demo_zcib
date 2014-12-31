package cn.zcib.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zcib.bean.Major;
import cn.zcib.dao.BaseDao;
import cn.zcib.service.MajorService;

@Transactional(propagation=Propagation.REQUIRED)
public class MajorServiceImpl implements MajorService
{
	//通过spring注入
	@Resource private @Qualifier("baseDao") BaseDao baseDao;

	@Override
	public String updateMajor(Major major)
	{
		if(baseDao.update(major)==1)return "<font color='green' style='font-size:16px;'>更新成功</font>";
		return "<font color='red' style='font-size:16px;'>更新失败，请联系管理员</font>";
	}
	@Override
	public String delMajor(Serializable id)
	{
		if(baseDao.delete(Major.class, id)==1)return "<font color='green' style='font-size:16px;'>删除成功</font>";
		return "<font color='red' style='font-size:16px;'>删除失败，请联系管理员</font>";
	}
	@Override
	public String addMajor(Major major)
	{
		if(baseDao.insert(major)==1)return "<font color='green' style='font-size:16px;'>添加成功</font>";
		return "<font color='red' style='font-size:16px;'>添加失败，请联系管理员</font>";
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Map<String,Object>> getMajorByDept(String DepID)
	{
		ArrayList<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>();
		String sql = "select ma.ID,ifnull(ma.Name,''),ma.Campus,ma.Education,ma.Tuition,ifnull(de.Name,'') " +
				"from Major ma,Department de " +
				"where ma.DepID='" + DepID + "' and ma.DepID=de.ID";
		List<Object[]>list = baseDao.querySql(sql);
		for(int i=0; i<list.size(); i++)
		{
			Map<String,Object> map = new HashMap<String, Object>();
			Object[] objs = list.get(i);
			int j = 0;
			map.put("ID", (String)objs[j++]);
			map.put("Name", (String)objs[j++]);
			map.put("Campus", objs[j++]+"");
			map.put("Education", (String)objs[j++]);
			map.put("Tuition", objs[j++].toString());
			map.put("Depart", (String)objs[j++]);
			listMap.add(map);
		}
		return listMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Map<String, Object>> getMajorByCampus(String Campus)
	{
		ArrayList<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>();
		String sql = "select ma.ID,ifnull(ma.Name,''),ma.Campus,ma.Education,ma.Tuition,ifnull(de.Name,'') " +
				"from Major ma,Department de " +
				"where ma.Campus='" + Campus + "' and ma.DepID=de.ID";
		List<Object[]>list = baseDao.querySql(sql);
		for(int i=0; i<list.size(); i++)
		{
			Map<String,Object> map = new HashMap<String, Object>();
			Object[] objs = list.get(i);
			int j = 0;
			map.put("ID", (String)objs[j++]);
			map.put("Name", (String)objs[j++]);
			map.put("Campus", objs[j++]+"");
			map.put("Education", (String)objs[j++]);
			map.put("Tuition", objs[j++].toString());
			map.put("Depart", (String)objs[j++]);
			listMap.add(map);
		}
		return listMap;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Major> getMajorJsonByDept(String DepID)
	{
		return baseDao.queryHql("from Major where DepID='"+DepID+"'");
	}
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

}


