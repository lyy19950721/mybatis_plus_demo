package com.mipo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname Application
 * @Description TODO
 * @Date 2021/1/20 14:45
 * @Created by li.yy
 */
@SpringBootApplication
@MapperScan("com.mipo.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
