package cn.zcib.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ClassUtil {

	/**
	 * 通过反射技术，获取使用泛型编程的类中 T 的类型
	 * <p>注：在dao层实现中，第一个泛型必须写出来!
	 * @param obj T 泛型
	 * @return 返回 T 的类型，class
	 */
	@SuppressWarnings("rawtypes")
	public static Class getTClassName(Object obj)
	{
		Type type = obj.getClass().getGenericSuperclass();
		Type[] types = ((ParameterizedType)type).getActualTypeArguments();
		Class clazz = (Class)types[0];
		return clazz;
	}
	
}
