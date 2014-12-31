package cn.zcib.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zcib.bean.ClassBean;
import cn.zcib.dao.BaseDao;
import cn.zcib.service.ClassService;

@SuppressWarnings("unchecked")
@Transactional(propagation=Propagation.REQUIRED)
public class ClassServiceImpl implements ClassService
{
	//通过spring注入
	@Resource
	private @Qualifier("baseDao") BaseDao baseDao;

	@Override
	public HashMap<String, String> getClassFull(String Name)
	{
		List<Object[]> list = baseDao.querySql("select " +
				"cl.ID,cl.Name,cl.Assistant,cl.ClassAssistant,cl.Adviser,cl.Monitor," +
				"ifnull(de.ID,''),ifnull(ma.ID,'')," +
				"ifnull(de.Name,''),ifnull(ma.Name,'') " +
				"from Class as cl,Major as ma,Department as de " +
				"where cl.Name='"+Name+"' and cl.MajorID=ma.ID and ma.DepID=de.ID");
		HashMap<String, String> map = new HashMap<String, String>();
		
		Object[] obj = list.get(0);
		int j = 0;
		map.put("ID", obj[j]==null?null:obj[j++].toString());
		map.put("Name", (String) obj[j++]);
		map.put("Assistant", (String) obj[j++]);
		map.put("ClaAssis", (String) obj[j++]);
		map.put("Adviser", (String) obj[j++]);
		
		map.put("Monitor", (String) obj[j++]);
		map.put("DepartID", (String) obj[j++]);
		map.put("MajorID", (String) obj[j++]);
		map.put("Depart", (String) obj[j++]);
		map.put("Major", (String) obj[j++]);
		
		return map;
	}
	
	@Override
	public Map<String,Object> getClassByMajor(String MajorID)
	{
		Map<String,Object> jsonMap = new HashMap<String, Object>();
		List<ClassBean>list = baseDao.queryHql("from ClassBean where MajorID='"+MajorID+"'");
		List<Map<String,Object>>li = new ArrayList<Map<String,Object>>();
		for (int i=0; i<list.size(); i++) {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("Name", list.get(i).getName());
			li.add(map);
		}
		jsonMap = new HashMap<String, Object>();
		jsonMap.put("jsonMap", li);
		return jsonMap;
	}
	
	@Override
	public List<ClassBean> getClassByDept(String depart)
	{
		String hql = "select cl from ClassBean as cl, Major as ma, Department as de " +
				"where cl.MajorID=ma.ID and ma.DepID=de.ID and de.Name='"+depart+"'";
		return baseDao.queryHql(hql);
	}
	
	@Override
	public List<ClassBean> getClassByAssis(String assistant)
	{
		String hql = "from ClassBean as cl where cl.Assistant='"+assistant+"'";
		return baseDao.queryHql(hql);
	}
	
	@Override
	public List<HashMap<String, String>> getFullClassByMajor(String majorID) {
		List<HashMap<String, String>> mapList = new ArrayList<HashMap<String, String>>();
		List<Object[]> list = baseDao.querySql("select " +
				"cl.Name,cl.Assistant,cl.ClassAssistant,cl.Adviser,cl.Monitor " +
				"from Class as cl " +
				"where MajorID='"+majorID+"'");
		
		for(int i=0; i<list.size(); i++){
			HashMap<String, String> map = new HashMap<String, String>();
			Object[] obj = list.get(i);
			int j = 0;
			map.put("Name", (String) obj[j++]);
			map.put("Assistant", (String) obj[j++]);
			map.put("ClaAssis", (String) obj[j++]);
			map.put("Adviser", (String) obj[j++]);
			map.put("Monitor", (String) obj[j++]);
			mapList.add(map);
		}
		return mapList;
	}

	@Override
	public String add(ClassBean object) {
		baseDao.insert(object);
		return "添加成功";
	}
	
	@Override
	public String delete(String id) {
		try {
			if(baseDao.delete(ClassBean.class, Integer.parseInt(id))==1)
				return "删除成功";
		} catch (NumberFormatException e) {
			//格式转换错误
			return "ID格式转换异常："+id;
		}
		return "删除失败，内部错误请联系管理员";
	}

	@Override
	public String update(ClassBean object) {
		try {
			int res = baseDao.update(object);
			if(res > 0)
				return "更新成功";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "更新失败";
	}

	/*
	@Override
	public PageBean<ClassBean> getPage(int currentPage, int pageSize) {
		int allRow = baseDao.getAllRowCount(ClassBean.class.getSimpleName());//总行数
		int totalPage = PageBean.countTotalPage(pageSize, allRow);//总页数
		List<ClassBean>list = (List<ClassBean>) baseDao.getPage(ClassBean.class.getSimpleName(),currentPage, pageSize);
		PageBean<ClassBean> pageBean = new PageBean<ClassBean>();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}*/

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

}


