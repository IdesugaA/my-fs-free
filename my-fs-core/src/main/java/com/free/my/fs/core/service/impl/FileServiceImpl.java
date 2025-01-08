package com.free.my.fs.core.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.free.my.fs.common.constant.CommonConstant;
import com.free.my.fs.common.storage.IFileStorageProvider;
import com.free.my.fs.core.domain.FileInfo;
import com.free.my.fs.core.mapper.FileMapper;
import com.free.my.fs.core.service.FileService;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;

import cn.dev33.satoken.stp.StpUtil;
import lombok.RequiredArgsConstructor;

import static com.free.my.fs.core.domain.table.FileInfoTableDef.FILE_INFO;
import static com.mybatisflex.core.query.QueryMethods.noCondition;

/**
 *  required...注解可以简化@Autowired的书写过程
 *  比如说在编写Controller层或Service层时，需要注入众多的mapper接口或service接口
 *  此时就可以代替autowired
 *  但注意，此时需要注入的类必须使用final进行声明
 */


//extends ServiceImpl<FileMapper, FileInfo> implements FileService
@Service
@RequiredArgsConstructor
public class FileServiceImpl {

	private final IFileStorageProvider uploaderProvider;
	
	//@Override
	public List<FileInfo> getList(FileInfo info) {
		String dirIds = info.getDirIds();
		if (StringUtils.isNotEmpty(dirIds)) {
			dirIds = dirIds.substring(dirIds.lastIndexOf(CommonConstant.DIR_SPLIT)+1);
		}
		QueryWrapper queryWrapper = QueryWrapper.create()
				.select()
				.from(FILE_INFO)
				.where(FILE_INFO.USER_ID.eq(StpUtil.getLoginIdAsLong()))
				.and(FILE_INFO.PARENT_ID.eq(StringUtils.isEmpty(dirIds) ? CommonConstant.ROOT_PARENT_ID : Long.parseLong(dirIds)))
				.orderBy(FILE_INFO.IS_DIR.desc(), FILE_INFO.PUT_TIME.desc());
		//return this.list(queryWrapper);
		return null;	
				
			
	}
	
}
