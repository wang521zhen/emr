package com.yjemr.dao;

import com.yjemr.pojo.UserT;

public interface UserTMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserT record);

    int insertSelective(UserT record);

    UserT selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserT record);

    int updateByPrimaryKey(UserT record);
    
    UserT getUserByNameAndPwd(UserT record);
}