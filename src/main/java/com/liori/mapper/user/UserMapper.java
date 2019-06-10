package com.liori.mapper.user;

import com.liori.mapper.base.BaseMapper;
import com.liori.model.user.User;
import com.liori.model.user.UserExample;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>用户的映射器</p>
 * <b>created on 2019-06-10 20:37:11</b>
 *
 * @author liori
 * @since 0.1
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User, UserExample> {

    @Select("select * from t_user where open_id = #{openId}")
    User findUserByOpenId(@Param("openId") String openId);

}