package cn.zcib.junit;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zcib.service.PaymentService;

public class PaymentTest {

	private static PaymentService service;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			service = (PaymentService)applicationContext.getBean("paymentService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() throws Exception{
		Map<String, Float>map= service.getAmountByClass("计科121", 2014);
		System.out.println(map.size());
		System.out.println(map.get("201201014101"));
		System.out.println(map.get("Tuition"));
		System.out.println("共有"+service.getDebtNumByClass("计科121", 2014)+"人欠费");
	}

}
