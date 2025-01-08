package com.free.my.fs.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.free.my.fs.common.storage.StorageType;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// fs上传配置资源类
@Setter
@Getter
@ConfigurationProperties(prefix = "fs.files-server")
public class FsServerProperties {
	
	// 上传类型 默认local
	private StorageType type = StorageType.local;
	
	// 本地上传配置
	private LocalProperties local;
	
	// 七牛配置
	private QiniuProperties qiniu;
	
	// oss配置
	private AliyunOssProperties aliyunOss;
	
	// minio配置
	private MinioProperties minio;
	
	@Data
	public static class LocalProperties {
		
		private String directory;
		
		private String endPoint;
		
		private String nginxUrl;
		
	}
	
	@Data
	public static class AliyunOssProperties {
		
		private String accessKey;
		
		private String secretKey;
		
		private String endpoint;
		
		private String bucket;
		
	}
	
	@Data
	public static class QiniuProperties {
		
		private String accessKey;
		
		private String secretKey;
		
		private String bucket;
		
		private String path;
		
	}
	
	@Data
	public static class MinioProperties {
		
		private String accessKey;
		
		private String secretKey;
		
		private String endpoint;
		
		private String bucket;
		
	}

}
