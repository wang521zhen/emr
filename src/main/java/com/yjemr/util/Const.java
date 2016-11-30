package com.yjemr.util;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Key;

public class Const {
	public static final String LOGIN = "/login_toLogin"; //登录地址
	public static final String SESSION_USERINFO = "sessionUserInfo";
	public static final String NO_INTERCEPTOR_PATH = ".*/((login)|(logout)|(code)|(app)|(POST)|(websocket)).*"; //不对匹配该值的访问路径拦截（正则）
	
	public static final Key KEY = MacProvider.generateKey(SignatureAlgorithm.HS512);
	
	public static final String TOKEN = "auth_token";//token头header标识
	public static final String SESSION = "session";//session
	public static final String SHA = "SHA-1";//加密方式

}
