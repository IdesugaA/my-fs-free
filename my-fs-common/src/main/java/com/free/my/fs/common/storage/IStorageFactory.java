package com.free.my.fs.common.storage;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.free.my.fs.common.exception.BusinessException;
import com.free.my.fs.common.properties.FsServerProperties;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// 默认文件上传平台工厂
@Slf4j
@Component
@RequiredArgsConstructor
public class IStorageFactory implements IFileStorageProvider{
	
	private final FsServerProperties serverProperties;
	
	@Override
	public IFileStorage getStorage() {
		StorageType storageType = serverProperties.getType();
			return switch (Objects.requireNonNull(storageType)) {
			case Local -> new LocalStorage(serverProperties.getLocal());
			case minio -> new MinioStorage(serverProperties.getMinio());
			case aliyunOSS -> new AliyunOssStorage(serverProperties.getAliyunOss());
			default -> throw new BusinessException("不支持的存储平台");
		}
	}
	
}
