package com.free.my.fs.common.constant;

// 全局公共常量
public interface CommonConstant {
	
	// 路径目录分隔符
	String DIR_SPLIT = "/";
	
	// 字符串分隔符
	String STRING_SPLIT = ",";
	
	// 后缀分隔符
	String SUFFIX_SPLIT = ".";
	
	// 目录默认类型
	String DEFAULT_DIR_TYPE = "dir";
	
	// 默认管理员角色code
	String ROLE_ADMIN = "admin";
	
	// 默认普通角色code
	String ROLE_USER = "user";
	
	// 默认树顶级id
	Long ROOT_PARENT_ID = -1L;
	
	// dtree指定图标
	String DTREE_ICON_1 = "dtree-icon-weibiaoti5";
	
	// dtree指定图标
	String DTREE_ICON_2 = "dtree-icon-normal-file";
	
	String X_REQUESTED_WITH = "X-Requested-With";
	
	String XML_HTTP_REQUEST = "XMLHttpRequest";
	
	// 存储类型-本地
	String FILE_TYPE_LOCAL = "local";
	
	// 云存储类型-oss
	String FILE_TYPE_OSS = "oss";
	
	// 云存储类型-七牛
	String FILE_TYPE_QINIU = "qiniu";
	
	// 云存储类型-Minio
	String FILE_TYPE_MINIO = "minio";
	
	// 本地目录映射
	String LOCAL_DIRECTORY_MAPPING = "/uploads/";
	
	// 需要租户过滤的字段
	String STORAGE_TENANT_COLUMN = "source";
	
	

}
