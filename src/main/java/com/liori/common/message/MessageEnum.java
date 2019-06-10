package com.liori.common.message;

/**
 * <p>自定义返回信息枚举</p>
 * <b>created on 2019-01-06 17:21:43</b>
 *
 * @author liori
 * @since springboot-mybatis 0.0.1
 */
public enum MessageEnum {

    /**
     * 登录失败
     */
    FAIL_TO_LOGIN("登录失败"),

    /**
     * 删除失败
     */
    FAIL_TO_DELETE("删除失败"),

    /**
     * 创建失败
     */
    FAIL_TO_CREATE("创建失败"),

    /**
     * 查询失败
     */
    FAIL_TO_QUERY("查询失败"),

    /**
     * 更新失败
     */
    FAIL_TO_UPDATE("更新失败"),

    /**
     * 上传失败
     */
    FAIL_TO_UPLOAD("上传失败");

    MessageEnum(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
