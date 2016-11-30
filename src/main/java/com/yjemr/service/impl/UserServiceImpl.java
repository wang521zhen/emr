package com.yjemr.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yjemr.dao.UserTMapper;
import com.yjemr.pojo.UserT;
import com.yjemr.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Resource
	private UserTMapper userTmapper;
	
	@Override
	public UserT getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userTmapper.selectByPrimaryKey(userId);
	}

	/**
	 * 获取用户登录信息
	 */
	@Override
	public UserT getUserByNameAndPwd(UserT record) {
		// TODO Auto-generated method stub
		return userTmapper.getUserByNameAndPwd(record);
	}
}
