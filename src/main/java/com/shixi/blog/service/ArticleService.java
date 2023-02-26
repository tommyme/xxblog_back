package com.shixi.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shixi.blog.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shixi.blog.entity.ArticleClass;

/**
 * <p>
 * 文章表 服务类
 * </p>
 *
 * @author group
 * @since 2023-02-21
 */
public interface ArticleService extends IService<Article> {

    IPage<Article> getArticle(String query, int pageNum, int pageSize);
}
