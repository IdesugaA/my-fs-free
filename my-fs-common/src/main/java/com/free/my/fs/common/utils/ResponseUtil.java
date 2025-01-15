package com.free.my.fs.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import cn.hutool.core.io.IoUtil;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class ResponseUtil {

	// 导出文件流
	public static void write(InputStream is, String objectName, HttpServletResponse response) throws IOException {
		ServletOutputStream outputStream = response.getOutputStream();
		// 设置文件Content-Type类型，这样设置会自动判断下载文件类型
		response.setContentType("application/x-msdownload");
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(objectName, StandardCharsets.UTF_8));
		IoUtil.copy(is, outputStream);
		response.flushBuffer();
		IoUtil.close(outputStream);
		IoUtil.close(is);
	}
	
}
