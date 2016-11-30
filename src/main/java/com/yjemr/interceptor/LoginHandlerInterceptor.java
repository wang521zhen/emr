package com.yjemr.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yjemr.pojo.UserInfo;
import com.yjemr.util.Const;

/**
 * 访问拦截，所有session超时或者账号密码错误重定向
 * @author Administrator
 *
 */
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		String path = request.getServletPath();
		if (path.matches(Const.NO_INTERCEPTOR_PATH)) {
			return true;
		} else {
			HttpSession session = request.getSession();
			if (session != null) {
				UserInfo user = (UserInfo) session.getAttribute(Const.SESSION_USERINFO);
				if (user != null) {
					
					return true;
				}
			} 
			//登陆过滤
			response.sendRedirect(request.getContextPath() + Const.LOGIN);
			return false;
		}
	}
}
