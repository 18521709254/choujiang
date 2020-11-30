package com.zwy.base.model;

import lombok.Data;


/**
 * 类 名: FileUploadDataDTO
 * 描 述: 文件上传DTO
 * 作 者: 张文雅
 * 创 建：2020年06月08日
 * 版 本：v1.0.0
 *
 * 历 史: (版本) 作者 时间 注释
 */
@Data
public class FileUploadDataDTO {
    /** 文件名称 */
    private String fileName;
    /** 文件路径 */
    private String filePath;
}
