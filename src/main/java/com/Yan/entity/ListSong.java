package com.Yan.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *歌曲列表
 * @Description:
 */
@Data
public class ListSong implements Serializable {
    @ApiModelProperty(value = "歌单包含歌曲的id")
    private Integer id;
    @ApiModelProperty(value = "歌曲id")
    private Integer songId;
    @ApiModelProperty(value = "歌单id")
    private Integer songListId;
}
