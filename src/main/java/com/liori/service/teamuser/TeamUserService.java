package com.liori.service.teamuser;

import com.github.pagehelper.PageInfo;
import com.liori.model.teamuser.TeamUser;
import com.liori.model.teamuser.TeamUserExample;
import com.liori.service.base.BaseService;
import org.springframework.stereotype.Service;

/**
 * <p>团队成员的接口类</p>
 * <b>created on 2019-06-10 21:09:59</b>
 *
 * @author liori
 * @since 0.1
 */
@Service
public interface TeamUserService extends BaseService<TeamUser, TeamUserExample> {

    /**
     * 分页查询团队成员
     *
     * @param teamUser
     * @param pageNum 页码
     * @param pageSize 每页加载量
     * @return PageInfo<TeamUser>
     */
    PageInfo<TeamUser> selectTeamUsersByExample(TeamUser teamUser, Integer pageNum, Integer pageSize);

}
