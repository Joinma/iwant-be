package com.liori.model.base;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>基础实体类</p>
 *
 * @author liori
 * @since springboot-mybatis-0.0.2-SNAPSHOT
 */
public class BaseEntity implements Serializable {

    @ApiModelProperty(value = "表主键")
    private String id;

    @ApiModelProperty(value = "添加时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;

    @ApiModelProperty(value = "是否可见，0为不可见，1为可见")
    private Integer enabled;

    @ApiModelProperty(value = "排序")
    private Integer sequence;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}
