package cn.zcib.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zcib.bean.Config;
import cn.zcib.dao.BaseDao;
import cn.zcib.service.ConfigService;

@Transactional(propagation=Propagation.REQUIRED)
public class ConfigServiceImpl implements ConfigService{

	@Resource
	private @Qualifier("baseDao") BaseDao baseDao;

	@SuppressWarnings("unchecked")
	@Override
	public List<Config> getAllConfig()
	{
		return baseDao.queryHql("from Config");
	}
	
	@Override
	public List<Map<String,Object>> getAllConfigJson()
	{
		List<Config> list = getAllConfig();
		List<Map<String,Object>>li = new ArrayList<Map<String,Object>>();
		for (int i=0; i<list.size(); i++) {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("ID", list.get(i).getID());
			map.put("Education", new String(list.get(i).getEducation()));
			map.put("EducationLevel", new String(list.get(i).getEducationLevel()));
			map.put("PunishRank", new String(list.get(i).getPunishRank()));
			map.put("PunishRemark", new String(list.get(i).getPunishRemark()));
			map.put("RewardRank", new String(list.get(i).getRewardRank()));
			map.put("RewardRemark", new String(list.get(i).getRewardRemark()));
			li.add(map);
		}
		return li;
	}

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

}


