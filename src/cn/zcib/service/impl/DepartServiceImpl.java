package cn.zcib.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zcib.bean.Department;
import cn.zcib.dao.BaseDao;
import cn.zcib.service.DepartService;

@Transactional(propagation=Propagation.REQUIRED)
public class DepartServiceImpl implements DepartService
{
	//通过spring注入
	@Resource private @Qualifier("baseDao") BaseDao baseDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getDepartments()
	{
		return baseDao.selectAll(Department.class);
	}

	@Override
	public String updateDepartment(Department department)
	{
		if(baseDao.update(department)==1)return "<font color='green' style='font-size:16px;'>更新成功</font>";
		return "<font color='red' style='font-size:16px;'>更新失败，请联系管理员</font>";
	}
	@Override
	public String delDepartment(Serializable id)
	{
		if(baseDao.delete(Department.class, id)==1)return "<font color='green' style='font-size:16px;'>删除成功</font>";
		return "<font color='red' style='font-size:16px;'>删除失败，请联系管理员</font>";
	}
	@Override
	public String addDepartment(Department department)
	{
		if(baseDao.insert(department)==1)return "<font color='green' style='font-size:16px;'>添加成功</font>";
		return "<font color='red' style='font-size:16px;'>添加失败，请联系管理员</font>";
	}
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

}


