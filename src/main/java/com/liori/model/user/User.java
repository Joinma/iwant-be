package com.liori.model.user;

import com.liori.model.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("用户")
public class User extends BaseEntity implements Serializable {

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "微信open_id")
    private String openId;

    @ApiModelProperty(value = "微信头像url")
    private String avatarUrl;

    @ApiModelProperty(value = "每月预算")
    private String calculation;


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCalculation() {
        return calculation;
    }

    public void setCalculation(String calculation) {
        this.calculation = calculation;
    }

}