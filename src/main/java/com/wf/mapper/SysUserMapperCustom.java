package com.wf.mapper;

import com.wf.pojo.SysUser;

import java.util.List;

public interface SysUserMapperCustom {
	
	List<SysUser> queryUserSimplyInfoById(String id);
}