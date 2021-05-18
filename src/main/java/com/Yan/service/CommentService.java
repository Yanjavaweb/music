package com.Yan.service;

import com.Yan.entity.Comment;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *评论service
 * @Description:
 */
public interface CommentService {
    /**
     * 增加
     * @param comment
     * @return
     */
    public boolean insert(Comment comment);

    /**
     * 修改
     * @param comment
     * @return
     */
    public boolean update(Comment comment);

    /**
     * 删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Comment selectById(Integer id);

    /**
     * 查询所有评论
     * @return
     */
    public List<Comment> AllComment();

    /**
     *查询单个歌曲的所有评论
     * @param songId
     * @return
     */
    public List<Comment> commentOfSongId(Integer songId);
    /**
     *查询单个歌单的所有评论
     * @param songListId
     * @return
     */
    public List<Comment> commentOfSongListId(Integer songListId);
}
