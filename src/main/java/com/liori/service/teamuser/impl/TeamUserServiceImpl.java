package com.liori.service.teamuser.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liori.mapper.base.BaseMapper;
import com.liori.mapper.teamuser.TeamUserMapper;
import com.liori.model.teamuser.TeamUser;
import com.liori.model.teamuser.TeamUserExample;
import com.liori.service.base.impl.BaseServiceImpl;
import com.liori.service.teamuser.TeamUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


/**
 * <p>团队成员的接口实现类</p>
 * <b>created on 2019-06-10 21:09:59</b>
 *
 * @author liori
 * @since 0.1
 */
@Service
public class TeamUserServiceImpl extends BaseServiceImpl<TeamUser, TeamUserExample> implements TeamUserService {


    @Autowired
    private TeamUserMapper teamUserMapper;

     @Override
    public BaseMapper<TeamUser, TeamUserExample> getSpecificMapper() {
        return teamUserMapper;
    }

    @Override
    public PageInfo<TeamUser> selectTeamUsersByExample(TeamUser teamUser, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        TeamUserExample teamUserExample = new TeamUserExample();
        List<TeamUser> teamUsers = teamUserMapper.selectByExample(teamUserExample);
        return new PageInfo<>(teamUsers);
    }
}
