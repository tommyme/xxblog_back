package com.shixi.blog.service;

import com.shixi.blog.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author group
 * @since 2023-02-21
 */
public interface UserService extends IService<User> {

    User getUserByUsername(String username);
}
