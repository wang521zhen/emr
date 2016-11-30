package com.yjemr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yjemr.dao.UserXRoleMapper;
import com.yjemr.pojo.UserXRoleKey;
import com.yjemr.service.IUserXRoleKeyService;

@Service
public class UserXRoleKeyImpl implements IUserXRoleKeyService {
	
	@Resource
	private UserXRoleMapper userX;

	@Override
	public List<UserXRoleKey> selectByAll(UserXRoleKey record) {
		return userX.selectByAll(record);
	}

}
