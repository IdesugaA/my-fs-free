package com.free.my.fs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson2.JSON;
import com.free.my.fs.common.annotation.Preview;
import com.free.my.fs.common.domain.Dtree;
import com.free.my.fs.common.domain.Result;
import com.free.my.fs.core.domain.FileInfo;
import com.free.my.fs.core.domain.dto.UpdateFileNameDTO;
import com.free.my.fs.core.service.FileService;

import cn.dev33.satoken.annotation.SaCheckPermission;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// 文件管理
@Slf4j
@RestController
@RequestMapping("file")
@RequiredArgsConstructor
public class FileController {
	
	private final FileService fileService;
	
	// 获取文件列表
	@GetMapping({"", "/list"})
	public Result<?> getList(FileInfo info) {
		List<FileInfo> list = fileService.getList(info);
		return Result.ok(list, "查询成功");
	}
	
	// 获取树结构列表
	@GetMapping("/getTree")
	public String getTree(FileInfo info) {
		List<Dtree> list = fileService.getTreeList(info);
		return JSON.toJSONString(Result.ok(list, "查询成功"));
	}
	
	// 获取树结构目录列表
	@GetMapping("/getDirTree")
	public String getDirTree(FileInfo info) {
		List<Dtree> list = fileService.getDirTreeList(info);
		return JSON.toJSONString(Result.ok(list, "查询成功"));
	}
	
	// 文件上传
	@Preview()
	@PostMapping({"", "/upload"})
	public Result<?> upload(@RequestParam(value = "file") MultipartFile[] files, String dirIds ) {
		return fileService.upload(files, dirIds);
	}
	
	// 文件分片上传
	@PostMapping("/uploadSharding")
	public Result<?> uploadSharding(@RequestParam(value = "file") MultipartFile[] files, String dirIds, HttpServletRequest request) {
		return fileService.uploadSharding(files, dirIds, request.getSession());
	}
	
	// 获取进度数据
	@GetMapping("/percent")
	public Integer percent(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (session.getAttribute("uploadPercent") == null ? 0 : (Integer) session.getAttribute("uploadPercent"));
	}
	
	// 重置上传进度
	@GetMapping("/percent/reset")
	public void resetPercent(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("uploadPercent", 0);
	}
	
	// 文件下载
	@SaCheckPermission("file:download")
	@GetMapping("/download")
	public void downLoad(String url, HttpServletResponse response) {
		fileService.download(url, response);
	}
	
	// 修改名称
	@PostMapping("/updateByName")
	public Result<?> upload(@Valid @RequestBody UpdateFileNameDTO dto) {
		if (fileService.updateByName(dto)) {
			return Result.ok("修改成功");
		}
		return Result.error("修改失败");
	}
	
	// 移动文件
	@SaCheckPermission("file:move")
	@PostMapping("/move")
	public Result<?> move(String ids, Long parentId) {
		if (fileService.move(ids, parentId)) {
			return Result.ok("移动成功");
		}
		return Result.error("移动失败");
	}
	
	// 根据url删除文件
	@SaCheckPermission("file:delete")
	@PostMapping("/deleteFile")
	public Result<?> deleteFile(String url) {
		if (fileService.delete(url)) {
			return Result.ok("删除成功");
		}
		return Result.error("删除失败");
	}
	
	// 根据id删除文件
	@SaCheckPermission("file:delete")
	@PostMapping("/deleteByIds")
	public Result<?> deleteByIds(Long id) {
		if (fileService.deleteByIds(id)) {
			return Result.ok("删除成功");
		}
		return Result.error("删除失败");
	}
	
	// 新增文件夹
	@SaCheckPermission("dir:add")
	@PostMapping("/addFolder")
	public Result<?> addFolder(FileInfo info) {
		if (fileService.addFolder(info)) {
			return Result.ok("添加成功");
		}
		return Result.error("添加失败");
	}
	
	
	
	

}
