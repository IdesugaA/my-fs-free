package com.free.my.fs.core.service.impl;

import com.free.my.fs.core.domain.Role;
import com.free.my.fs.core.mapper.RoleMapper;
import com.free.my.fs.core.service.RoleService;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;

// 角色表业务实现接口
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>{

	// 根据角色编码获取角色ID
	@Override
	public Long getIdByCode(String code) {
		Role role = this.getOne(new QueryWrapper().where(ROLE.ROLE_CODE.eq(code)));
		if (role == null) {
			return null;
		}
		return role.getId();
	}
	
}
