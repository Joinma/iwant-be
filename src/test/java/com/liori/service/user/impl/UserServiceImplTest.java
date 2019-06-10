package com.liori.service.user.impl;

import com.liori.SpringbootMybatisApplication;
import com.liori.common.constants.CustomizeConstants;
import com.liori.common.utils.uuid.UUIDUtil;
import com.liori.mapper.user.UserMapper;
import com.liori.model.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class UserServiceImplTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertBatch() {
        long currentTimeMillis = System.currentTimeMillis();
        User user1 = new User();
        user1.setOpenId("3333");
        user1.setCreateTime(currentTimeMillis);
        user1.setUpdateTime(currentTimeMillis);
        user1.setEnabled(CustomizeConstants.ENABLED);
        user1.setAvatarUrl("http://planday.getcy.cn/hi");
        user1.setNickName("liori1");
        user1.setSequence(99);
        user1.setId(UUIDUtil.getUUID());
        User user2 = new User();
        user2.setOpenId("4444");
        user2.setCreateTime(currentTimeMillis);
        user2.setUpdateTime(currentTimeMillis);
        user2.setEnabled(CustomizeConstants.ENABLED);
        user2.setAvatarUrl("http://planday.getcy.cn/hello");
        user2.setNickName("liori2");
        user2.setSequence(99);
        user2.setId(UUIDUtil.getUUID());

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
//        int i = userMapper.insertBatch(users);
        int i = userMapper.insertBatchBaseAnnotation(users);
        System.out.println("result: " + i);
    }

}