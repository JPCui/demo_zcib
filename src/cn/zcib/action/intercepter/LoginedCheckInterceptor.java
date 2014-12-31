package cn.zcib.action.intercepter;

import org.apache.struts2.ServletActionContext;

import cn.zcib.action.ActionUtil;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/** session过期、登录有效性及操作的权限验证拦截器 */
public class LoginedCheckInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4062980318172776026L;

	/** 拦截请求并进行登录有效性验证 */
	public String intercept(ActionInvocation ai) throws Exception {
		//取得请求的URL
		String url = ServletActionContext.getRequest().getRequestURL().toString();
		String prim = null;
		String Lprivilege = null;
		int index = 0;
		//验证Session是否过期
		if(!ServletActionContext.getRequest().isRequestedSessionIdValid()){
			//session过期,转向session过期提示页,最终跳转至登录页面
			System.out.println("Session过期");
			return "tologin";
		}else{
			//对登录与注销请求直接放行,不予拦截
			if (url.indexOf("admin_login")!=-1 || url.indexOf("admin_logout")!=-1){
				return ai.invoke();
			}else{
				Lprivilege = (String)ServletActionContext.getRequest().getSession().getAttribute("LoginUserPrivilege");
				System.out.println(Lprivilege+"***");
				//验证是否已经登录
				if (Lprivilege==null){
					//尚未登录,跳转至登录页面
					System.out.println(Lprivilege+"空的");
					return "tologin";
				}else{
					//功能模块与权限位映射,部分可能与前台请求重名的请求加上命名空间"/admin"以示区别
					if (url.indexOf("/admin_")!=-1 || url.indexOf("/updateAdmin")!=-1){//系统用户管理
						index = 2; //权限位为2
					}
					//取得当前用户的操作权限
					prim = Lprivilege.trim();
					//进行权限验证
					if (index>0){
						if (prim.substring(0,1).equals("1") || prim.substring(index-1,index).equals("1")){
							//验证通过,放行
							return ai.invoke();
						}else{
							//验证失败,转向权限验证失败提示页
							return ActionUtil.TOLOGIN;
						}
					}else{
						//其它不需要权限验证的请求直接放行
						return ai.invoke();
					}					
				}				
			}			
		}
	}
}
