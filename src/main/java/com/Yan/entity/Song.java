package com.Yan.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *歌曲
 * @Description:
 */
@Data
public class Song {
    @ApiModelProperty(value = "歌曲id")
    private Integer id;
    @ApiModelProperty(value = "歌手id")
    private Integer singerId;
    @ApiModelProperty(value = "歌曲名字")
    private String name;
    @ApiModelProperty(value = "歌曲简介")
    private String introduction;
    @ApiModelProperty(value = "歌曲创建时间")
    private Date createTime;
    @ApiModelProperty(value = "歌曲更新时间")
    private Date updateTime;
    @ApiModelProperty(value = "歌曲图片")
    private String pic;
    @ApiModelProperty(value = "歌词")
    private String lyric;
    @ApiModelProperty(value = "歌曲地址")
    private String url;
}
