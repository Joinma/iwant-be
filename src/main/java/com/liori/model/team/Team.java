package com.liori.model.team;

import com.liori.model.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
* <p>团队的实体类</p>
* <b>created on 2019-06-10 20:58:58</b>
*
* @author liori
* @since 0.1
*/
@ApiModel("团队")
public class Team extends BaseEntity implements Serializable {

    @ApiModelProperty(value = "团队名称")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}