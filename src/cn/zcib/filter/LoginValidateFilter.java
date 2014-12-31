package cn.zcib.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 用户登录验证
 * @author REAL
 *
 */
public class LoginValidateFilter implements Filter
{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest sRequest, ServletResponse sResponse,
			FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) sRequest;
		HttpServletResponse response = (HttpServletResponse) sResponse;
		HttpSession session = request.getSession();
		
		String Lid = (String) session.getAttribute("LoginId");
		if (Lid == null)
		{
			System.out.println("用户未登陆，被俺拦截了");
			response.sendRedirect( request.getContextPath() );
		}else{
			filterChain.doFilter(sRequest, sResponse);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
}
