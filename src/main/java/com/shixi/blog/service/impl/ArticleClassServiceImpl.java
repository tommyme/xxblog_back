package com.shixi.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shixi.blog.entity.ArticleClass;
import com.shixi.blog.mapper.ArticleClassMapper;
import com.shixi.blog.service.ArticleClassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章分类表 服务实现类
 * </p>
 *
 * @author group
 * @since 2023-02-21
 */
@Service
public class ArticleClassServiceImpl extends ServiceImpl<ArticleClassMapper, ArticleClass> implements ArticleClassService {

    @Autowired
    private ArticleClassMapper articleClassMapper;

    @Override
    public IPage<ArticleClass> getArticleClass(String query, int pageNum, int pageSize) {
        QueryWrapper<ArticleClass> wrapper = new QueryWrapper<>();
        wrapper.like("name",query);
        Page<ArticleClass> page = new Page<>(pageNum, pageSize);
        return articleClassMapper.selectPage(page,wrapper);
    }
//    @Override
//    public boolean updateById(ArticleClass articleClass){
//        int i = articleClassMapper.updateById(articleClass);
//        return i == 1;
//    }
}
