package com.Yan.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *前台用户实体类
 * @Description:
 */
@Data
public class Consumer {
    @ApiModelProperty(value = "前台用户id")
    private Integer id;
    @ApiModelProperty(value = "前台用户名")
    private String username;
    @ApiModelProperty(value = "前台用户密码")
    private String password;
    @ApiModelProperty(value = "前台用户性别")
    private Byte sex;
    @ApiModelProperty(value = "前台用户电话")
    private String phoneNum;
    @ApiModelProperty(value = "前台用户邮箱")
    private String email;
    @ApiModelProperty(value = "前台用户生日")
    private Date birth;
    @ApiModelProperty(value = "前台用户签名")
    private String introduction;
    @ApiModelProperty(value = "前台用户地址")
    private String location;
    @ApiModelProperty(value = "前台用户头像")
    private String avator;
    @ApiModelProperty(value = "前台用户创建时间")
    private Date createTime;
    @ApiModelProperty(value = "前台用户更新时间")
    private Date updateTime;
}
