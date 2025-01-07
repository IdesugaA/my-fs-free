package com.free.my.fs.common.storage;

import org.springframework.web.multipart.MultipartFile;

import com.free.my.fs.common.domain.FileBo;

import jakarta.servlet.http.HttpServletResponse;

// 文件上传接口
public interface IFileStorage {
	
	// 判断存储桶是否存在
	boolean bucketExists(String bucket);
	
	// 创建存储桶
	void makeBucket(String bucket);
	
	// 上传文件
	FileBo upload(MultipartFile file);
	
	// 删除文件
	void delete(String objectName);
	
	// 下载文件
	void download(String objectName, HttpServletResponse response);
	
	// 获取文件访问地址
	String getUrl(String objectName);
	

}
