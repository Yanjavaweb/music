package com.Yan.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *歌单实体类
 * @Description:
 */
@Data
public class SongList {
    @ApiModelProperty(value = "歌单id")
    private Integer id;
    @ApiModelProperty(value = "歌单题目")
    private String title;
    @ApiModelProperty(value = "歌单图片")
    private String pic;
    @ApiModelProperty(value = "歌单简介")
    private String introduction;
    @ApiModelProperty(value = "歌单风格")
    private String style;
}
