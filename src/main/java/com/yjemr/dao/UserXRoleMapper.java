package com.yjemr.dao;

import java.util.List;

import com.yjemr.pojo.UserXRoleKey;

public interface UserXRoleMapper {
    int deleteByPrimaryKey(UserXRoleKey key);

    int insert(UserXRoleKey record);

    int insertSelective(UserXRoleKey record);
    
    List<UserXRoleKey> selectByAll(UserXRoleKey record);
}