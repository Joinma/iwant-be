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
    }

}