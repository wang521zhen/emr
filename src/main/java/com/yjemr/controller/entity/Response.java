package com.yjemr.controller.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;

import com.yjemr.util.Const;
import com.yjemr.util.TokenUtil;

public class Response {

    private static final String OK = "ok";
    private static final String ERROR = "error";

    private Meta meta;
    private Object data;
    private String token;
    
    public Response(String sessionId){
    	Map<String, Object> map = new HashMap<String, Object>();
		map.put(Const.SESSION, sessionId);
		token = TokenUtil.getJWTString("", DateUtils.addDays(new Date(), 30)
				, Const.KEY, "", map);
    }

    public Response success() {
        this.meta = new Meta(true, OK);
        return this;
    }

    public Response success(Object data) {
        this.meta = new Meta(true, OK);
        this.data = data;
        return this;
    }

    public Response failure() {
        this.meta = new Meta(false, ERROR);
        return this;
    }

    public Response failure(String message) {
        this.meta = new Meta(false, message);
        return this;
    }

    public Meta getMeta() {
        return meta;
    }

    public Object getData() {
        return data;
    }
    
    public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}



	public class Meta {

        private boolean success;
        private String message;

        public Meta(boolean success) {
            this.success = success;
        }

        public Meta(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }
    }
}
