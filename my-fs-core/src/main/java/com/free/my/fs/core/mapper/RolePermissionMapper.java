package com.free.my.fs.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.free.my.fs.core.domain.RolePermission;
import com.mybatisflex.core.BaseMapper;

// 角色权限表mapper接口
public interface RolePermissionMapper extends BaseMapper<RolePermission>{
	
	// 根据角色code码集合查询所有权限标识
	List<String> selectPermissionByRoles(@Param("roleCodes") List<String> roleCodes);

}
