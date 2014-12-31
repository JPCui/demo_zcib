package cn.zcib.service;

import cn.zcib.bean.User;

/**
 * 管理员业务层接口
 * @author REAL
 *
 * @param <T>
 */
public interface UserService{

	public User login(String id, String pwd);
}