package com.free.my.fs.common.storage.platform;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

import com.free.my.fs.common.constant.CommonConstant;
import com.free.my.fs.common.domain.FileBo;
import com.free.my.fs.common.exception.BusinessException;
import com.free.my.fs.common.properties.FsServerProperties;
import com.free.my.fs.common.storage.IFileStorage;
import com.free.my.fs.common.utils.ResponseUtil;
import com.mybatisflex.core.util.StringUtil;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

// 本地文件上传
@Slf4j
public class LocalStorage implements IFileStorage {

	private final String directory;
	
	private final String endPoint;
	
	private final String nginxUrl;
	
	public LocalStorage(FsServerProperties.LocalProperties config) {
		try {
			String directory = config.getDirectory();
			String endPoint = config.getEndPoint();
			String nginxUrl = config.getNginxUrl();
			this.directory = directory;
			this.endPoint = endPoint;
			this.nginxUrl = nginxUrl;
		} catch (Exception e) {
			log.error("[Local] LocalStorage build failed: {}", e.getMessage());
			throw new BusinessException("请检查本地存储配置是否正确");
		}
	}
	
	// 本地文件的桶就是文件
	@Override
	public boolean bucketExists(String directory) {
		File file = new File(directory);
		return file.exists();
	}
	
	@Override
	public void makeBucket(String directory) {
		try {
			if (!bucketExists(directory)) {
				File file = new File(directory);
				file.mkdirs();
			}
		} catch (Exception e) {
			log.error("[Local] makeBucket Exception: {}", e.getMessage());
			throw new BusinessException("创建存储桶失败");
		}
	}
	
	@Override
	public FileBo upload(MultipartFile file) {
		makeBucket(directory);
		FileBo fileBo = FileBo.build(file);
		try {
			Path targetLocation = Paths.get(directory).resolve(Paths.get(fileBo.getFileName()));
			file.transferTo(targetLocation);
			String url = getUrl(fileBo.getFileName());
			fileBo.setUrl(url);
			return fileBo;
		} catch (IOException e) {
			log.error("[Local] file upload failed: {}", e.getMessage());
			throw new BusinessException("文件上传失败");
		}
	}
	
	@Override
	public void delete(String objectName) {
		if (objectName == null || objectName.length() == 0) {
			throw new BusinessException("文件删除失败，文件路径为空");
		}
		try {
			Path file = Paths.get(directory).resolve(Paths.get(objectName));
			Files.delete(file);
		} catch (Exception e) {
			log.error("[Local] file delete failed: {}", e.getMessage());
			throw new BusinessException("文件删除失败");
		}
	}
	
	@Override
	public void download(String objectName, HttpServletResponse response) {
		if (objectName == null || objectName.length() == 0) {
			throw new BusinessException("文件下载失败，文件路径为空");
		}
		try {
			Path file = Paths.get(directory).resolve(Paths.get(objectName));
			InputStream is = Files.newInputStream(file);
			ResponseUtil.write(is, objectName, response);
			log.info("[Local] file download success, object:{}", objectName);
		} catch (Exception e) {
			log.error("[Local] file download failed: {}", e.getMessage());
			throw new BusinessException("文件下载失败");
		}
	}
	
	@Override
	public String getUrl(String objectName) {
		// 如果配置了nginxUrl则使用nginxUrl
		if (StringUtil.isNotBlank(nginxUrl)) {
			if (nginxUrl.endsWith("/")) {
				return nginxUrl + objectName;
			}
			return nginxUrl + "/" + objectName;
		}
		// 否则使用endpoint，一般是一般是http://本机ip:本机port/mapping/fileName
		return endPoint + CommonConstant.LOCAL_DIRECTORY_MAPPING + objectName;
	}
	
}
