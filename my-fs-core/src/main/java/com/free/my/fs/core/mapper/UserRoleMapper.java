package com.free.my.fs.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.free.my.fs.core.domain.UserRole;
import com.mybatisflex.core.BaseMapper;

// 用户角色表mapper接口
public interface UserRoleMapper extends BaseMapper<UserRole>{
	
	// 根据用户id查询角色code码集合
	List<String> selectRoleByUserId(@Param("userId") Long userId);
	
}
