package com.Yan.config.WebMvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 闫宏伟
 * @Description:
 */
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//    @Override
//    //通过此处加载拦截器
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new signinHandlerIntercepter())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/login");
//    }
//}
//class signinHandlerIntercepter implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        Object name = request.getSession().getAttribute("name");
//        if(name == null){
//            request.getRequestDispatcher("/login").forward(request, response);
//            System.out.println("过滤器没有放行");
//            return false;
//        }
//        else {
//            System.out.println("过滤器放行了");
//            return true;
//        }
//    }
//}
