package com.Yan.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *收藏实体类
 * @Description:
 */
@Data
public class Collect {
    @ApiModelProperty(value = "收藏的id")
    private Integer id;
    @ApiModelProperty(value = "前台用户id")
    private Integer userId;
    @ApiModelProperty(value = "收藏类型")
    private Byte type;
    @ApiModelProperty(value = "歌曲id")
    private Integer songId;
    @ApiModelProperty(value = "歌单id")
    private Integer songListId;
    @ApiModelProperty(value = "收藏时间")
    private Date createTime;
}
