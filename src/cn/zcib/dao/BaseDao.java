package cn.zcib.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * DAO层基础接口
 * @author REAL
 * @param <T>
 */
@SuppressWarnings("rawtypes")
public interface BaseDao {
	public int insert(Object object);
	public int delete(Class clazz, Serializable id);
	public int saveOrUpdate(Object object);
	public int update(Object object);
	/**
	 * 执行hql语句
	 * @param hql
	 * @return 返回结果集
	 */
	public List queryHql(String hql);
	public List querySql(String sql);
	/**
	 * @return 返回所有记录条数
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int getAllRowCount(String clazz);
	/**
	 * 根据主键值查询
	 * @param id 主键值
	 * @return 返回一个实体
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Object select(String clazz,Serializable id);
	/**
	 * 获取一个实体，因为在本系统中，name可以看作是唯一键
	 * @param name
	 * @return
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	Object selectByX(Class clazz, String X);
	/**
	 * 查询所有
	 * @return 返回结果集
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public abstract List selectAll(Class clazz);
	/**
	 * 利用sql limit(begin,end),
	 * begin = (pagenum-1)*count,
	 * end = pagenum*count.
	 * @param pagenum 页码
	 * @param count 每页显示数据条数
	 * @return
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List getPage(String clazz,int currentpage, int pagesize);
	
	public int exeHql(String hql);
	List selectAllByX(String clazz, String X);
	int exeSql(String sql);
}