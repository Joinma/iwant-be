package com.liori.mapper.teamuser;

import com.liori.mapper.base.BaseMapper;
import com.liori.model.teamuser.TeamUser;
import com.liori.model.teamuser.TeamUserExample;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>团队成员的映射器</p>
 * <b>created on 2019-06-10 21:09:59</b>
 *
 * @author liori
 * @since 0.1
 */
@Mapper
@Repository
public interface TeamUserMapper extends BaseMapper<TeamUser, TeamUserExample> {

}