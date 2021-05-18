package com.Yan.controller;

import com.Yan.entity.ListSong;
import com.Yan.service.ListSongService;
import com.Yan.utils.Status.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *歌曲列表controller
 * @Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/listSongController")
@Api(tags = "singerController", description = "歌曲列表管理")
public class ListSongController {

    @Autowired
    private ListSongService listSongService;

    @ApiOperation("给列表添加歌曲")
    @PostMapping(value = "/add")
    public Object addListSong(HttpServletRequest request){
        String songId=request.getParameter("songId");
        String songListId=request.getParameter("songListId").trim();
        ListSong listSong=new ListSong();
        listSong.setSongId(Integer.parseInt(songId));
        listSong.setSongListId(Integer.parseInt(songListId));
        boolean flag = listSongService.insert(listSong);
        if(flag){
            return AjaxResult.success("给列表添加歌曲成功",listSong);
        }
        return AjaxResult.error("给列表添加歌曲失败");
    }
    @ApiOperation("给列表修改歌曲")
    @PostMapping(value = "/update")
    public Object updateListSong(HttpServletRequest request){
        String id=request.getParameter("id").trim();
        String songId=request.getParameter("songId").trim();
        String songListId=request.getParameter("songListId").trim();
        ListSong listSong=new ListSong();
        listSong.setId(Integer.parseInt(id));
        listSong.setSongId(Integer.parseInt(songId));
        listSong.setSongListId(Integer.parseInt(songListId));
        boolean flag = listSongService.update(listSong);
        if(flag){
            return AjaxResult.success("给列表修改歌曲成功",listSong);
        }
        return AjaxResult.error("给列表修改歌曲失败");
    }
    @ApiOperation("删除列表中歌曲")
    @GetMapping(value = "/delete")
    public Object deleteListSong(HttpServletRequest request){
        String songId=request.getParameter("songId").trim();
        String songListId=request.getParameter("songListId").trim();
        boolean flag = listSongService.deleteBySongIdAndSongListId(Integer.parseInt(songId),Integer.parseInt(songListId));
        if(flag){
            return AjaxResult.success("删除列表中歌曲成功");
        }
        return AjaxResult.error("删除列表中歌曲失败");
    }
    @ApiOperation("查询列表中所有歌曲")
    @GetMapping(value = "/allListSong")
    public Object allListSong(){
        List<ListSong> listSong = listSongService.AlllistSong();
        if(listSong!=null){
            return AjaxResult.success("查询列表中所有歌曲成功",listSong);
        }
        return AjaxResult.error("查询列表中所有歌曲失败");
    }
    @ApiOperation("根据id查询列表")
    @GetMapping(value = "/selectById")
    public Object selectById(HttpServletRequest request){
        String id=request.getParameter("id").trim();
        ListSong listSong = listSongService.selectById(Integer.parseInt(id));
        if(listSong!=null){
            return AjaxResult.success("根据id查询列表成功",listSong);
        }
        return AjaxResult.error("根据id查询列表失败");
    }
    @ApiOperation("根据歌单id查询歌曲")
    @GetMapping(value = "/listSongOfSongListId")
    public Object listSongOfSongListId(HttpServletRequest request){
        String songListId=request.getParameter("songListId").trim();
        List<ListSong> listSongList = listSongService.listSongOfSongListId(Integer.parseInt(songListId));
        if(listSongList!=null){
            return AjaxResult.success("根据歌单id查询成功",listSongList);
        }
        return AjaxResult.error("根据歌单id查询失败");
    }
}
