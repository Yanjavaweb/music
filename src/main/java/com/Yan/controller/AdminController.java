package com.Yan.controller;

import com.Yan.service.AdminService;
import com.Yan.utils.Consts.ConstsUtils;
import com.Yan.utils.Status.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/adminController")
@Api(tags = "adminController", description = "用户管理")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/loginStatus")
    @ApiOperation("用来处理用户登录的")
    public Object loginStatus(HttpServletRequest request, HttpSession session){
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        boolean flag = adminService.verifyPassword(name, password);
        if(flag){
            session.setAttribute(ConstsUtils.NAME,name);
            return AjaxResult.success("登录成功");
        }
        return AjaxResult.error("输入用户名或者密码错误");
    }
}




















