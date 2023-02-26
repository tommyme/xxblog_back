package com.shixi.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shixi.blog.common.R;
import com.shixi.blog.entity.ArticleClass;
import com.shixi.blog.service.ArticleClassService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 文章分类表 前端控制器
 * </p>
 *
 * @author group
 * @since 2023-02-21
 */
@RestController
@RequestMapping("/article")
public class ArticleClassController {
    @Autowired
    private ArticleClassService articleClassService;

    // 浏览所有分类或搜索分类
    @GetMapping("/class")
    public R getArticleClassPage(@RequestParam(defaultValue = "1") int pageNum,
                                 @RequestParam(defaultValue = "") String query,
                                 @RequestParam(defaultValue = "10") int pageSize) {
        IPage<ArticleClass> articleClassPage = articleClassService.getArticleClass(query,pageNum, pageSize);
        return R.ok().data("classes",articleClassPage);
    }
    // 查询具体分类
    @GetMapping("/class/{id}")
    public R query(@PathVariable("id") String id) {
        long articleClassId = Long.parseLong(id);
        ArticleClass byId = articleClassService.getById(articleClassId);
        return R.ok().data("class",byId);
    }
    // 修改分类名
    @PutMapping("/class/{id}")
    public R update(@PathVariable("id") String id,@RequestBody ArticleClass articleClass) {
        boolean isSuccess = articleClassService.updateById(articleClass);
        if (isSuccess){
            return R.ok();
        }else {
            return R.error();
        }
    }
    // 删除文章分类
    @DeleteMapping("/class/{id}")
    public R delete(@PathVariable("id") String id) {
        boolean isDelete = articleClassService.removeById(Long.parseLong(id));
        if (isDelete){
            return R.ok();
        }else {
            return R.error();
        }
    }

    // 添加文章分类
    @PostMapping("/class")
    public R save(@RequestBody ArticleClass addForm){
        boolean save = articleClassService.save(addForm);
        if (save){
            return R.ok();
        }else {
            return R.error();
        }
    }
}

