package com.Yan.controller;

import com.Yan.entity.Consumer;
import com.Yan.service.ConsumerService;
import com.Yan.utils.Status.AjaxResult;
import com.sun.org.apache.regexp.internal.RE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *前台用户controller
 * @Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/consumerController")
@Api(tags = "singerController", description = "前台用户管理")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @ApiOperation("添加前台用户")
    @PostMapping(value = "/add")
    public Object addConsumer(HttpServletRequest request){
        String username=request.getParameter("username").trim();
        String password=request.getParameter("password").trim();
        String sex=request.getParameter("sex").trim();
        String phoneNum=request.getParameter("phoneNum").trim();
        String email=request.getParameter("email").trim();
        String birth=request.getParameter("birth").trim();
        String introduction=request.getParameter("introduction").trim();
        String location=request.getParameter("location").trim();
        String avator=request.getParameter("avator").trim();

        if(username==null || username.equals("")){
            return AjaxResult.error("用户名不能为空");
        }
        if(password==null || password.equals("")){
            return AjaxResult.error("密码不能为空");
        }

        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date dateBirth=new Date();
        try {
            dateBirth=dateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Consumer consumer=new Consumer();
        consumer.setUsername(username);
        consumer.setPassword(password);
        consumer.setSex(new Byte(sex));
        consumer.setPhoneNum(phoneNum);
        consumer.setEmail(email);
        consumer.setBirth(dateBirth);
        consumer.setIntroduction(introduction);
        consumer.setLocation(location);
        consumer.setAvator(avator);
        boolean flag = consumerService.insert(consumer);
        if(flag){
            return AjaxResult.success("添加前台用户成功",consumer);
        }
        return AjaxResult.error("添加前台用户失败");
    }

    @ApiOperation("修改前台用户")
    @PostMapping(value = "/update")
    public Object update(HttpServletRequest request){
        String id=request.getParameter("id").trim();
        String username=request.getParameter("username").trim();
        String password=request.getParameter("password").trim();
        String sex=request.getParameter("sex").trim();
        String phoneNum=request.getParameter("phoneNum").trim();
        String email=request.getParameter("email").trim();
        String birth=request.getParameter("birth").trim();
        String introduction=request.getParameter("introduction").trim();
        String location=request.getParameter("location").trim();

        Consumer consumer1 = consumerService.consumerOfName(username);
        if(username==null || username.equals("")){
            return AjaxResult.error("用户名不能为空");
        }
        if(consumer1!=null){
            return AjaxResult.error("用户名已存在");
        }
        if(password==null || password.equals("")){
            return AjaxResult.error("密码不能为空");
        }

        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date dateBirth=new Date();
        try {
            dateBirth=dateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Consumer consumer=new Consumer();
        consumer.setId(Integer.parseInt(id));
        consumer.setUsername(username);
        consumer.setPassword(password);
        consumer.setSex(new Byte(sex));
        consumer.setPhoneNum(phoneNum);
        consumer.setEmail(email);
        consumer.setBirth(dateBirth);
        consumer.setIntroduction(introduction);
        consumer.setLocation(location);
        boolean flag = consumerService.update(consumer);
        if(flag){
            return AjaxResult.success("添加前台用户成功",consumer);
        }
        return AjaxResult.error("添加前台用户失败");
    }
    @ApiOperation("删除前台用户")
    @GetMapping(value = "/delete")
    public Object delete(HttpServletRequest request){
        String id=request.getParameter("id").trim();
        Consumer consumer = consumerService.selectById(Integer.parseInt(id));
        String filePath=System.getProperty("user.dir");
        File file=new File(filePath+System.getProperty("file.separator")+consumer.getAvator());
        if(file.exists())
            file.delete();
        boolean flag = consumerService.delete(Integer.parseInt(id));
        if(flag){
            return AjaxResult.success("删除前台用户成功");
        }
        return AjaxResult.error("删除前台用户失败");
    }
    @ApiOperation("根据id查询前台用户")
    @GetMapping(value = "/selectById")
    public Object selectById(HttpServletRequest request){
        String id=request.getParameter("id").trim();
        Consumer consumer = consumerService.selectById(Integer.parseInt(id));
        if(consumer!=null){
            return AjaxResult.success("根据id查询前台用户成功",consumer);
        }
        return AjaxResult.error("根据id查询前台用户失败");
    }
    @ApiOperation("查询所有前台用户")
    @GetMapping(value = "/AllConsumer")
    public Object AllConsumer(){
        List<Consumer> consumerList = consumerService.AllConsumer();
        if(consumerList!=null){
            return AjaxResult.success("查询所有前台用户成功",consumerList);
        }
        return AjaxResult.error("查询所有前台用户失败");
    }
//    @ApiOperation("根据前台用户名模糊查询")
//    @GetMapping(value = "/consumerOfName")
//    public Object consumerOfName(HttpServletRequest request){
//        String username=request.getParameter("username").trim();
//        List<Consumer> consumerList = consumerService.consumerOfName(username);
//        if(consumerList!=null){
//            return AjaxResult.success("根据前台用户名模糊查询成功",consumerList);
//        }
//        return AjaxResult.error("根据前台用户名模糊查询失败");
//    }
//    @ApiOperation("根据前台用户性别查询")
//    @GetMapping(value = "/consumerOfSex")
//    public Object consumerOfSex(HttpServletRequest request){
//        String sex=request.getParameter("sex").trim();
//        List<Consumer> consumerList = consumerService.consumerOfSex(Integer.parseInt(sex));
//        if(consumerList!=null){
//            return AjaxResult.success("根据前台用户性别查询成功",consumerList);
//        }
//        return AjaxResult.error("根据前台用户性别查询失败");
//    }

    @ApiOperation("更新歌曲头像")
    @PostMapping(value = "/updateConsumerPic")
    public Object updateConsumerPic(@RequestParam("file") MultipartFile multipartFile, @RequestParam("id") Integer id){
        if(multipartFile.isEmpty()){
            return AjaxResult.error("上传文件失败");
        }
        /*文件名=当前时间的毫秒值+原文件名*/
        String fileName=System.currentTimeMillis()+multipartFile.getOriginalFilename();
        /*文件路径*/
        String filePath=System.getProperty("user.dir")+System.getProperty("file.separator")+"avatorImages";
        File file1=new File(filePath);
        if(!file1.exists()){  //如果文件路径不存在，创建路径
            file1.mkdirs();
        }
        //实际的文件地址
        File dest=new File(filePath+System.getProperty("file.separator")+fileName);
        //相对的文件地址
        String storeAvatorPath="/avatorImages/"+fileName;
        try {
            multipartFile.transferTo(dest);
            Consumer consumer=new Consumer();
            consumer.setId(id);
            consumer.setAvator(storeAvatorPath);
            boolean flag = consumerService.update(consumer);
            if(flag){
                return AjaxResult.success("上传成功",storeAvatorPath);
            }
            return AjaxResult.error("上传失败");
        } catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }
    @ApiOperation("验证前台用户登录")
    @PostMapping(value = "/login")
    public Object login(HttpServletRequest request) {
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        if (username == null || username.equals("")) {
            return AjaxResult.error("用户名不能为空");
        }
        if (password == null || password.equals("")) {
            return AjaxResult.error("密码不能为空");
        }
        Consumer consumer =consumerService.consumerOfName(username);
        boolean flag = consumerService.verifyPassword(username,password);
        if (flag) {
            return AjaxResult.success("前台用户登录成功", consumer);
        }
        return AjaxResult.error("前台用户登录失败");
    }
}
