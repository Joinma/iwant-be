package com.liori.common.message;

import io.swagger.annotations.ApiModelProperty;

public class CustomizeErrorMessage {

    @ApiModelProperty(value = "请求的时间")
    private String timestamp;

    @ApiModelProperty(value = "状态码")
    private Integer status;

    @ApiModelProperty(value = "返回的错误")
    private String error;

    @ApiModelProperty(value = "异常信息")
    private String message;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

