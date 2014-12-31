package cn.zcib.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zcib.bean.Role;
import cn.zcib.dao.BaseDao;
import cn.zcib.service.RoleService;

@Transactional(propagation=Propagation.REQUIRED)
public class RoleServiceImpl implements RoleService
{
	//通过spring注入
	@Resource private @Qualifier("baseDao") BaseDao baseDao;
	
	@Override
	public Role getRoleByName(String Name)
	{
		return (Role)baseDao.selectByX(Role.class, "Name='" + Name + "'");
	}

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

}


