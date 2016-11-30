package com.yjemr.controller.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.yjemr.controller.entity.Response;
import com.yjemr.session.MySessionContext;
import com.yjemr.util.UuidUtil;

public class BaseController {
	protected Logger logger = Logger.getLogger(this.getClass());

	/**
	 * 获取返回对象
	 * @return
	 */
	protected Response getResponse(){
		return new Response(this.getRequest().getSession().getId());
	}
	
	/**
	 * 得到32位的uuid
	 * 
	 * @return
	 */
	public String get32UUID() {

		return UuidUtil.get32UUID();
	}
	
	/**
	 * 得到session
	 */
	public HttpSession getSession(String session_id) {
		HttpSession session = MySessionContext.getSession(session_id);
		if (session == null)
			session = this.getRequest().getSession();
		return session;
	}
	
	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		return request;
	}
	
	/** 
     * 异常页面控制 
     *  
     * @param runtimeException 
     * @return 
     */
	@ExceptionHandler(RuntimeException.class)
	protected Response runtimeExceptionHandler(RuntimeException runtimeException){
		logger.error("error" ,runtimeException);
		return getResponse().failure("exception");
	}
}
