package cn.zcib.junit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zcib.service.StudentService;

public class StudentTest {

	private static StudentService service;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			service = (StudentService)applicationContext.getBean("studentService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() throws Exception{
		testBegin();
	}
	public void testBegin() {
		System.out.println(service.checkSidIsDepart("20100101412", "计算机科学系"));
	}

}
