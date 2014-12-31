package cn.zcib.junit;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zcib.bean.Reward;
import cn.zcib.service.JCService;

public class JCServiceTest {

	private static JCService service;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			service = (JCService)applicationContext.getBean("jcService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() throws Exception{
		List<Reward> list = service.getJlsBySid("201001014125");
		for(int i=0; i<list.size(); i++)
		{
			System.out.println(list.get(i).getPrize());
		}
	}

}
