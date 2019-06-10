package com.liori.service.base;

import com.liori.model.base.BaseEntity;
import org.springframework.stereotype.Service;

/**
 * <p>Service接口基础类</p>
 * <b>created on 2019-01-20 16:37:18</b>
 *
 * @author liori
 * @since springboot-mybatis-0.0.2-SNAPSHOT
 */
@Service
public interface BaseService<T extends BaseEntity, E> {

    T saveEntity(T entity);

    T saveEntitySelective(T entity);

    T updateEntity(T entity);

    T updateEntitySelective(T entity);

    String deleteEntity(String id);

    T selectSingleEntity(String id);

}
