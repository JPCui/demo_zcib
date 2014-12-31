package cn.zcib.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zcib.bean.SocialRelation;
import cn.zcib.bean.StuBase;
import cn.zcib.bean.StuDetail;
import cn.zcib.dao.BaseDao;
import cn.zcib.service.StudentService;
import cn.zcib.util.FileUtil;
import cn.zcib.util.MessageResource;

@Transactional(propagation = Propagation.REQUIRED)
public class StudentServiceImpl implements StudentService{

	@Resource private @Qualifier("baseDao") BaseDao baseDao;
	
	@Override
	public String checkSidIsDepart(String Sid,String Depart)
	{
		int res = baseDao.querySql("select * from StuBaseInfo as sb,Department as de " +
				"where sb.Number='"+Sid+"' and sb.DepID=de.ID and de.Name='"+Depart+"'").size();
		if(res > 0)return "1";
		else return "该学号与系部不符合，请检查是否输入正确（学号："+Sid+"，系部："+Depart+"）";
	}
	
	@Override
	public String updatePhoto(File file,String fileName,String Number)
	{
		if(fileName.endsWith(".exe")){
			return "对不起,你上传的文件格式不允许!!!";
		}
		//更换图片名
		int end = fileName.lastIndexOf(".");
		String suffix = fileName.substring(end, fileName.length());
		fileName = Number + suffix;
		//获取文件全路径
		String path = ServletActionContext.getServletContext().getRealPath(MessageResource.getZH_CN("path_stu_photo")) + "/"+ fileName;

		//先更换数据库内容，如果有异常，后续将不再执行
		String sql = "update StuDetailInfo set Photo='" + fileName + "' where Number='" + Number + "'";
		if(baseDao.exeSql(sql)!=1)return "文件保存失败，请联系管理员。。。";

		//再保存文件
		if(!FileUtil.save(file, path,true))return "文件保存失败，请联系管理员。。。";
		
		return "文件上传成功";
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, String> getStuFull(String id) {
		String sql = "select " +
				//StuBaseInfo
				"sb.Number,sb.Password,ifnull(sb.Name,''),sb.Sex,ifnull(sb.Enrolment,'')," +
				"ifnull(sb.DepID,''),sb.Class," +
				//StuDetailInfo
				"ifnull(sd.Dormitory,''),ifnull(sd.Photo,''),sd.EducateLevel,sd.PoliticalStatus,sd.Nation," +
				"sd.Birthday,sd.Native,sd.IDCard,sd.HomeAddress,sd.PostalCode," +
				"sd.Phone,sd.Xszz,sd.Kslb,sd.Ydyy,sd.Rxcj," +
				"sd.Rxnf,sd.Remark " +
				
				"from StuDetailInfo as sd,StuBaseInfo as sb " +
				"where sd.Number=sb.Number and sb.Number='"+id+"' ";
		String sql2 = "select " +
				//Other
				"ifnull(ma.Name,''),ifnull(de.Name,''),ma.Campus,ma.Education,ma.Tuition " +
				
				"from StuBaseInfo as sb,Class as cl,Major as ma,Department as de " +
				"where sb.Number='"+id+"' and sb.Class=cl.Name " +
						"and cl.MajorID=ma.ID and ma.DepID=de.ID";

		List<Object[]> list = baseDao.querySql(sql);
		List<Object[]> list2 = baseDao.querySql(sql2);
		
		HashMap<String, String> map = new HashMap<String, String>();
		if(list.size() > 0)
		{
			Object[] obj = list.get(0);
			int j = 0;
			map.put("ID", obj[j++]+"");
			//StuBaseInfo
			map.put("Password", obj[j++]+"");map.put("Name", obj[j++]+"");
			map.put("Sex", obj[j++]+"");	map.put("Enrolment",obj[j++]+"");
			map.put("DepID",  obj[j++]+"");	map.put("Class",obj[j++]+"");
			//StuDetailInfo
			map.put("Dormitory", obj[j++]+"");	map.put("Photo", obj[j++]+"");
			map.put("EduLevel", obj[j++]+"");	map.put("PolStatus", obj[j++]+"");
			map.put("Nation", obj[j++]+"");	map.put("Birthday", obj[j++]+"");
			map.put("Native", obj[j++]+"");	map.put("IDCard", obj[j++]+"");
			map.put("HomAddr", obj[j++]+"");	map.put("PosCode", obj[j++]+"");
			map.put("Phone", obj[j++]+"");	map.put("Xszz", obj[j++]+"");
			map.put("Kslb", obj[j++]+"");	map.put("Ydyy", obj[j++]+"");
			map.put("Rxcj", obj[j++]+"");	map.put("Rxnf", obj[j++]+"");
			map.put("Remark", obj[j++]+"");
		}
		if(list2.size() > 0)
		{
			Object[] obj = list2.get(0);
			int j = 0;
			//Other
			map.put("Major", obj[j++]+"");	map.put("Depart", obj[j++]+"");
			map.put("Campus", obj[j++]+"");	map.put("Education", obj[j++]+"");
			map.put("Tuition", obj[j++]+"");
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SocialRelation> getRelation(String id) {
		List<SocialRelation> list = baseDao.selectAllByX("SocialRelation", "Number='"+id+"'");
		return list;
	}
	
	@Override
	public String addRelation(SocialRelation sr) {
		if(baseDao.insert(sr)==0) return "添加失败";
		else return "添加成功";
	}

	@Override
	public String delStu(String Number)
	{
		int res = 0;
		//一共删除 6 张表里的内容
		if( (res+=baseDao.exeHql("delete StuDetail where Number='" + Number + "'")) >= 0)
			if( (res+=baseDao.exeHql("delete SocialRelation where Number='" + Number + "'")) >= 0)
				if((res+=baseDao.exeHql("delete Punish where Number='" + Number + "'")) >= 0)
					if((res+=baseDao.exeHql("delete Reward where Number='" + Number + "'")) >= 0)
						if((res+=baseDao.exeHql("delete Payment where Number='" + Number + "'")) >= 0)
							if((res+=baseDao.exeHql("delete StuBase where Number='" + Number + "'")) >= 0)
							if(res > 1)
							{
								return "删除成功!";
							}
		return "删除失败，数据不存在或异常";
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<HashMap<String, String>> getStusByClass(String clazz){
		String sql = "select " +
				"sb.Number,sb.Name,sb.Sex,sd.Nation,sd.HomeAddress,sd.Phone,sd.PostalCode " +
				"from StuDetailInfo as sd,StuBaseInfo as sb ";
		String where = "where sd.Number=sb.Number and sb.Class='"+clazz+"'";
		if("".equals(clazz) || "--请选择--".equals(clazz) || null == clazz)
		{
			where = "where sd.Number=sb.Number and " +
					"(sb.Class not in (select cl2.Name from class as cl2) or sb.Class is null);";
		}
		List<HashMap<String, String>> mapList = new ArrayList<HashMap<String, String>>();
		List<Object[]> list = baseDao.querySql(sql + where);
		
		for(int i=0; i<list.size(); i++){
			HashMap<String, String> map = new HashMap<String, String>();
			Object[] obj = list.get(i);
			int j = 0;
			map.put("Number", obj[j++]+"");
			map.put("Name", obj[j++]+"");
			map.put("Sex", obj[j++]+"");
			map.put("Nation", obj[j++]+"");
			map.put("HomeAddress", obj[j++]+"");
			map.put("tel", obj[j++]+"");
			map.put("post", obj[j++]+"");
			mapList.add(map);
		}
		
		return mapList;
	}
	@Override
	public StuBase login(String id, String pwd) {
		StuBase stu = new StuBase();
		try
		{
			//获取用户对象
			stu = (StuBase) baseDao.select(StuBase.class.getSimpleName(),id);
			//判断用户密码
			if( pwd.equals( stu.getPassword() ) )
			{
				return stu;
			}
		}catch(Exception e){
		}
		return null;
	}
	
	public BaseDao getBaseDao() {
		return baseDao;
	}
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public String updateStu(StuBase sb,StuDetail sd) {
		System.out.println(sd.getRxnf());
		try {
			if(baseDao.saveOrUpdate(sb) == 1 && baseDao.saveOrUpdate(sd) == 1)
			{
				return "更新成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "更新失败，数据异常，请联系管理员!!";
	}
	
	@Override
	public String addStu(StuBase sb,StuDetail sd) {
		try {
			if(baseDao.saveOrUpdate(sb) == 1 && baseDao.saveOrUpdate(sd) == 1)
			{
				return "添加成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "添加失败，数据异常，请联系管理员!!";
	}

	@Override
	public String updateRelation(SocialRelation sr) {
		try {
			if(baseDao.saveOrUpdate(sr) == 1)
			{
				return "更新成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "更新失败，数据异常，请联系管理员!!";
	}
	@Override
	public String delRelation(SocialRelation sr) {
		try {
			if(baseDao.delete(sr.getClass(), sr.getID()) == 1)
			{
				return "删除成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "删除失败，数据异常，请联系管理员!!";
	}

}
