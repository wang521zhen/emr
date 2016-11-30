package com.yjemr.dao;

import java.util.List;

import com.yjemr.pojo.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(String userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    
    List<UserInfo> getUserInfoByAll(UserInfo record);
}