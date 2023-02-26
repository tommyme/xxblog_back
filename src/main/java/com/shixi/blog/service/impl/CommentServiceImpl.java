package com.shixi.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shixi.blog.entity.Comment;
import com.shixi.blog.mapper.CommentMapper;
import com.shixi.blog.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author group
 * @since 2023-02-21
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<Comment> getCommentsByArticleId(Long id) {
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("article_id",id);
        return commentMapper.selectList(wrapper);
    }

    @Override
    public boolean changeIsShow(Long id,Boolean isShow) {
        int i = commentMapper.updateById(commentMapper.selectById(id).setIsShow(isShow));
        return i == 1;
    }
}
