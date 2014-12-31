package cn.zcib.junit;

import java.io.File;
import java.text.SimpleDateFormat;

import jxl.Sheet;
import jxl.Workbook;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zcib.bean.ClassBean;
import cn.zcib.bean.Department;
import cn.zcib.bean.Major;
import cn.zcib.bean.StuBase;
import cn.zcib.bean.StuDetail;
import cn.zcib.dao.BaseDao;

public class Excel2DB {

	private static BaseDao baseDao;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			baseDao = (BaseDao)applicationContext.getBean("baseDao");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() throws Exception{
		testBegin();
	}
	public void testBegin() {
		try {
			Workbook book = Workbook.getWorkbook(new File("WebRoot/dist/resource/学生模板.xls"));
			//获取第一个Sheet
			Sheet sheet = book.getSheet(0);
			
			//////////////// 定义实体 ////////////////
			//系
			Department depart = new Department("01".toCharArray(),"计算机科学系".toCharArray());
			depart.setHeader("李志强");
			baseDao.saveOrUpdate(depart);
			depart = (Department) baseDao.selectByX(Department.class,"Name='计算机科学系'");
			//专业
			Major maj = new Major("014".toCharArray(), "计算机科学与技术".toCharArray());
			maj.setDepID(depart.getID());
			baseDao.saveOrUpdate(maj);
			maj = (Major) baseDao.selectByX(Major.class,"Name='计算机科学与技术'");
			//班级
			ClassBean clazz = new ClassBean("计科121");
			clazz.setMajorID(maj.getID());

			baseDao.saveOrUpdate(clazz);
			clazz = (ClassBean) baseDao.selectByX(ClassBean.class,"Name='计科121'");
			baseDao.saveOrUpdate(maj);
			
			for(int i=2; i<sheet.getRows(); i++)
			{
				if(i==1) break;

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				StuBase sb = new StuBase();
				StuDetail sd = new StuDetail();
				
				sb.setClazz( sheet.getCell(9, i).getContents() );
				sb.setPassword("123");
				
				sd.setRxnf( sheet.getCell(1, i).getContents().toCharArray() );
				sb.setNumber( sheet.getCell(2, i).getContents().toCharArray() );
				sd.setNumber( sheet.getCell(2, i).getContents().toCharArray() );
				sd.setHomeAddress( sheet.getCell(18, i).getContents() );
				sd.setBirthday( sdf.parse(sheet.getCell(13, i).getContents()) );
				sb.setSex( sheet.getCell(4, i).getContents().toCharArray() );
				sd.setIDCard( sheet.getCell(12, i).getContents() );
				sb.setName( sheet.getCell(3, i).getContents() );
				sd.setNation( sheet.getCell(14, i).getContents() );
				sd.setNative( sheet.getCell(15, i).getContents() );
				sd.setPhone( sheet.getCell(20, i).getContents() );
				
				sd.setKslb( sheet.getCell(24, i).getContents() );
				sd.setPoliticalStatus( sheet.getCell(21, i).getContents() );
				sd.setRemark( sheet.getCell(30, i).getContents() );
				sd.setEducateLevel( sheet.getCell(25, i).getContents() );
				
//				sst.setChange_type( sheet.getCell(28, i).getContents() );
//				sst.setChange_reason( sheet.getCell(29, i).getContents() );
//				sst.setStu_id(sb.getId());
//				
//				baseDao.insert(sst);
				baseDao.saveOrUpdate(sd);
				baseDao.saveOrUpdate(sb);
			}
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
