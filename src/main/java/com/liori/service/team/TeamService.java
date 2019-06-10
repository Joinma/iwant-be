package com.liori.service.team;

import com.github.pagehelper.PageInfo;
import com.liori.model.team.Team;
import com.liori.model.team.TeamExample;
import com.liori.service.base.BaseService;
import org.springframework.stereotype.Service;

/**
 * <p>团队的接口类</p>
 * <b>created on 2019-06-10 20:52:43</b>
 *
 * @author liori
 * @since 0.1
 */
@Service
public interface TeamService extends BaseService<Team, TeamExample> {

    /**
     * 分页查询团队
     *
     * @param team
     * @param pageNum 页码
     * @param pageSize 每页加载量
     * @return PageInfo<Team>
     */
    PageInfo<Team> selectTeamsByExample(Team team, Integer pageNum, Integer pageSize);

}
