package com.yjemr.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.yjemr.session.MySessionContext;
import com.yjemr.util.Const;
import com.yjemr.util.TokenUtil;

@Component
public class CorsFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		
		System.out.println(request.getRequestURI());
		//String origin = (String) servletRequest.getRemoteHost()+":"+servletRequest.getRemotePort();
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,auth_token");
        //如果IE浏览器则设置头信息如下
  		if("IE".equals(servletRequest.getParameter("type"))){
  			response.addHeader("XDomainRequestAllowed","1");
  		}
  		String re = request.getHeader(Const.TOKEN);
		String sessionId = (String)TokenUtil.getValue(re, Const.KEY, Const.SESSION);
		HttpSession session = MySessionContext.getSession(sessionId);
		if (session != null) {
			@SuppressWarnings("unchecked")
			Enumeration<String> s = session.getAttributeNames();
			while(s.hasMoreElements()) {
				String name = s.nextElement();
				request.getSession().setAttribute(name, session.getAttribute(name));
			}
			session.invalidate();//销毁不用session
		}
        filterChain.doFilter(servletRequest, servletResponse);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
