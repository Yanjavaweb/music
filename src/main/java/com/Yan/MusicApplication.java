package com.Yan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
热更新，热加载
1、ctrl+shift+a  --->registry，找到registry...，注意带三个点的那个，然后找到compiler.automake.allow.when.app.running就可以
2、按快捷键执行ctrl+F9进行热加载
 */
@SpringBootApplication
@MapperScan("com.Yan.mapper")  //指定加载mapper包的位置
public class MusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicApplication.class, args);
    }

}
