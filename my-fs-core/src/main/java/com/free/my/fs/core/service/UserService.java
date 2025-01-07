package com.free.my.fs.core.service;

import com.free.my.fs.core.domain.User;
import com.free.my.fs.core.domain.dto.LoginBody;
import com.free.my.fs.core.domain.dto.UpdatePasswordDTO;
import com.free.my.fs.core.domain.dto.UserDTO;
import com.mybatisflex.core.service.IService;

public interface UserService extends IService<User>{
	
	// 登录
	boolean doLogin(LoginBody body);
	
	// 新增用户
	boolean addUser(UserDTO dto);
	
	// 修改密码
	boolean updatePassword(UpdatePasswordDTO dto);

}
