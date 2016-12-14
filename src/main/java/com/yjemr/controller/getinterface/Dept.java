package com.yjemr.controller.getinterface;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjemr.controller.base.BaseController;
import com.yjemr.controller.entity.Response;
import com.yjemr.pojo.DeptDict;
import com.yjemr.pojo.UserXRoleKey;
import com.yjemr.service.IDeptDictService;
import com.yjemr.util.Const;

@RestController
@RequestMapping("/getinterface/Dept")
public class Dept extends BaseController {

	@Resource
	private IDeptDictService idds;
	/**
	 * 根据 code集合获取科室信息 注：如果没有对应集合就取session里面的科室集合替代
	 * @param deptCodes
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/getDeptByCode")
	public Response getDeptByCode(String[] deptCodes){
		List<DeptDict> deptList = new ArrayList<DeptDict>();
		if (deptCodes == null || deptCodes.length == 0){
			List<UserXRoleKey> userXList = (List<UserXRoleKey>)this.getRequest().
					getSession().getAttribute(Const.USER_X_ROLE_LIST);
			if (userXList != null){
				for (UserXRoleKey uxr:userXList){
					DeptDict dd = idds.selectByPrimaryKey(uxr.getDeptCode());
					if (dd != null)
						deptList.add(dd);
				}
			}
		}else if (deptCodes != null){
			for (int i=0;i<deptCodes.length;i++){
				DeptDict dd = idds.selectByPrimaryKey(deptCodes[i]);
				if (dd != null)
					deptList.add(dd);
			}
		}
		return this.getResponse().success(deptList);
	}
	
}
