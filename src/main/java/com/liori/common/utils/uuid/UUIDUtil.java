package com.liori.common.utils.uuid;

import com.liori.common.exceptions.CustomizeServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <p>UUID 工具类</p>
 * <b>created on 2019-01-20 16:35:48</b>
 *
 * @author liori
 * @since springboot-mybatis-0.0.2-SNAPSHOT
 */
public class UUIDUtil {

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static List<String> createUUIDs(Integer num) {
        if (num <= 0) {
            throw new CustomizeServiceException("请输入合法的数量");
        }
        List<String> uuids = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String uuid = getUUID();
            uuids.add(uuid);
        }
        return uuids;
    }
}
