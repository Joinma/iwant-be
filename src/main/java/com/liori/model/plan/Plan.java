package com.liori.model.plan;

import com.liori.model.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
* <p>计划的实体类</p>
* <b>created on 2019-06-10 21:03:34</b>
*
* @author liori
* @since 0.1
*/
@ApiModel("计划")
public class Plan extends BaseEntity implements Serializable {

    @ApiModelProperty(value = "计划开始时间")
    private Long startTime;

    @ApiModelProperty(value = "团队成员表主键")
    private String teamUserId;

    @ApiModelProperty(value = "计划内容")
    private String content;

    @ApiModelProperty(value = "计划标题")
    private String title;

    @ApiModelProperty(value = "奖励")
    private String reward;

    @ApiModelProperty(value = "惩罚")
    private String punish;


    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public String getTeamUserId() {
        return teamUserId;
    }

    public void setTeamUserId(String teamUserId) {
        this.teamUserId = teamUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getPunish() {
        return punish;
    }

    public void setPunish(String punish) {
        this.punish = punish;
    }

}