package com.liori.model.teamuser;

import com.liori.model.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
* <p>团队成员的实体类</p>
* <b>created on 2019-06-10 21:09:58</b>
*
* @author liori
* @since 0.1
*/
@ApiModel("团队成员")
public class TeamUser extends BaseEntity implements Serializable {

    @ApiModelProperty(value = "团队表主键")
    private String teamId;

    @ApiModelProperty(value = "用户表主键")
    private String userId;


    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}