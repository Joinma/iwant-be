package com.liori.service.user;

import com.github.pagehelper.PageInfo;
import com.liori.model.user.User;
import com.liori.model.user.UserExample;
import com.liori.service.base.BaseService;
import org.springframework.stereotype.Service;

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
