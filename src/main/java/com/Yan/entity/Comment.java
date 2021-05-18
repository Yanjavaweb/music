package com.Yan.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *评论实体类
 * @Description:
 */
@Data
public class Comment {
    @ApiModelProperty(value = "评论id")
    private Integer id;
    @ApiModelProperty(value = "前端用户id")
    private Integer userId;
    @ApiModelProperty(value = "评论类型（0歌曲1歌单）")
    private Byte type;
    @ApiModelProperty(value = "歌曲id")
    private Integer songId;
    @ApiModelProperty(value = "歌单id")
    private Integer songListId;
    @ApiModelProperty(value = "评论内容")
    private String content;
    @ApiModelProperty(value = "评论时间")
    private Date createTime;
    @ApiModelProperty(value = "评论点赞数")
    private Integer up;
}
