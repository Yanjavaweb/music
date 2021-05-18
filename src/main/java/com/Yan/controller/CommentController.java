package com.Yan.controller;

import com.Yan.entity.Comment;
import com.Yan.service.CommentService;
import com.Yan.utils.Status.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *评论controller
 * @Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/commentController")
@Api(tags = "commentController",description = "评论管理")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ApiOperation("添加评论")
    @PostMapping(value = "/add")
    public Object addComment(HttpServletRequest request){
        String userId=request.getParameter("userId").trim();
        String type=request.getParameter("type").trim();
        String songId=request.getParameter("songId").trim();
        String songListId=request.getParameter("songListId").trim();
        String content=request.getParameter("content").trim();

        Comment comment=new Comment();
        comment.setUserId(Integer.parseInt(userId));
        comment.setType(new Byte(type));
        if(new Byte(type)==0){
            comment.setSongId(Integer.parseInt(songId));
        }else{
            comment.setSongListId(Integer.parseInt(songListId));
        }
        comment.setContent(content);
        boolean flag = commentService.insert(comment);
        if(flag){
            return AjaxResult.success("添加评论成功",comment);
        }
        return AjaxResult.error("添加评论失败");
    }
    @ApiOperation("修改评论")
    @PostMapping(value = "/update")
    public Object updateComment(HttpServletRequest request){
        String id=request.getParameter("id").trim();
        String userId=request.getParameter("userId").trim();
        String type=request.getParameter("type").trim();
        String songId=request.getParameter("songId").trim();
        String songListId=request.getParameter("songListId").trim();
        String content=request.getParameter("content").trim();

        Comment comment=new Comment();
        comment.setId(Integer.parseInt(id));
        comment.setUserId(Integer.parseInt(userId));
        comment.setType(new Byte(type));
       if(songId!=null || songId.equals("")){
           comment.setSongId(Integer.parseInt(songId));
       }
       if(songListId!=null || songListId.equals("")){
           comment.setSongListId(Integer.parseInt(songListId));
       }
        comment.setContent(content);
        boolean flag = commentService.update(comment);
        if(flag){
            return AjaxResult.success("修改评论成功",comment);
        }
        return AjaxResult.error("修改评论失败");
    }
    @ApiOperation("删除评论")
    @GetMapping(value = "/delete")
    public Object deleteComment(HttpServletRequest request){
        String id=request.getParameter("id").trim();
        boolean flag = commentService.delete(Integer.parseInt(id));
        if(flag){
            return AjaxResult.success("删除评论成功");
        }
        return AjaxResult.error("删除评论失败");
    }
    @ApiOperation("根据id查询")
    @GetMapping(value = "/selectById")
    public Object selectById(HttpServletRequest request){
        String id=request.getParameter("id").trim();
        Comment comment = commentService.selectById(Integer.parseInt(id));
        if(comment!=null){
            return AjaxResult.success("根据id查询成功");
        }
        return AjaxResult.error("根据id查询失败");
    }
    @ApiOperation("查询所有评论")
    @GetMapping(value = "/allComment")
    public Object allComment(){
        List<Comment> commentList = commentService.AllComment();
        if(commentList!=null){
            return AjaxResult.success("查询所有评论成功");
        }
        return AjaxResult.error("查询所有评论失败");
    }
    @ApiOperation("根据songId查询")
    @GetMapping(value = "/selectBysongId")
    public Object selectBysongId(HttpServletRequest request){
        String songId=request.getParameter("songId").trim();
        List<Comment> commentList = commentService.commentOfSongId(Integer.parseInt(songId));
        if(commentList!=null){
            return AjaxResult.success("根据songId查询成功");
        }
        return AjaxResult.error("根据songId查询失败");
    }
    @ApiOperation("根据songListId查询")
    @GetMapping(value = "/selectBysongListId")
    public Object selectBysongListId(HttpServletRequest request){
        String songListId=request.getParameter("songListId").trim();
        List<Comment> commentList = commentService.commentOfSongListId(Integer.parseInt(songListId));
        if(commentList!=null){
            return AjaxResult.success("根据songListId查询成功");
        }
        return AjaxResult.error("根据songListId查询失败");
    }
    @ApiOperation("给单个评论点赞")
    @GetMapping(value = "/like")
    public Object like(HttpServletRequest request){
        String id=request.getParameter("id").trim();
        String up=request.getParameter("up").trim();

        Comment comment=new Comment();
        comment.setId(Integer.parseInt(id));
        comment.setUserId(Integer.parseInt(up));
        boolean flag = commentService.update(comment);
        if(flag){
            return AjaxResult.success("点赞成功",comment);
        }
        return AjaxResult.error("点赞失败");
    }

}
