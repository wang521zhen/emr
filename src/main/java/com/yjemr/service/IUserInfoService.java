package com.yjemr.service;

import com.yjemr.pojo.UserInfo;

public interface IUserInfoService {
	public UserInfo getUserInfoByUserIdAndPassword(String userId ,String password);
}
