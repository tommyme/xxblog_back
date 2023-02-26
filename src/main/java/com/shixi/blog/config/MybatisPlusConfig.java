package com.shixi.blog.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.sixgroup.cima.mapper.*")
public class MybatisPlusConfig {
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		// 这里就是分页插件的配置了，由于由@Configuration注解，所以是自动注入的，自动应用
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		return paginationInterceptor;
	}
}
