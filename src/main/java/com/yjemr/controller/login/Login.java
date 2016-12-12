package com.yjemr.controller.login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yjemr.controller.base.BaseController;
import com.yjemr.controller.entity.Response;
import com.yjemr.pojo.UserInfo;
import com.yjemr.pojo.UserPopedom;
import com.yjemr.pojo.UserPopedomKey;
import com.yjemr.pojo.UserXRoleKey;
import com.yjemr.service.IUserInfoService;
import com.yjemr.service.IUserPopedomService;
import com.yjemr.service.IUserXRoleKeyService;
import com.yjemr.util.Const;
import com.yjemr.util.MD5;
import com.yjemr.util.StringUtil;

@RestController
public class Login extends BaseController {

	@Resource
	private IUserInfoService iUserInfoService;
	@Resource
	private IUserPopedomService iUserPopedomS;
	@Resource
	private IUserXRoleKeyService iUserXRoleKeyS;
	
	/**
	 * 请求重定向登录页面
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/login_toLogin")
	public Response loginToLogin(){
		System.out.println("/login_toLogin");
		return this.getResponse().failure(Const.LOGIN);
	}
	
	/**
	 * 请求登录，验证用户信息
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/login_Login" , method = RequestMethod.POST)
	public Response loginLogin(UserInfo record){
		String userId = record.getUserId();
		String password = record.getPassword();
		if (StringUtil.isNotNull(userId)){
			password = MD5.md5(password);//MD5加密
			UserInfo userInfoNew = iUserInfoService.getUserInfoByUserIdAndPassword(userId, password);
			
			//校验账号是否可用后续再加
			UserPopedomKey userP = new UserPopedomKey();
			userP.setUserId(userId);
			List<UserPopedom> userPNew = iUserPopedomS.selectByPrimaryKey(userP);
			UserXRoleKey userX = new UserXRoleKey();
			userX.setUserId(userId);
			List<UserXRoleKey> userXList = iUserXRoleKeyS.selectByAll(userX);
			
			if (userInfoNew == null)
				return this.getResponse().failure("账号密码错误！");
			if (userPNew == null || userPNew.size() == 0)
				return this.getResponse().failure("没有科室权限，请联系管理员维护！");
			if (userXList == null || userXList.size() == 0)
				return this.getResponse().failure("没有相关功能权限，请联系管理员维护！");
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(Const.USER_INFO, userInfoNew);
			map.put(Const.USER_POPEDOM_LIST, userPNew);
			map.put(Const.USER_X_ROLE_LIST, userXList);
			this.getRequest().getSession().setAttribute(Const.USER_INFO, userInfoNew);
			this.getRequest().getSession().setAttribute(Const.USER_POPEDOM_LIST, userPNew);
			this.getRequest().getSession().setAttribute(Const.USER_X_ROLE_LIST, userXList);
			return this.getResponse().success(map);
		}
		return this.getResponse().failure();
	}
	
}
