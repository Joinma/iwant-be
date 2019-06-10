package com.liori.controller.user;

import com.github.pagehelper.PageInfo;
import com.liori.common.message.MessageEnum;
import com.liori.common.utils.message.MessageUtil;
import com.liori.model.user.User;
import com.liori.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "用户Controller", tags = {"用户接口"})
@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    private final static Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "新增用户", notes = "添加一个用户")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> saveUser(
            @ApiParam(name = "用户信息", required = true) @RequestBody User user) {
        try {
            final User insertedUser = userService.saveEntity(user);
            return MessageUtil.success(insertedUser, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.CREATE_FAILED.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.CREATE_FAILED, throwable);
        }
    }

    @ApiOperation(value = "删除单个用户", notes = "根据 id 删除单个用户信息")
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> deleteUser(
            @ApiParam(value = "id", required = true) @PathVariable(value = "id") String id) {
        try {
            final String deletedId = userService.deleteEntity(id);
            return MessageUtil.success(deletedId, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.UPDATE_FAILED.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.UPDATE_FAILED, throwable);
        }
    }

    @ApiOperation(value = "获取单个用户", notes = "根据 id 获取用户信息")
    @GetMapping(value = "/query/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getSingleUser(
            @ApiParam(value = "id", required = true) @PathVariable(value = "id") String id) {
        try {
            final User user = userService.selectSingleEntity(id);
            return MessageUtil.success(user, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.QUERY_FAILED.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.QUERY_FAILED, throwable);
        }
    }

    @ApiOperation(value = "根据参数分页获取用户", notes = "根据参数分页获取用户信息")
    @GetMapping(value = "/query", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getusers(
            @ApiParam(value = "页码", defaultValue = "1") @RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
            @ApiParam(value = "每页加载量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        try {
            User user = new User();
            final PageInfo<User> users = userService.selectUsersByExample(user, pageNum, pageSize);
            return MessageUtil.success(users, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.QUERY_FAILED.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.QUERY_FAILED, throwable);
        }
    }

    @ApiOperation(value = "更新用户", notes = "更新用户信息")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> updateUser(
            @ApiParam(name = "用户信息", required = true) @RequestBody User user) {
        try {
            final User updatedUser = userService.updateEntitySelective(user);
            return MessageUtil.success(updatedUser, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.UPDATE_FAILED.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.UPDATE_FAILED, throwable);
        }
    }


    @ApiOperation(value = "用户登录", notes = "用户登录")
    @GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> login(
            @ApiParam(name = "code", required = true) @RequestParam(name = "code", defaultValue = "") String code) {
        try {
            final User user = userService.login(code);
            return MessageUtil.success(user, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.LOGIN_FAILED.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.LOGIN_FAILED, throwable);
        }
    }
}