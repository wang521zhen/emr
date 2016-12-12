package com.yjemr.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yjemr.session.MySessionContext;
import com.yjemr.util.Const;
import com.yjemr.util.TokenUtil;

/**
 * 访问拦截，所有session超时或者账号密码错误重定向
 * @author Administrator
 *
 */
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("执行过滤器："+request.getServletPath());
		String path = request.getServletPath();
		if (path.matches(Const.NO_INTERCEPTOR_PATH)) {
			return true;
		} else {
			String re = request.getHeader(Const.TOKEN);
	  		if (re == null || re == ""){
	  			request.getRequestDispatcher(Const.LOGIN).forward(request,response);
	  			return false;
	  		}
			String sessionId = (String)TokenUtil.getValue(re, Const.KEY, Const.SESSION);
			HttpSession session = MySessionContext.getSession(sessionId);
			if (session != null) {
				@SuppressWarnings("unchecked")
				Enumeration<String> s = session.getAttributeNames();
				while(s.hasMoreElements()) {
					String name = s.nextElement();
					request.getSession().setAttribute(name, session.getAttribute(name));
				}
				//session.invalidate();//销毁不用session 暂时不考虑销毁-防止本次访问出问题，下次无法访问
			} else {
				request.getRequestDispatcher(Const.LOGIN).forward(request,response);
				return false;
			}
			return true;
		}
	}
}
