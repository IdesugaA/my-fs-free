package com.free.my.fs.core.service;

import java.util.List;

import com.free.my.fs.core.domain.UserRole;
import com.mybatisflex.core.service.IService;

public interface UserRoleService extends IService<UserRole>{
	
	List<String> getRoleByUserId(Long userId);

}
