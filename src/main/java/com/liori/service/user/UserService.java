package com.liori.service.user;

import com.github.pagehelper.PageInfo;
import com.liori.model.user.User;
import com.liori.model.user.UserExample;
import com.liori.service.base.BaseService;
import org.springframework.stereotype.Service;

/**
 * <p>用户的接口类</p>
 * <b>created on 2019-06-10 20:26:48</b>
 *
 * @author liori
 * @since 0.1
 */
@Service
public interface UserService extends BaseService<User, UserExample> {

    /**
     * 分页查询用户
     *
     * @param user
     * @param pageNum 页码
     * @param pageSize 每页加载量
     * @return PageInfo<User>
     */
    PageInfo<User> selectUsersByExample(User user, Integer pageNum, Integer pageSize);

    /**
     * 用户登录
     * @param code
     * @return
     */
    User login(String code);
}
