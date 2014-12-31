package cn.zcib.junit;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zcib.bean.Department;
import cn.zcib.service.DepartService;

public class DepartTest {

	private static DepartService service;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			service = (DepartService)applicationContext.getBean("departService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() throws Exception{
		List<Department> list = service.getDepartments();
		System.out.println(list.get(0).getName());
	}

}
