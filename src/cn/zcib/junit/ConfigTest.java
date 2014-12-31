package cn.zcib.junit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zcib.service.ConfigService;

public class ConfigTest {

	private static ConfigService service;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			service = (ConfigService)applicationContext.getBean("configService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() throws Exception{
		System.out.println(service.getAllConfigJson().size());
	}

}
