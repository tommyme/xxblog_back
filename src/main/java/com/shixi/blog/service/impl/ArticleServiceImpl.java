package com.shixi.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shixi.blog.common.R;
import com.shixi.blog.entity.Article;
import com.shixi.blog.entity.ArticleClass;
import com.shixi.blog.mapper.ArticleMapper;
import com.shixi.blog.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author group
 * @since 2023-02-21
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public IPage<Article> getArticle(String query, int pageNum, int pageSize) {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.like("title",query);
        Page<Article> page = new Page<>(pageNum, pageSize);
        return articleMapper.selectPage(page,wrapper);
    }
}
