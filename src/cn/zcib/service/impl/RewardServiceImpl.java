package cn.zcib.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zcib.dao.BaseDao;
import cn.zcib.service.RewardService;

@Transactional(propagation=Propagation.REQUIRED)
public class RewardServiceImpl implements RewardService
{
	//通过spring注入
	@Resource private @Qualifier("baseDao") BaseDao baseDao;

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

}


