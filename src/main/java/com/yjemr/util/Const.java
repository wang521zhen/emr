package com.yjemr.util;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Key;

public class Const {
	//用户信息 UserInfo
	public static final String USER_INFO = "USER_INFO"; 
	//用户信息 对应权限集合UserPopedomList
	public static final String USER_POPEDOM_LIST = "USER_POPEDOM_LIST"; 
	//用户信息对应科室集合 UserXRoleList
	public static final String USER_X_ROLE_LIST = "USER_X_ROLE_LIST"; 

	public static final String LOGIN = "/login_toLogin.do"; //登录地址
	public static final String SESSION_USERINFO = "sessionUserInfo";
	public static final String NO_INTERCEPTOR_PATH = ".*/((login)|(logout)|(code)|(app)|(POST)|(websocket)).*"; //不对匹配该值的访问路径拦截（正则）
	
	public static final Key KEY = MacProvider.generateKey(SignatureAlgorithm.HS512);
	
	public static final String TOKEN = "auth_token";//token头header标识
	public static final String SESSION = "session";//session
	public static final String SHA = "SHA-1";//加密方式

}
