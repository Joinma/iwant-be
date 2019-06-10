package com.liori.common.message;

public enum MessageEnum {

    /**
     * 登录失败
     */
    LOGIN_FAILED("登录失败"),

    /**
     * 删除失败
     */
    DELETE_FAILED("删除失败"),

    /**
     * 创建失败
     */
    CREATE_FAILED("创建失败"),

    /**
     * 查询失败
     */
    QUERY_FAILED("查询失败"),

    /**
     * 更新失败
     */
    UPDATE_FAILED("更新失败"),

    /**
     * 上传失败
     */
    UPLOAD_FAILED("上传失败"),

    /**
     * 下载失败
     */
    DOWNLOAD_FAILED("下载失败");

    MessageEnum(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
