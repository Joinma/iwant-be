package com.liori.common.utils.message;

import com.liori.common.exceptions.CustomizeServiceException;
import com.liori.common.message.CustomizeErrorMessage;
import com.liori.common.message.CustomizeMessage;
import com.liori.common.message.MessageEnum;
import com.liori.common.utils.date.DateUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;

/**
 * <p>控制器统一返回信息工具类</p>
 * <b>created on 2019-01-06 21:21:43</b>
 *
 * @author liori
 * @since springboot-mybatis-0.0.1-SNAPSHOT
 */
public class MessageUtil {

    public static <T> ResponseEntity success(T data, HttpStatus status) {
        CustomizeMessage<T> result = new CustomizeMessage<>();
        result.setStatus(status.value());
        result.setMessage(status.getReasonPhrase());
        result.setData(data);
        return new ResponseEntity<>(result, status);
    }

    public static <T> ResponseEntity error(MessageEnum error, Throwable throwable) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String message;
        if (throwable instanceof CustomizeServiceException) {
            CustomizeServiceException customizeServiceException = (CustomizeServiceException) throwable;
            if (!ObjectUtils.isEmpty(customizeServiceException.getStatus())) {
                status = customizeServiceException.getStatus();
            }
            message = customizeServiceException.getMessage();
        } else {
            message = throwable.toString();
        }
        CustomizeErrorMessage result = new CustomizeErrorMessage();
        Long currentTime = System.currentTimeMillis();
        String timestamp = DateUtil.timestampToDateString(currentTime, "yyyy-MM-dd HH:mm:ss");
        result.setTimestamp(timestamp);
        result.setStatus(status.value());
        result.setMessage(message);
        result.setError(error.getMessage());
        return new ResponseEntity<>(result, status);
    }
}
