package com.Yan.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *歌手
 * @Description:
 */
@Data
public class Singer {
    @ApiModelProperty(value = "歌手id")
    private Integer id;
    @ApiModelProperty(value = "歌手姓名")
    private String name;
    @ApiModelProperty(value = "歌手性别")
    private Byte sex;
    @ApiModelProperty(value = "歌手头像路径")
    private String pic;
    @ApiModelProperty(value = "歌手生日")
    private Date birth;
    @ApiModelProperty(value = "歌手地址")
    private String location;
    @ApiModelProperty(value = "歌手简介")
    private String introduction;
}
