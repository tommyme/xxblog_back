package com.shixi.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shixi.blog.entity.ArticleClass;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 文章分类表 服务类
 * </p>
 *
 * @author group
 * @since 2023-02-21
 */
public interface ArticleClassService extends IService<ArticleClass> {

    IPage<ArticleClass> getArticleClass(String query, int pageNum, int pageSize);
}
