package com.liori.common.utils.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <p>SpringBoot 配置文件自定义属性获取工具类</p>
 * <b>created on 2019-01-20 16:35:48</b>
 *
 * @author liori
 * @since springboot-mybatis-0.0.2-SNAPSHOT
 */
@Component
public class CustomizeValueUtil {

    public static String APP_ID;

    public static String SECRET;

    @Value("${wechat.appId}")
    private void setAppId(String appId) {
        APP_ID = appId;
    }

    @Value("${wechat.secret}")
    private void setSecret(String secret) {
        SECRET = secret;
    }
}
