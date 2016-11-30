package com.yjemr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yjemr.dao.UserPopedomMapper;
import com.yjemr.pojo.UserPopedom;
import com.yjemr.pojo.UserPopedomKey;
import com.yjemr.service.IUserPopedomService;

@Service
public class UserPopedomImpl implements IUserPopedomService {
	
	@Resource
	private UserPopedomMapper userP;

	@Override
	public List<UserPopedom> selectByPrimaryKey(UserPopedomKey key) {
		// TODO Auto-generated method stub
		return userP.selectByPrimaryKey(key);
	}

}
