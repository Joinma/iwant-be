package com.liori.service.base.impl;

import com.liori.common.constants.CustomizeConstants;
import com.liori.common.exceptions.CustomizeServiceException;
import com.liori.common.utils.uuid.UUIDUtil;
import com.liori.mapper.base.BaseMapper;
import com.liori.model.base.BaseEntity;
import com.liori.service.base.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * <p>Service接口基础实现类</p>
 * <b>created on 2019-01-15 13:42:18</b>
 *
 * @author liori
 * @since springboot-mybatis-0.0.2-SNAPSHOT
 */
@Service
public abstract class BaseServiceImpl<T extends BaseEntity, E> implements BaseService<T, E> {

    public abstract BaseMapper<T, E> getSpecificMapper();

    @Override
    public T saveEntity(T entity) {
        String id = UUIDUtil.getUUID();
        entity.setId(id);
        Long currentTimeMillis = System.currentTimeMillis();
        entity.setCreateTime(currentTimeMillis);
        entity.setUpdateTime(currentTimeMillis);
        entity.setEnabled(CustomizeConstants.ENABLED);
        if (ObjectUtils.isEmpty(entity.getSequence())) {
            entity.setSequence(99);
        }
        int insertedNum = getSpecificMapper().insert(entity);
        if (insertedNum == 0) {
            throw new CustomizeServiceException("新增失败");
        }

        return entity;
    }

    @Override
    public T saveEntitySelective(T entity) {
        String id = UUIDUtil.getUUID();
        entity.setId(id);
        Long currentTimeMillis = System.currentTimeMillis();
        entity.setCreateTime(currentTimeMillis);
        entity.setUpdateTime(currentTimeMillis);
        entity.setEnabled(CustomizeConstants.ENABLED);
        if (ObjectUtils.isEmpty(entity.getSequence())) {
            entity.setSequence(99);
        }
        int insertedNum = getSpecificMapper().insertSelective(entity);
        if (insertedNum == 0) {
            throw new CustomizeServiceException("新增失败");
        }
        return entity;
    }

    @Override
    public T updateEntity(T entity) {
        String id = entity.getId();
        if (StringUtils.isEmpty(id) || CustomizeConstants.UNDEFINED.equals(id)) {
            throw new CustomizeServiceException("请传入合法的 id");
        }
        entity.setUpdateTime(System.currentTimeMillis());
        int updateRecodeNum = getSpecificMapper().updateByPrimaryKey(entity);
        if (updateRecodeNum == 0) {
            throw new CustomizeServiceException("更新失败");
        }
        return entity;
    }

    @Override
    public T updateEntitySelective(T entity) {
        String id = entity.getId();
        if (StringUtils.isEmpty(id) || CustomizeConstants.UNDEFINED.equals(id)) {
            throw new CustomizeServiceException("请传入合法的 id");
        }
        entity.setUpdateTime(System.currentTimeMillis());
        int updateRecodeNum = getSpecificMapper().updateByPrimaryKeySelective(entity);
        if (updateRecodeNum == 0) {
            throw new CustomizeServiceException("更新失败");
        }
        return getSpecificMapper().selectByPrimaryKey(id);
    }

    @Override
    public String deleteEntity(String id) {
        int deletedNum = getSpecificMapper().deleteByPrimaryKey(id);
        if (deletedNum == 0) {
            throw new CustomizeServiceException("删除失败");
        }
        return id;
    }

    @Override
    public T selectSingleEntity(String id) {
        return getSpecificMapper().selectByPrimaryKey(id);
    }

}
