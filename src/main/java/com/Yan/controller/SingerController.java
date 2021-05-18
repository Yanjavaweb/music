package com.Yan.controller;

import com.Yan.entity.Singer;
import com.Yan.service.SingerService;
import com.Yan.utils.Status.AjaxResult;
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
 *歌手controller
 * @Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/singerController")
@Api(tags = "singerController", description = "歌手管理")
public class SingerController {

    @Autowired
    private SingerService singerService;

    @ApiOperation("添加歌手")
    @PostMapping(value = "/add")
    public Object addSinger(HttpServletRequest request){
        String name=request.getParameter("name").trim();
        String sex=request.getParameter("sex").trim();
        String pic=request.getParameter("pic").trim();
        String birth=request.getParameter("birth").trim();
        String location=request.getParameter("location").trim();
        String introduction=request.getParameter("introduction").trim();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate=new Date();
        try {
            birthDate=dateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Singer singer=new Singer();
        singer.setName(name);
        singer.setSex(new Byte(sex));
        singer.setPic(pic);
        singer.setBirth(birthDate);
        singer.setLocation(location);
        singer.setIntroduction(introduction);
        boolean flag=singerService.insert(singer);
        if(flag){
            return AjaxResult.success("添加歌手成功");
        }
        return AjaxResult.error("添加歌手失败");
    }

    @ApiOperation("修改歌手")
    @PostMapping(value = "/update")
    public Object updateSinger(HttpServletRequest request){
        String id=request.getParameter("id").trim();
        String name=request.getParameter("name").trim();
        String sex=request.getParameter("sex").trim();
        //String pic=request.getParameter("pic").trim();
        String birth=request.getParameter("birth").trim();
        String location=request.getParameter("location").trim();
        String introduction=request.getParameter("introduction").trim();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate=new Date();
        try {
            birthDate=dateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Singer singer=new Singer();
        singer.setId(Integer.parseInt(id));
        singer.setName(name);
        singer.setSex(new Byte(sex));
       // singer.setPic(pic);
        singer.setBirth(birthDate);
        singer.setLocation(location);
        singer.setIntroduction(introduction);
        boolean flag=singerService.update(singer);
        if(flag){
            return AjaxResult.success("修改歌手成功");
        }
        return AjaxResult.error("修改歌手失败");
    }

    @GetMapping(value = "/delete")
    @ApiOperation("删除歌手")
    public Object deleteSinger(HttpServletRequest request){
        String id=request.getParameter("id").trim();
        Singer singer=singerService.selectById(Integer.parseInt(id));
        /*文件路径*/
        String filePath=System.getProperty("user.dir");
        File file1=new File(filePath+System.getProperty("file.separator")+singer.getPic());
        if(file1.exists()){  //如果文件路径不存在，创建路径
            file1.delete();
        }
        boolean flag=singerService.delete(Integer.parseInt(id));
        if(flag){
            return AjaxResult.success("删除歌手成功");
        }
        return AjaxResult.error("删除歌手失败");
    }

    @ApiOperation("根据id查询歌手")
    @GetMapping(value ="/selectById" )
    public Object selectById(HttpServletRequest request){
        String id=request.getParameter("id").trim();
        Singer singer = singerService.selectById(Integer.parseInt(id));
        if(singer!=null){
            return AjaxResult.success("根据id查询歌手成功",singer);
        }
        return AjaxResult.error("根据id查询个歌手失败");
    }

    @ApiOperation("查询所有歌手")
    @GetMapping(value ="/allSinger" )
    public Object allSinger(){
        List<Singer> singerList = singerService.AllSinger();
        if(singerList!=null){
            return AjaxResult.success("查询所有歌手成功",singerList);
        }
        return AjaxResult.error("查询所有歌手失败");
    }

    @ApiOperation("模糊查询歌手名字")
    @GetMapping(value ="/singerofName")
    public Object singerofName(HttpServletRequest request){
        String name=request.getParameter("name").trim();
        List<Singer> singerList = singerService.singerofName(name);
        if(singerList!=null){
            return AjaxResult.success("根据名字模糊查询成功",singerList);
        }
        return AjaxResult.error("根据名字模糊查询失败");
    }

    @ApiOperation("根据性别查询歌手")
    @GetMapping(value = "/singerofSex")
    public Object singerofSex(HttpServletRequest request){
        String sex=request.getParameter("sex").trim();
        List<Singer> singerList = singerService.singerofSex(Integer.parseInt(sex));
        if(singerList!=null){
            return AjaxResult.success("根据性别查询歌手成功",singerList);
        }
        return AjaxResult.error("根据性别查询歌手失败");
    }

    @ApiOperation("更新歌手头像")
    @PostMapping(value = "/updateSingerPic")
    public Object updateSingerPic(@RequestParam("file") MultipartFile multipartFile,@RequestParam("id") Integer id){
        if(multipartFile.isEmpty()){
            return AjaxResult.error("上传文件失败");
        }
        /*文件名=当前时间的毫秒值+原文件名*/
        String fileName=System.currentTimeMillis()+multipartFile.getOriginalFilename();
        /*文件路径*/
        String filePath=System.getProperty("user.dir")+System.getProperty("file.separator")+"img"
                +System.getProperty("file.separator")+"singerPic";
        File file1=new File(filePath);
        if(!file1.exists()){  //如果文件路径不存在，创建路径
            file1.mkdirs();
        }
        //实际的文件地址
        File dest=new File(filePath+System.getProperty("file.separator")+fileName);
        //相对的文件地址
        String storeAvatorPath="/img/singerPic/"+fileName;
        try {
            multipartFile.transferTo(dest);
            Singer singer=new Singer();
            singer.setId(id);
            singer.setPic(storeAvatorPath);
            boolean flag = singerService.update(singer);
            if(flag){
                return AjaxResult.success("上传成功",storeAvatorPath);
            }
            return AjaxResult.error("上传失败");
        } catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }
}
