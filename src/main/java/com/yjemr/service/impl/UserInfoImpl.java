package com.yjemr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yjemr.dao.UserInfoMapper;
import com.yjemr.pojo.UserInfo;
import com.yjemr.service.IUserInfoService;

@Service
public class UserInfoImpl implements IUserInfoService {

	@Resource
	private UserInfoMapper user;
	
	/**
	 * 获取用户信息
	 */
	@Override
	public UserInfo getUserInfoByUserIdAndPassword(String userId,
			String password) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(userId);
		userInfo.setPassword(password);
		List<UserInfo> userList = user.getUserInfoByAll(userInfo);
		if(userList != null && userList.size()>0)
			return user.getUserInfoByAll(userInfo).get(0);
		return null;
	}

}
