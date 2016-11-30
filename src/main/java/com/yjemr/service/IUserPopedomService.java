package com.yjemr.service;

import java.util.List;

import com.yjemr.pojo.UserPopedom;
import com.yjemr.pojo.UserPopedomKey;

public interface IUserPopedomService {
	public List<UserPopedom> selectByPrimaryKey(UserPopedomKey key);
}
