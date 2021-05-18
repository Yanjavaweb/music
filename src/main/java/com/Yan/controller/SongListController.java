package com.Yan.controller;

import com.Yan.entity.SongList;
import com.Yan.service.SongListService;
import com.Yan.utils.Status.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/songListController")
@Api(tags = "singerController", description = "歌单管理")
public class SongListController {

    @Autowired
    private SongListService songListService;

    @ApiOperation("添加歌单")
    @PostMapping(value = "/add")
    public Object addSongList(HttpServletRequest request){
        String title=request.getParameter("title").trim();
        String pic=request.getParameter("pic").trim();
        String introduction=request.getParameter("introduction").trim();
        String style=request.getParameter("style").trim();

        SongList songList=new SongList();
        songList.setTitle(title);
        songList.setPic(pic);
        songList.setIntroduction(introduction);
        songList.setStyle(style);
        boolean flag = songListService.insert(songList);
        if(flag){
            return AjaxResult.success("添加歌单成功",songList);
        }
        return AjaxResult.error("添加歌单失败");
    }
    @ApiOperation("修改歌单")
    @PostMapping(value = "/update")
    public Object updateSongList(HttpServletRequest request){
        String id=request.getParameter("id").trim();
        String title=request.getParameter("title").trim();
        String introduction=request.getParameter("introduction").trim();
        String style=request.getParameter("style").trim();

        SongList songList=new SongList();
        songList.setId(Integer.parseInt(id));
        songList.setTitle(title);
        songList.setIntroduction(introduction);
        songList.setStyle(style);
        boolean flag = songListService.update(songList);
        if(flag){
            return AjaxResult.success("修改歌单成功",songList);
        }
        return AjaxResult.error("修改歌单失败");
    }
    @ApiOperation("删除歌单")
    @GetMapping(value = "/delete")
    public Object deleteSongList(HttpServletRequest request){
        String id=request.getParameter("id").trim();
        SongList songList=songListService.selectById(Integer.parseInt(id));
        String filepath=System.getProperty("user.dir");
        File file=new File(filepath+System.getProperty("file.separator")+songList.getPic());
        if(file.exists())
            file.delete();
        boolean flag = songListService.delete(Integer.parseInt(id));
        if(flag){
            return AjaxResult.success("删除歌单成功");
        }
        return AjaxResult.error("删除歌单失败");
    }
    @ApiOperation("查询所有歌单")
    @GetMapping(value = "/allSongList")
    public Object allSongList(HttpServletRequest request){
        List<SongList> songList = songListService.AllSongList();
        if(songList!=null){
            return AjaxResult.success("查询所有歌单成功",songList);
        }
        return AjaxResult.error("查询所有歌单失败");
    }
    @ApiOperation("根据id查询歌单")
    @GetMapping(value = "selectById")
    public Object selectById(HttpServletRequest request){
        String id=request.getParameter("id").trim();
        SongList songList = songListService.selectById(Integer.parseInt(id));
        if(songList!=null){
            return AjaxResult.success("根据id查询歌单成功",songList);
        }
        return AjaxResult.error("根据id查询歌单失败");
    }
    @ApiOperation("根据歌单标题精确查询")
    @GetMapping(value = "SongListOfTitle")
    public Object SongListOfTitle(HttpServletRequest request){
        String title=request.getParameter("title").trim();
        List<SongList> songList = songListService.SongListOfTitle(title);
        if(songList!=null){
            return AjaxResult.success("根据歌单标题精确查询成功",songList);
        }
        return AjaxResult.error("根据跟打标题精确失败");
    }
    @ApiOperation("根据歌单标题模查询")
    @GetMapping(value = "/likeTitle")
    public Object likeTitle(HttpServletRequest request){
        String title=request.getParameter("title").trim();
        List<SongList> songList = songListService.likeTitle(title);
        if(songList!=null){
            return AjaxResult.success("根据歌单标题模糊查询成功",songList);
        }
        return AjaxResult.error("根据歌单模糊查询失败");
    }
    @ApiOperation("根据歌单风格模查询")
    @GetMapping(value = "/likeStyle")
    public Object likeStyle(HttpServletRequest request){
        String style=request.getParameter("style").trim();
        List<SongList> songList = songListService.likeTitle(style);
        if(songList!=null){
            return AjaxResult.success("根据歌单风格模查询成功",songList);
        }
        return AjaxResult.error("根据歌单风格模查询失败");
    }
    @ApiOperation("更新歌手头像")
    @PostMapping(value = "/updateSongListPic")
    public Object updateSongListPic(@RequestParam("file") MultipartFile multipartFile, @RequestParam("id") Integer id){
        if(multipartFile.isEmpty()){
            return AjaxResult.error("上传文件失败");
        }
        /*文件名=当前时间的毫秒值+原文件名*/
        String fileName=System.currentTimeMillis()+multipartFile.getOriginalFilename();
        /*文件路径*/
        String filePath=System.getProperty("user.dir")+System.getProperty("file.separator")+"img"
                +System.getProperty("file.separator")+"songListPic";
        File file1=new File(filePath);
        if(!file1.exists()){  //如果文件路径不存在，创建路径
            file1.mkdirs();
        }
        //实际的文件地址
        File dest=new File(filePath+System.getProperty("file.separator")+fileName);
        //相对的文件地址
        String storeAvatorPath="/img/songListPic/"+fileName;
        try {
            multipartFile.transferTo(dest);
            SongList singer=new SongList();
            singer.setId(id);
            singer.setPic(storeAvatorPath);
            boolean flag = songListService.update(singer);
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
