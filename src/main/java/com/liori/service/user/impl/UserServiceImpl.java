package com.liori.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liori.common.utils.wechat.WechatUtil;
import com.liori.mapper.base.BaseMapper;
import com.liori.mapper.user.UserMapper;
import com.liori.model.user.User;
import com.liori.model.user.UserExample;
import com.liori.service.base.impl.BaseServiceImpl;
import com.liori.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;


@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserExample> implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseMapper<User, UserExample> getSpecificMapper() {
        return userMapper;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public User login(String code) {
        String openId = WechatUtil.getOpenId(code);
        User user = userMapper.findUserByOpenId(openId);
        if (ObjectUtils.isEmpty(user)) {
            user = new User();
            user.setOpenId(openId);
            user = saveEntitySelective(user);
        }
        return user;
    }

    @Override
    public PageInfo<User> selectUsersByExample(User user, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (!ObjectUtils.isEmpty(user.getNickName())) {
            criteria.andNickNameEqualTo(user.getNickName());
        }
        List<User> users = userMapper.selectByExample(userExample);
        return new PageInfo<>(users);
    }
}
