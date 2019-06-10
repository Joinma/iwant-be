package com.liori.mapper.user;

import com.liori.mapper.base.BaseMapper;
import com.liori.model.user.User;
import com.liori.model.user.UserExample;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User, UserExample> {

    @Select("select * from t_user where open_id = #{openId}")
    User findUserByOpenId(@Param("openId") String openId);

    Integer insertBatch(List<User> users);

    @Insert({"<script>" +
            "insert into t_user (" +
            "   id, create_time, update_time,\n" +
            "   enabled, sequence, nick_name,\n" +
            "   open_id, avatar_url, calculation)\n" +
            "   values\n" +
            "   <foreach collection=\"users\" item=\"item\" index=\"index\" separator=\",\">(" +
            "   #{item.id,jdbcType=VARCHAR}, #{item.createTime,jdbcType=BIGINT}, #{item.updateTime,jdbcType=BIGINT},\n" +
            "   #{item.enabled,jdbcType=INTEGER}, #{item.sequence,jdbcType=INTEGER}, #{item.nickName,jdbcType=VARCHAR},\n" +
            "   #{item.openId,jdbcType=VARCHAR}, #{item.avatarUrl,jdbcType=VARCHAR}, #{item.calculation,jdbcType=VARCHAR})\n" +
            "   </foreach>\n" +
            "</script>"})
    Integer insertBatchBaseAnnotation(@Param("users") List<User> users);
}