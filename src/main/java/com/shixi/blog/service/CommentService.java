package com.shixi.blog.service;

import com.shixi.blog.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 评论表 服务类
 * </p>
 *
 * @author group
 * @since 2023-02-21
 */
public interface CommentService extends IService<Comment> {

    List<Comment> getCommentsByArticleId(Long id);


    boolean changeIsShow(Long id,Boolean isShow);
}
