package com.shixi.blog.controller;


import cn.hutool.core.util.BooleanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shixi.blog.common.R;
import com.shixi.blog.entity.Article;
import com.shixi.blog.entity.Comment;
import com.shixi.blog.service.CommentService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 评论表 前端控制器
 * </p>
 *
 * @author group
 * @since 2023-02-21
 */
@RestController
@RequestMapping("/article")
public class CommentController {

    @Autowired
    private CommentService commentService;
    // 查询对应文章评论
    @GetMapping("/getCommentsList/{id}")
    public R getCommentsByArticleId(@PathVariable Long id) {
        List<Comment> commentList = commentService.getCommentsByArticleId(id);
        return R.ok().data("comments",commentList);
    }
    // 修改对应文章评论是否可见
    @GetMapping("/changeIsShow/{id}")
    public R changeIsShow(@PathVariable Long id, @RequestParam boolean isShow) {
        System.out.println("=============="+isShow+"=============");
//        System.out.println(isShow.isShow());
//        System.out.println(b);
//        return R.ok();
        boolean isSuccess = commentService.changeIsShow(id, isShow);
        return isSuccess ? R.ok() : R.error();
    }
    // 添加文章评论
    @PostMapping("/comment")
    public R save(@RequestBody Comment comment){
        boolean save = commentService.save(comment);

        if (save){
            return R.ok();
        }else {
            return R.error();
        }
    }
    // 删除文章评论
    @DeleteMapping("/getCommentsList/{id}")
    public R delete(@PathVariable("id") Long id) {
        boolean isDelete = commentService.removeById(id);
        if (isDelete){
            return R.ok();
        }else {
            return R.error();
        }
    }

}

