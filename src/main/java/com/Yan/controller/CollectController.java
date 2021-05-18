package com.Yan.controller;

import com.Yan.entity.Collect;
import com.Yan.service.CollectService;
import com.Yan.utils.Status.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *收藏controller
 * @Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/collectController")
@Api(tags = "collectController",description = "收藏管理")
public class CollectController {
    @Autowired
    private CollectService collectService;

    @ApiOperation("添加收藏")
    @GetMapping(value = "/add")
    public Object addCollect(HttpServletRequest request){
        String userId=request.getParameter("userId").trim();
        String type=request.getParameter("type").trim();
        String songId=request.getParameter("songId").trim();
        if(songId==null || songId.equals("")){
            return AjaxResult.error("收藏歌曲为空");
        }
        if(collectService.existSongId(Integer.parseInt(userId),Integer.parseInt(songId))){
            return AjaxResult.error("已收藏");
        }
        Collect collect=new Collect();
        collect.setUserId(Integer.parseInt(userId));
        collect.setType(new Byte(type));
        collect.setSongId(Integer.parseInt(songId));
        boolean flag = collectService.insert(collect);
        if(flag){
            return AjaxResult.success("收藏成功",collect);
        }
        return AjaxResult.error("收藏失败");
    }
    @ApiOperation("删除收藏")
    @GetMapping(value = "/delete")
    public Object deleteColect(HttpServletRequest request){
        String id=request.getParameter("id").trim();
        boolean flag = collectService.delete(Integer.parseInt(id));
        if(flag){
            return AjaxResult.success("删除收藏成功");
        }
        return AjaxResult.error("删除收藏失败");
    }
    @ApiOperation("根据用户id和歌曲id删除收藏")
    @GetMapping(value = "/deleteByUserIdSongId")
    public Object deleteByUserIdSongId(HttpServletRequest request){
        String userId=request.getParameter("userId").trim();
        String songId=request.getParameter("songId").trim();
        boolean flag = collectService.deleteByUserIdSongId(Integer.parseInt(userId), Integer.parseInt(songId));
        if(flag){
            return AjaxResult.success("根据用户id和歌曲id删除收藏成功");
        }
        return AjaxResult.error("根据用户id和歌曲id删除收藏失败");
    }
    @ApiOperation("查询所有收藏")
    @GetMapping(value = "/allCollect")
    public Object allCollect(){
        List<Collect> collectList = collectService.AllCollect();
        if(collectList!=null){
            return AjaxResult.success("查询所有收藏成功",collectList);
        }
        return AjaxResult.error("查询所有收藏失败");
    }
    @ApiOperation("查询单个用户的收藏列表")
    @GetMapping(value = "/collectOfUserId")
    public Object collectOfUserId(HttpServletRequest request){
        String userId=request.getParameter("userId").trim();
        List<Collect> collectList = collectService.collectOfUserId(Integer.parseInt(userId));
        if(collectList!=null){
            return AjaxResult.success("查询单个用户收藏列表成功",collectList);
        }
        return AjaxResult.error("查询单个用户收藏列表失败");
    }
}
