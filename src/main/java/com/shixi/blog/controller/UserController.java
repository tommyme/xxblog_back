package com.shixi.blog.controller;


import com.shixi.blog.common.R;
import com.shixi.blog.entity.User;
import com.shixi.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author group
 * @since 2023-02-21
 */
@RestController
@RequestMapping("")
//@CrossOrigin(origins = "*",maxAge = 3600)
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public R login(@RequestBody User loginForm) {
        User admin = userService.getUserByUsername(loginForm.getUsername());
        if (admin == null || !admin.getPassword().equals(loginForm.getPassword())) {
            // 用户名或密码错误，返回登录失败的结果
            return R.error();
        } else {
            // 登录成功，返回登录成功的结果
            return R.ok();
        }
    }
}

