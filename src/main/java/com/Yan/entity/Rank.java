package com.Yan.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *评价实体类
 * @Description:
 */
@Data
public class Rank {
    @ApiModelProperty(value = "评价id")
    private Integer id;
    @ApiModelProperty(value = "歌单id")
    private Integer songListId;
    @ApiModelProperty(value = "前台用户di")
    private Integer consumerId;
    @ApiModelProperty(value = "评分")
    private Integer scope;
}
