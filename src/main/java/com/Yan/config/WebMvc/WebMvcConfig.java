package com.Yan.config.WebMvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created with IntelliJ IDEA.
 *解决跨越问题
 * @Description:
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  //所有目录都可以跨域访问
                .allowedOrigins("*")  //允许所有来源可以跨域访问
                .allowedMethods("*")  //允许所有方法可以访问
                .allowCredentials(true);  //访问时需要验证？
    }
}
