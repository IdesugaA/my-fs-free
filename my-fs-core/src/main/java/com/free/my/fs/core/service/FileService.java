package com.free.my.fs.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.free.my.fs.common.domain.Dtree;
import com.free.my.fs.common.domain.Result;
import com.free.my.fs.core.domain.FileInfo;
import com.free.my.fs.core.domain.dto.UpdateFileNameDTO;
import com.mybatisflex.core.service.IService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public interface FileService extends IService<FileInfo>{
	
	// 获取文件列表
	List<FileInfo> getList(FileInfo info);
	
	// 获取文件树结构列表
	List<Dtree> getTreeList(FileInfo info);
	
	// 获取目录树结构列表
	List<Dtree> getDirTreeList(FileInfo info);
	
	// 上传文件
	Result upload(MultipartFile[] files, String dirIds);
	
	// 分片上传大文件
	Result uploadSharding(MultipartFile[] files, String dirIds, HttpSession session);
	
	// 删除文件
	boolean delete(String url);
	
	// 下载文件
	void download(String url, HttpServletResponse response);
	
	// 新建文件夹
	boolean addFolder(FileInfo fileInfo);
	
	// 重命名
	boolean updateByName(UpdateFileNameDTO dto);
	
	// 根据id集合批量删除
	boolean deleteByIds(Long id);
	
	// 移动文件
	boolean move(String ids, Long parentId);
	
	// 根据id拼接父目录
	Map<String, Object> getDirs(Long id);

}
