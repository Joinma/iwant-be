package com.liori.mapper.team;

import com.liori.mapper.base.BaseMapper;
import com.liori.model.team.Team;
import com.liori.model.team.TeamExample;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>团队的映射器</p>
 * <b>created on 2019-06-10 21:00:36</b>
 *
 * @author liori
 * @since 0.1
 */
@Mapper
@Repository
public interface TeamMapper extends BaseMapper<Team, TeamExample> {

}