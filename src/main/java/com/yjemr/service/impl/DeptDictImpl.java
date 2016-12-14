package com.yjemr.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yjemr.dao.DeptDictMapper;
import com.yjemr.pojo.DeptDict;
import com.yjemr.service.IDeptDictService;

@Service
public class DeptDictImpl implements IDeptDictService {

	@Resource
	private DeptDictMapper ddm;
	@Override
	public DeptDict selectByPrimaryKey(String deptCode) {
		// TODO Auto-generated method stub
		return ddm.selectByPrimaryKey(deptCode);
	}

}
