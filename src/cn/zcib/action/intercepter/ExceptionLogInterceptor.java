package cn.zcib.action.intercepter;

import java.util.Date;

import javax.transaction.SystemException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/** session过期、登录有效性及操作的权限验证拦截器 */
public class ExceptionLogInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ExceptionLogInterceptor.class);

	public String intercept(ActionInvocation actionInvocation) throws Exception {

		String result = "";
		try {
			result = actionInvocation.invoke();
		} catch (Exception ex) {
			StackTraceElement[] stes = ex.getStackTrace();
			System.out.println("我是拦截器: "+ex);
			for (StackTraceElement ste : stes) {
//				if(ste.toString().indexOf("")!=-1)
					System.out.println("\t at " + ste);
			}
			logger.error(new Date() + " : " + ex.toString());
			throw new SystemException("程序内部错误，操作失败！");
		}
		logger.debug(new Date() + " : ==");
		return result;

    }
}
