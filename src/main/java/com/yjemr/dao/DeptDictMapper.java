package com.yjemr.dao;

import com.yjemr.pojo.DeptDict;

public interface DeptDictMapper {
    int deleteByPrimaryKey(String deptCode);

    int insert(DeptDict record);

    int insertSelective(DeptDict record);

    DeptDict selectByPrimaryKey(String deptCode);

    int updateByPrimaryKeySelective(DeptDict record);

    int updateByPrimaryKey(DeptDict record);
}