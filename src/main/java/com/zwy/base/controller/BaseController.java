package com.zwy.base.controller;

import com.zwy.base.model.FileUploadDataDTO;
import com.zwy.base.restfulapi.Result;
import com.zwy.base.restfulapi.Results;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 类 名: BaseController
 * 描 述:
 * 作 者: 宋凯翔
 * 创 建：2020年12月12日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */
@Slf4j
@RestController
@RequestMapping("/api/base")
public class BaseController {

	/** 服务访问地址 */
	@Value("${server.address}")
	public String address;
	/** 服务端口 */
	@Value("${server.port}")
	public String port;

	/**
	 * 描 述： 上传图片
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param uploadFile 上传的文件
	 * @return 小区查询分页数据
	 */
	@SneakyThrows
	@PostMapping("/uploadImage")
	public Result<FileUploadDataDTO> uploadImage(@RequestParam(value = "uploadFile") MultipartFile uploadFile){
		// 创建上传文件实体
		FileUploadDataDTO resultData = new FileUploadDataDTO();
		// 获取类路径
		String uploadDirPath = ResourceUtils.getFile("classpath:").getPath() + File.separator + "upload";
		// 获取上传文件upload的文件
		File uploadDir = FileUtils.getFile(uploadDirPath);
		// 如果不存在创建upload文件夹
		if(!uploadDir.exists()){
			 uploadDir.mkdirs();
		}
		// 文件存储在临时目录上
		String fileName = uploadFile.getOriginalFilename();

		if(StringUtils.isEmpty(fileName)){
			return Results.badRequest("文件名为空",resultData);
		}
		if(!fileName.contains(".")){
			return Results.badRequest("文件格式错误",resultData);
		}
		String date = DateFormatUtils.format(System.currentTimeMillis(),"yyyyMMddHHmmss");
		// 获取文件名后缀
		String fileTypeName = StringUtils.substringAfterLast(fileName,".");
		// 真实的文件名称
		String realName = File.separator + date + "." + fileTypeName;
		// 图片路径
		String realPath = uploadDirPath + realName;
		// 前端展示的路径
		String resultPath = "http://" + address + ":" + port + StringUtils.substringAfter(realPath,"classes");
		resultPath = StringUtils.replace(resultPath,"\\","/");
		// 数据持久化
		File dest = new File(realPath);
		uploadFile.transferTo(dest);
		// 返回数据
		resultData.setFileName(fileName);
		resultData.setFilePath(resultPath);
		return Results.ok(resultData);
	}
}
