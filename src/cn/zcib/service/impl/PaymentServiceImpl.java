package cn.zcib.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zcib.dao.BaseDao;
import cn.zcib.service.PaymentService;

@Transactional(propagation=Propagation.REQUIRED)
public class PaymentServiceImpl implements PaymentService
{
	//通过spring注入
	@Resource private @Qualifier("baseDao") BaseDao baseDao;
	
//	@Override
//	public int getDebtNumByClass(String clazz)
//	{
//		String sql = "select count(distinct q.Number) " +
//				"from " +
//				"Payment as pa1,Class as cl,StuBaseInfo as sb," +
//				"(select pa.Number,sum(pa.Amount) as s from Payment as pa where 1 group by pa.Number) as q " +
//				"where " +
//				"q.s<(select ma.Tuition from Class as cl,Major as ma where cl.MajorID=ma.ID and cl.Name='"+clazz+"') " +
//				"and sb.Class=cl.Name and cl.Name='"+clazz+"' and sb.Number=pa1.Number and pa1.Session='2014'";
//		return Integer.parseInt(baseDao.querySql(sql).get(0).toString());
//	}
	
//	@Override
	/*public void getAmountListByClass(String clazz,int year)
	{
		Map<String, Map>map = new HashMap<String, Map>();
		String sql = "";
		//先查询本年度该班级已交费情况，条件：班级+年份
		sql = "select pa.Number,sum(pa.Amount) as asum " +
				"from Payment as pa,StuBaseInfo as sb " +
				"where sb.Class='"+clazz+"' and sb.Number=pa.Number and pa.Session="+year+" " +
				"group by pa.Number";
		List<Object[]> list1 = baseDao.querySql(sql);
		
		//再查询该班级所有人[Number,Name]
		sql = "select sb.Number,sb.Name " +
				"from StuBaseInfo as sb " +
				"where sb.Class='"+clazz+"'";
		List<Object[]> list2 = baseDao.querySql(sql);
		
		//再查询该专业学费
		sql = "select ma.Tuition " +
				"from Class as cl,Major as ma " +
				"where cl.MajorID=ma.ID and cl.Name='"+clazz+"'";
		List<Object> list3 = baseDao.querySql(sql);
		
		//最后根据以上两个结果得出一张本班半年度交费清单，包含（学号，已交费总额）
		//1，根据学号建立表的架构
		for(int i=0; i<list2.size(); i++)
		{
			map.put(list2.get(i).toString(), new HashMap<String, Object>());
		}
		//2，合并已缴费表
		for(int i=0; i<list1.size(); i++)
		{
			Object[] obj = list1.get(i);
			if(map.containsKey(obj[0].toString()))
			{
				map.remove(obj[0].toString());
				map.put(obj[0].toString(), Float.parseFloat(obj[1].toString()));
			}
		}
	}*/
	@Override
	public int getDebtNumByClass(String clazz,int year)
	{
		Map<String, Float> map = this.getAmountByClass(clazz, year);
		float tuition = map.get("Tuition");
		
		Set<String>keys = map.keySet();
		Iterator<String> it = keys.iterator();
		int DebtNum = 0;
		while(it.hasNext())
		{
			String key = it.next();
			float value = map.get(key);
			if(value < tuition)
			{
				DebtNum ++;
			}
		}
		
		return DebtNum;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Float> getAmountByClass(String clazz,int year)
	{
		Map<String, Float>map = new HashMap<String,Float>();
		String sql = "";
		//先查询本年度该班级已交费情况，条件：班级+年份
		sql = "select pa.Number,sum(pa.Amount) as asum " +
				"from Payment as pa,StuBaseInfo as sb " +
				"where sb.Class='"+clazz+"' and sb.Number=pa.Number and pa.Session="+year+" " +
				"group by pa.Number";
		List<Object[]> list1 = baseDao.querySql(sql);
		
		//再查询该班级所有人
		sql = "select sb.Number " +
				"from StuBaseInfo as sb " +
				"where sb.Class='"+clazz+"'";
		List<Object> list2 = baseDao.querySql(sql);
		
		//再查询该专业学费
		sql = "select ma.Tuition " +
				"from Class as cl,Major as ma " +
				"where cl.MajorID=ma.ID and cl.Name='"+clazz+"'";
		float tuition = Float.parseFloat(baseDao.querySql(sql).get(0).toString());
		map.put("Tuition", tuition);
		
		//最后根据以上两个结果得出一张本班半年度交费清单，包含（学号，已交费总额）
		//1，根据学号建表，交费总额默认为0
		for(int i=0; i<list2.size(); i++)
		{
			map.put(list2.get(i).toString(), Float.parseFloat("0"));
		}
		//2，合并已缴费表
		for(int i=0; i<list1.size(); i++)
		{
			Object[] obj = list1.get(i);
			if(map.containsKey(obj[0].toString()))
			{
				map.remove(obj[0].toString());
				map.put(obj[0].toString(), Float.parseFloat(obj[1].toString()));
			}
		}
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HashMap<String, String>> getPaymentByClass(String clazz,int year){
		String sql = "select " +
				"pa.id,sb.Number,ifnull(sb.Name,''),pa.Session,pa.Amount,pa.Time,pa.State,pa.Remark," +
				"ifnull(cl.Name,'') " +
				"from Payment as pa,Class as cl,StuBaseInfo as sb ";
		String where = "where sb.Class=cl.Name and sb.Number=pa.Number and sb.Class='"+clazz+"' and pa.Session="+year;
		if("".equals(clazz) || "--请选择--".equals(clazz) || null == clazz)
		{
			//检测出冗余交费记录
			where = "where " +
					"(pa.Number not in (select sb2.Number from StuBaseInfo as sb2) or pa.Number is null)" +
					" or " +
					"(cl.Name not in (select cl2.Name from Class as cl2) or cl.Name is null)";
		}
		List<HashMap<String, String>> mapList = new ArrayList<HashMap<String, String>>();
		List<Object[]> list = baseDao.querySql(sql + where);
		for(int i=0; i<list.size(); i++){
			HashMap<String, String> map = new HashMap<String, String>();
			Object[] obj = list.get(i);
			int j = 0;
			map.put("id", obj[j++]+"");
			map.put("sid", obj[j++]+"");
			map.put("name", obj[j++]+"");
			map.put("session", obj[j++]+"");
			map.put("amount", obj[j++]+"");
			map.put("time", obj[j++]+"");
			map.put("status", obj[j++]+"");
			map.put("remark", obj[j++]+"");
			map.put("clazz", obj[j++]+"");
			mapList.add(map);
		}
		
		return mapList;
	}
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
}


