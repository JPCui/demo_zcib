package cn.zcib.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zcib.bean.User;
import cn.zcib.dao.BaseDao;
import cn.zcib.service.UserService;

@Transactional(propagation=Propagation.REQUIRED)
public class UserServiceImpl implements UserService
{
	//通过spring注入
	@Resource private @Qualifier("baseDao") BaseDao baseDao;

	@Override
	public User login(String id, String pwd) {
		User user = new User();
		try
		{
			//获取用户对象
			user = (User) baseDao.select(User.class.getSimpleName(),id);
			//判断用户密码
			if( pwd.equals( user.getPassword() ) )
			{
				return user;
			}
		}catch(Exception e){
		}
		return null;
	}
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

}


