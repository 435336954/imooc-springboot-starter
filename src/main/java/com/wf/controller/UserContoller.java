package com.wf.controller;

import com.wf.pojo.WfJSONResult;
import com.wf.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

//@Controller
@RestController		// @RestController = @Controller + @ResponseBody
@RequestMapping("/user")
public class UserContoller {

	@RequestMapping("/getUser")
//	@ResponseBody
	public User getUser() {
		User u = new User();
		u.setName("wf2");
		u.setAge(18);
		u.setBirthday(new Date());
		u.setPassword("wf2");
		u.setDesc("hello wf2~~");
		
		return u;
	}
	
	@RequestMapping("/getUserJson")
//	@ResponseBody
	public WfJSONResult getUserJson() {
		
		User u = new User();
		u.setName("wf");
		u.setAge(18);
		u.setBirthday(new Date());
		u.setPassword("wf");
		u.setDesc("hello wf~~hello wf~~");
		
		return WfJSONResult.ok(u);
	}
}
