package com.Yan.controller;


import com.Yan.entity.Song;
import com.Yan.service.SongService;
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
 *歌曲管理
 * @Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/songController")
@Api(tags = "songController", description = "歌曲管理")
public class SongController {

    @Autowired
    private SongService songService;

    @ApiOperation("添加歌曲")
    @PostMapping(value = "/add")
    public Object addSong(HttpServletRequest request, @RequestParam("file") MultipartFile multipartFile){
        String singerId=request.getParameter("singerId").trim();
        String name=request.getParameter("name").trim();
        String introduction=request.getParameter("introduction").trim();
        String lyric=request.getParameter("lyric").trim();
        //上传歌曲文件
        if(multipartFile.isEmpty()){
            return AjaxResult.error("上传歌曲失败");
        }
        /*文件名=当前时间的毫秒值+原文件名*/
        String fileName=System.currentTimeMillis()+multipartFile.getOriginalFilename();
        /*文件路径*/
        String filePath=System.getProperty("user.dir")+System.getProperty("file.separator")+"song";
        File file1=new File(filePath);
        if(!file1.exists()){  //如果文件路径不存在，创建路径
            file1.mkdirs();
        }
        //实际的文件地址
        File dest=new File(filePath+System.getProperty("file.separator")+fileName);
        //相对的文件地址
        String storeAvatorPath="/song/"+fileName;
        try {
            multipartFile.transferTo(dest);
            Song song=new Song();
            song.setSingerId(Integer.parseInt(singerId));
            song.setName(name);
            song.setIntroduction(introduction);
            song.setLyric(lyric);
            song.setUrl(storeAvatorPath);
            boolean flag = songService.insert(song);
            if(flag){
                return AjaxResult.success("歌曲保存成功",storeAvatorPath);
            }
            return AjaxResult.error("歌曲保存失败");
        } catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }
    @ApiOperation("根据歌手id查询歌曲")
    @GetMapping(value = "/songofSingerId")
    public Object songofSingerId(HttpServletRequest request){
        String singerId=request.getParameter("singerId").trim();
        List<Song> songList = songService.songofSingerId(Integer.parseInt(singerId));
        if (songList != null) {
            return AjaxResult.success("根据歌手id查询歌曲成功",songList);
        }
        return AjaxResult.error("根据歌手id查询失败");
    }
    @ApiOperation("根据id查询歌曲")
    @GetMapping(value = "/songofSongId")
    public Object songofSongId(HttpServletRequest request){
        String songId=request.getParameter("songId").trim();
        Song song = songService.selectById(Integer.parseInt(songId));
        if (song != null) {
            return AjaxResult.success("根据id查询歌曲成功",song);
        }
        return AjaxResult.error("根据id查询失败");
    }
    @ApiOperation("查询所有歌曲")
    @GetMapping(value = "/allSong")
    public Object allSong(HttpServletRequest request){
        List<Song> songList = songService.AllSong();
        if (songList != null) {
            return AjaxResult.success("查询所有歌曲成功",songList);
        }
        return AjaxResult.error("查询所有歌曲失败");
    }
    @ApiOperation("根据歌名查询歌曲")
    @GetMapping(value = "/songofSongName")
    public Object songofSongName(HttpServletRequest request){
        System.out.println(request.getParameter("name"));
        String name=request.getParameter("songName");
        List<Song> songList = songService.songofName(name);
        if (songList != null) {
            return AjaxResult.success("根据id查询歌曲成功",songList);
        }
        return AjaxResult.error("根据id查询失败");
    }
    @ApiOperation("修改歌曲")
    @PostMapping(value = "/update")
    public Object update(HttpServletRequest request){
        String id=request.getParameter("id").trim();
        String name=request.getParameter("name").trim();
        String introduction=request.getParameter("introduction").trim();
        String lyric=request.getParameter("lyric").trim();
        Song song=new Song();
        song.setId(Integer.parseInt(id));
        song.setName(name);
        song.setIntroduction(introduction);
        song.setLyric(lyric);
        boolean flag=songService.update(song);
        if(flag){
            return AjaxResult.success("修改歌曲成功");
        }
        return AjaxResult.error("修改歌曲失败");
    }
    @ApiOperation("删除歌曲")
    @GetMapping(value = "delete")
    public Object delete(HttpServletRequest request){
        String id=request.getParameter("id");
        //删除歌曲图片以及歌曲文件
        Song song = songService.selectById(Integer.parseInt(id));
        String filepath=System.getProperty("user.dir");
        File file = new File(filepath+System.getProperty("file.separator")+song.getPic());
        if(file.exists()) file.delete();   //删除歌曲图片
        String fileName1=song.getUrl();
        File file1 = new File(filepath+System.getProperty("file.separator")+fileName1);
        if(file1.exists())
            file1.delete();
        boolean flag = songService.delete(Integer.parseInt(id));
        if(flag){
            return AjaxResult.success("删除成功");
        }
        return AjaxResult.error("删除失败");
    }
    @ApiOperation("更新歌曲头像")
    @PostMapping(value = "/updateSongPic")
    public Object updateSongPic(@RequestParam("file") MultipartFile multipartFile,@RequestParam("id") Integer id){
        if(multipartFile.isEmpty()){
            return AjaxResult.error("上传文件失败");
        }
        /*文件名=当前时间的毫秒值+原文件名*/
        String fileName=System.currentTimeMillis()+multipartFile.getOriginalFilename();
        /*文件路径*/
        String filePath=System.getProperty("user.dir")+System.getProperty("file.separator")+"img"
                +System.getProperty("file.separator")+"songPic";
        File file1=new File(filePath);
        if(!file1.exists()){  //如果文件路径不存在，创建路径
            file1.mkdirs();
        }
        //实际的文件地址
        File dest=new File(filePath+System.getProperty("file.separator")+fileName);
        //相对的文件地址
        String storeAvatorPath="/img/songPic/"+fileName;
        try {
            multipartFile.transferTo(dest);
            Song song=new Song();
            song.setId(id);
            song.setPic(storeAvatorPath);
            boolean flag = songService.update(song);
            if(flag){
                return AjaxResult.success("上传成功",storeAvatorPath);
            }
            return AjaxResult.error("上传失败");
        } catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }
    @ApiOperation("更新歌曲文件")
    @PostMapping(value = "/updateSongUrl")
    public Object updateSongUrl(@RequestParam("file") MultipartFile multipartFile,@RequestParam("id") Integer id){
        if(multipartFile.isEmpty()){
            return AjaxResult.error("上传文件失败");
        }
        /*文件名=当前时间的毫秒值+原文件名*/
        String fileName=System.currentTimeMillis()+multipartFile.getOriginalFilename();
        /*文件路径*/
        String filePath=System.getProperty("user.dir")+System.getProperty("file.separator")+"song";
        File file1=new File(filePath);
        if(!file1.exists()){  //如果文件路径不存在，创建路径
            file1.mkdirs();
        }
        //实际的文件地址
        File dest=new File(filePath+System.getProperty("file.separator")+fileName);
        //相对的文件地址
        String storeAvatorPath="/song/"+fileName;
        try {
            multipartFile.transferTo(dest);
            Song song=new Song();
            song.setId(id);
            song.setUrl(storeAvatorPath);
            boolean flag = songService.update(song);
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
