package com.free.my.fs.core.service;

import com.free.my.fs.core.domain.Role;
import com.mybatisflex.core.service.IService;

// 角色表业务接口
public interface RoleService extends IService<Role>{
	
	// 根据角色编码获取角色Id
	Long getIdByCode(String code);

}
