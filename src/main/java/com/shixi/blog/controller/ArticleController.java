package com.shixi.blog.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shixi.blog.common.R;
import com.shixi.blog.entity.Article;
import com.shixi.blog.entity.ArticleClass;
import com.shixi.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 文章表 前端控制器
 * </p>
 *
 * @author group
 * @since 2023-02-21
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    // 浏览所有文章或搜索文章
    @GetMapping("/list")
    public R getArticlePage(@RequestParam(defaultValue = "1") int pageNum,
                                 @RequestParam(defaultValue = "") String query,
                                 @RequestParam(defaultValue = "10") int pageSize) {
        IPage<Article> articlePage = articleService.getArticle(query,pageNum, pageSize);
        return R.ok().data("articles",articlePage);
    }
    // 查询具体文章
    @GetMapping("/list/{id}")
    public R query(@PathVariable("id") String id) {
        long articleClassId = Long.parseLong(id);
        Article byId = articleService.getById(articleClassId);
        return R.ok().data("article",byId);
    }
    // 修改文章
    @PutMapping("/list/{id}/{classId}")
    public R update(@PathVariable("id") String id,@PathVariable("classId") String classId,@RequestBody Article article) {
        boolean isSuccess = articleService.updateById(article);
        if (isSuccess){
            return R.ok();
        }else {
            return R.error();
        }
    }
    // 添加文章
    @PostMapping("/list/{classId}")
    public R save(@PathVariable("classId") String Id,@RequestBody Article addForm){
        boolean save = articleService.save(addForm);

        if (save){
            return R.ok();
        }else {
            return R.error();
        }
    }

    // 删除文章
    @DeleteMapping("/list/{id}")
    public R delete(@PathVariable("id") String id) {
        boolean isDelete = articleService.removeById(Long.parseLong(id));
        if (isDelete){
            return R.ok();
        }else {
            return R.error();
        }
    }

}

