package cn.zcib.junit;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zcib.bean.ClassBean;
import cn.zcib.service.ClassService;

public class ClassTest {

	private static ClassService service;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			service = (ClassService)applicationContext.getBean("classService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() throws Exception{
		List<ClassBean>list = service.getClassByAssis("王保栋");
		System.out.println(list.size());
		for (ClassBean clazz : list) {
			System.out.println(clazz.getName());
		}
	}

}
