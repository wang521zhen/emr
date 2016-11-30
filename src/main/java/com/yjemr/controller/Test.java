package com.yjemr.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yjemr.controller.base.BaseController;
import com.yjemr.controller.entity.Response;
import com.yjemr.pojo.UserT;
import com.yjemr.service.IUserService;

@RestController
@RequestMapping("/com/yjemr/controller/Test")
public class Test extends BaseController{
	@Resource
	private IUserService iUserService;
	
	@RequestMapping(value = "/test1" , method = RequestMethod.POST)
	public Response test1(UserT user){
		System.out.println(user.getId());
		UserT userT = iUserService.getUserById(1);
		try {
			Integer.parseInt(userT.getUserName());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getResponse().success(userT);
		System.out.println(2);
		this.logger.info("日志输出");
		return getResponse();
	}
}
