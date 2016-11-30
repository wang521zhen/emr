package com.yjemr.service;

import com.yjemr.pojo.UserT;

public interface IUserService {
	public UserT getUserById(int userId);
	public UserT getUserByNameAndPwd(UserT record);
}
