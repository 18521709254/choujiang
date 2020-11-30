package com.zwy.base.restfulapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * 类 名: Result
 * 描 述: 通用响应
 * 作 者: 张文雅
 * 创 建：2020年1月15日
 * 版 本：v1.0.0
 *
 * 历 史: (版本) 作者 时间 注释
 */
public class Result<T> extends ResponseEntity<ApiResponse<T>> {

    /**
     * 描 述： 通用响应方法
     * 作 者： 张文雅
     * 历 史： (版本) 作者 时间 注释
     * @param body 响应体
     * @param status 响应状态
     */
    Result(ApiResponse<T> body, HttpStatus status) {
        super(body, status);
    }
}
