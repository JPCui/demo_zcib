package cn.zcib.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;


@SuppressWarnings({ "rawtypes" })
@Transactional
public class BaseDaoImpl implements BaseDao{

	@Resource protected SessionFactory sessionFactory;
	@Override
	public int insert(Object object)
	{
		try {
			sessionFactory.getCurrentSession().persist(object);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	@Override
	public int saveOrUpdate(Object object)
	{
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(object);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	@Override
	public int delete(Class clazz,Serializable id)
	{
		try {
			Object o = sessionFactory.getCurrentSession().load(clazz, id);
			sessionFactory.getCurrentSession().delete( o );
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	@Override
	public int update(Object object)
	{
		sessionFactory.getCurrentSession().update(object);
		return 1;
	}

	@Override
	public Object selectByX(Class clazz,String X) {
		List list = new ArrayList();
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from "+clazz.getSimpleName()+" where "+X;
			System.out.println("hql : " + hql);
			Query query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list.get(0);
	}
	@Override
	public List selectAllByX(String clazz,String X) {
		List list = new ArrayList();
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from "+clazz+" where "+X;
			Query query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public Object select(String clazz,Serializable id)
	{
		Object object=null;
		try{
			List list = sessionFactory.getCurrentSession().createQuery("from "+clazz+" where id="+id).list();
			object = list.get(0);
		}catch(Exception e)
		{
			return null;
		}
		return object;
	}
	@Override
	public List selectAll(Class clazz)
	{
		return sessionFactory.getCurrentSession().createQuery( "from "+clazz.getSimpleName() ).list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List queryHql(String hql) {
		List list = new ArrayList();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> querySql(String sql) {
		List<Object> list = new ArrayList<Object>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(sql);
		list = query.list();
		return list;
	}
	/**
	 * 通过hibernate现有方法获取所需范围的
	 * @param currentpage 当前页
	 * @param pagesize 每页显示大小
	 * @return 返回所请求的页面
	 */
	@Override
	public List getPage(String clazz,int pagenum, int pagesize) {
		int first;
		first = (pagenum-1)*pagesize+1;
		String hql = "from "+clazz+" order by id";
		List list = new ArrayList();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(hql);
			query.setFirstResult(first-1);
			query.setMaxResults(pagesize);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int getAllRowCount(String clazz) {
		int rowCount = 0;
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from " + clazz);
			rowCount = query.list().size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	@Override
	public int exeHql(String hql) {
		try {
			Session session = sessionFactory.getCurrentSession();
			return session.createQuery(hql).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public int exeSql(String sql) {
		Session session = sessionFactory.getCurrentSession();
		return session.createSQLQuery(sql).executeUpdate();
	}
}





