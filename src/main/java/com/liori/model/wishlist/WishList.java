package com.liori.model.wishlist;

import com.liori.model.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
* <p>愿望清单的实体类</p>
* <b>created on 2019-06-10 21:13:13</b>
*
* @author liori
* @since 0.1
*/
@ApiModel("愿望清单")
public class WishList extends BaseEntity implements Serializable {

    @ApiModelProperty(value = "愿望内容")
    private String content;

    @ApiModelProperty(value = "0：仅自己可见 1：指定团队可见")
    private Integer type;

    @ApiModelProperty(value = "用户表主键")
    private String userId;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}