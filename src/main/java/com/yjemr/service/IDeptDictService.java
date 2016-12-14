package com.yjemr.service;

import com.yjemr.pojo.DeptDict;

public interface IDeptDictService {
	public DeptDict selectByPrimaryKey(String deptCode);
}
