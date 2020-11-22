package com.zwy.community.controller;

import com.github.pagehelper.PageInfo;
import com.zwy.base.model.FileUploadDataDTO;
import com.zwy.base.restfulapi.Result;
import com.zwy.base.restfulapi.Results;
import com.zwy.community.model.Community;
import com.zwy.community.service.CommunityService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * 类 名: CommunityController
 * 描 述: 小区控制层
 * 作 者: 宋凯翔
 * 创 建：2020年10月25日
 * 版 本：v2.2.0
 * 历 史: (版本) 作者 时间 注释
 */

@Slf4j
@RestController
@RequestMapping("/api/community")
public class CommunityController {

	@Resource(name = "communityServiceImpl")
	private CommunityService communityService;

	/**
	 * 描 述： 分页查询小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @return 小区查询数据
	 */
	@PostMapping("/listCommunityByPage")
	public Result<PageInfo<Community>> listCommunityByPage(@RequestBody Community community){
		communityService.listCommunityByPage(community);
		return Results.ok(community.getPageInfo());
	}

	/**
	 * 描 述： 查询全部小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @return 小区查询数据
	 */
	@PostMapping("/listCommunityAll")
	public Result<List<Community>> listCommunityAll(){
		List<Community> communityList = communityService.listCommunityAll();
		return Results.ok(communityList);
	}

	/**
	 * 描 述： 根据ID查询小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param communityId 小区ID
	 * @return 小区数据
	 */
	@PostMapping("/getCommunityById")
	public Result<Community> getCommunityById(@RequestParam(value = "communityId") Long communityId){
		Community item = communityService.getCommunityById(communityId);
		return Results.ok(item);
	}
	
	/**
	 * 描 述： 保存小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param community 小区
	 * @return 小区查询分页数据
	 */
	@PostMapping("/save")
	public Result<Void> save(@RequestBody Community community){
		communityService.save(community);
		return Results.ok("保存成功");
	}

	/**
	 * 描 述： 删除小区
	 * 作 者： 宋凯翔
	 * 历 史： (版本) 作者 时间 注释
	 * @param communityIds 小区ID数组
	 * @return 小区查询分页数据
	 */
	@PostMapping("/delByIds")
	public Result<Void> delByIds(@RequestParam(value = "communityIds") Long[] communityIds){
		communityService.delByIds(communityIds);
		return Results.ok("删除成功");
	}

	/**
	 * 描 述： 上传车位平面图
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
		// 获取文件名后缀
		String fileExt = StringUtils.substringAfterLast(fileName,".");
		if(StringUtils.isEmpty(fileName)){
			return Results.badRequest("文件名为空",resultData);
		}
		if(!fileName.contains(".")){
			return Results.badRequest("文件格式错误",resultData);
		}
		String date = DateFormatUtils.format(System.currentTimeMillis(),"yyyyMMddHHmmss");
		// 图片路径
		String realPath = uploadDirPath + File.separator + date + "." + fileExt;
		// 数据持久化
		File dest = new File(realPath);
		uploadFile.transferTo(dest);
		// 返回数据
		resultData.setFileName(fileName);
		resultData.setFilePath(realPath);
		return Results.ok(resultData);
	}

}
