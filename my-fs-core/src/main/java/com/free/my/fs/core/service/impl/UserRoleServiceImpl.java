package com.free.my.fs.core.service.impl;

import java.util.List;

import com.free.my.fs.core.domain.UserRole;
import com.free.my.fs.core.mapper.UserRoleMapper;
import com.free.my.fs.core.service.UserRoleService;
import com.mybatisflex.spring.service.impl.ServiceImpl;

// implements UserRoleService
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService{

	// 根据角色ID获取角色编码
	@Override
	public List<String> getRoleByUserId(Long userId) {
		return mapper.selectRoleByUserId(userId);
	}
	
}
