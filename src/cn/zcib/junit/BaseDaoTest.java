package cn.zcib.junit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zcib.bean.ClassBean;
import cn.zcib.bean.User;
import cn.zcib.dao.BaseDao;

public class BaseDaoTest {

	private static BaseDao baseDao;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			setBaseDao((BaseDao)applicationContext.getBean("baseDao"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() throws Exception{
		baseDao.delete(ClassBean.class, 10);
	}
	public void testBegin() {
		User user = new User();
//		user.setID("123".toCharArray());
//		user.setName("123");
//		user.setPassword("123");
//		baseDao.insert(user);

		user.setID("123".toCharArray());
		user.setName("321");
//		user.setPassword("123");
		baseDao.saveOrUpdate(user);
		
	}

	public static BaseDao getBaseDao() {
		return baseDao;
	}

	public static void setBaseDao(BaseDao baseDao) {
		BaseDaoTest.baseDao = baseDao;
	}

}
