package com.free.my.fs.core.service.impl;

import java.util.List;

import com.free.my.fs.core.domain.RolePermission;
import com.free.my.fs.core.mapper.RolePermissionMapper;
import com.free.my.fs.core.service.RolePermissionService;
import com.free.my.fs.core.service.UserRoleService;
import com.mybatisflex.spring.service.impl.ServiceImpl;

import cn.dev33.satoken.stp.StpInterface;


// implements RolePermissionService
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService, StpInterfacen{

	private final UserRoleService userRoleService;
	
	@Override
	public List<String> getPermissionList(Object loginId, String loginType) {
		List<String> roleCodes = getRoleList(loginId, loginType);
		return mapper.selectPermissionByRoles(roleCodes);
	}
	
	@Override
	public List<String> getRoleList(Object loginId, String loginType) {
		return userRoleService.getRoleByUserId(Long.parseLong(String.valueOf(loginId)));
	}
	
}
