package com.wf.controller;

import com.wf.pojo.SysUser;
import com.wf.pojo.WfJSONResult;
import com.wf.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Sid sid;
	
	@RequestMapping("/saveUser")
	public WfJSONResult saveUser() throws Exception {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("wf" + new Date());
		user.setNickname("wf" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.saveUser(user);
		
		return WfJSONResult.ok("保存成功");
	}
	
	@RequestMapping("/updateUser")
	public WfJSONResult updateUser() {
		
		SysUser user = new SysUser();
		user.setId("10011001");
		user.setUsername("10011001-updated" + new Date());
		user.setNickname("10011001-updated" + new Date());
		user.setPassword("10011001-updated");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.updateUser(user);
		
		return WfJSONResult.ok("保存成功");
	}
	
	@RequestMapping("/deleteUser")
	public WfJSONResult deleteUser(String userId) {
		
		userService.deleteUser(userId);
		
		return WfJSONResult.ok("删除成功");
	}
	
	@RequestMapping("/queryUserById")
	public WfJSONResult queryUserById(String userId) {
		
		return WfJSONResult.ok(userService.queryUserById(userId));
	}
	
	@RequestMapping("/queryUserList")
	public WfJSONResult queryUserList() {
		
		SysUser user = new SysUser();
		user.setUsername("wf");
		user.setNickname("lee");
		
		List<SysUser> userList = userService.queryUserList(user);
		
		return WfJSONResult.ok(userList);
	}
	
	@RequestMapping("/queryUserListPaged")
	public WfJSONResult queryUserListPaged(Integer page) {
		
		if (page == null) {
			page = 1;
		}

		int pageSize = 10;
		
		SysUser user = new SysUser();
//		user.setNickname("lee");
		
		List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);
		
		return WfJSONResult.ok(userList);
	}
	
	@RequestMapping("/queryUserByIdCustom")
	public WfJSONResult queryUserByIdCustom(String userId) {
		
		return WfJSONResult.ok(userService.queryUserByIdCustom(userId));
	}
	
	@RequestMapping("/saveUserTransactional")
	public WfJSONResult saveUserTransactional() {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("lee" + new Date());
		user.setNickname("lee" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.saveUserTransactional(user);
		
		return WfJSONResult.ok("保存成功");
	}
}
