package com.shixi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.shixi.blog.mapper")
@EnableSwagger2
@EnableWebMvc
public class OurblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(OurblogApplication.class, args);
    }

}
