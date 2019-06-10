package com.liori.common.utils.wechat;

import com.alibaba.fastjson.JSONObject;
import com.liori.common.exceptions.CustomizeServiceException;
import com.liori.common.utils.base.CustomizeValueUtil;
import com.liori.common.utils.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

/**
 * <p>微信工具类</p>
 * <b>created on 2019-01-03 21:21:43</b>
 * <b>updated on 2019-01-20 16:36:43</b>
 *
 * @author liori
 * @since springboot-mybatis-0.0.1-SNAPSHOT
 */
public class WechatUtil {

    private final static Logger LOG = LoggerFactory.getLogger(WechatUtil.class);

    public static String getOpenId(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        String params = "?grant_type=authorization_code&appid=" + CustomizeValueUtil.APP_ID + "&secret=" + CustomizeValueUtil.SECRET + "&js_code=" + code;

        String result = HttpUtil.doGet(url, params);
        JSONObject resultJson = JSONObject.parseObject(result);
        Integer errcode = (Integer) resultJson.get("errcode");
        if (!ObjectUtils.isEmpty(errcode) && errcode != 0) {
            String errmsg = (String) resultJson.get("errmsg");
            LOG.error("获取openid失败 errcode: " + errcode + " errmsg: " + errmsg);
            throw new CustomizeServiceException("获取openid失败 errcode: " + errcode + " errmsg: " + errmsg);
        }
        return (String) resultJson.get("openid");
    }

}
