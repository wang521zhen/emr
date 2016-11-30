package com.yjemr.dao;

import java.util.List;

import com.yjemr.pojo.UserPopedom;
import com.yjemr.pojo.UserPopedomKey;

public interface UserPopedomMapper {
    int deleteByPrimaryKey(UserPopedomKey key);

    int insert(UserPopedom record);

    int insertSelective(UserPopedom record);

    List<UserPopedom> selectByPrimaryKey(UserPopedomKey key);

    int updateByPrimaryKeySelective(UserPopedom record);

    int updateByPrimaryKey(UserPopedom record);
}