package com.liori.service.team.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liori.mapper.base.BaseMapper;
import com.liori.mapper.team.TeamMapper;
import com.liori.model.team.Team;
import com.liori.model.team.TeamExample;
import com.liori.service.base.impl.BaseServiceImpl;
import com.liori.service.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


/**
 * <p>团队的接口实现类</p>
 * <b>created on 2019-06-10 20:52:43</b>
 *
 * @author liori
 * @since 0.1
 */
@Service
public class TeamServiceImpl extends BaseServiceImpl<Team, TeamExample> implements TeamService {


    @Autowired
    private TeamMapper teamMapper;

     @Override
    public BaseMapper<Team, TeamExample> getSpecificMapper() {
        return teamMapper;
    }

    @Override
    public PageInfo<Team> selectTeamsByExample(Team team, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        TeamExample teamExample = new TeamExample();
        List<Team> teams = teamMapper.selectByExample(teamExample);
        return new PageInfo<>(teams);
    }
}
