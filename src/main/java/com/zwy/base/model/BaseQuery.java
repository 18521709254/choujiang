package com.zwy.base.model;

import com.github.pagehelper.PageInfo;
import lombok.Data;

/**
 * 类 名: BaseQueryDTO
 * 描 述: 基本查询类
 * 作 者: 张强
 * 创 建：2020年01月21日
 * 版 本：v1.0.0
 *
 * 历 史: (版本) 作者 时间 注释
 */
@Data
public abstract class BaseQuery<T> extends BaseBusLongModel {

    /** 分页对象 */
    protected PageInfo<T> pageInfo;
    /** 查询关键字 */
    protected String searchKey;
}
