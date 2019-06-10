package com.liori.controller.teamuser;

import com.github.pagehelper.PageInfo;
import com.liori.common.message.MessageEnum;
import com.liori.common.utils.message.MessageUtil;
import com.liori.model.teamuser.TeamUser;
import com.liori.service.teamuser.TeamUserService;
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


/**
 * <p>团队成员的控制器</p>
 * <b>created on 2019-06-10 21:09:59</b>
 *
 * @author liori
 * @since 0.1
 */
@Api(value = "团队成员Controller", tags = {"团队成员接口"})
@RestController
@RequestMapping(value = "/api/teamusers")
public class TeamUserController {

    private final static Logger LOG = LoggerFactory.getLogger(TeamUserController.class);

    @Autowired
    private TeamUserService teamUserService;

    @ApiOperation(value = "新增团队成员", notes = "添加一个团队成员")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> saveTeamUser(
            @ApiParam(name = "团队成员信息", required = true) @RequestBody TeamUser teamUser) {
        try {
            final TeamUser insertedTeamUser = teamUserService.saveEntitySelective(teamUser);
            return MessageUtil.success(insertedTeamUser, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.FAIL_TO_CREATE.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.FAIL_TO_CREATE, throwable);
        }
    }

    @ApiOperation(value = "删除单个团队成员", notes = "根据 id 删除单个团队成员信息")
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> deleteTeamUser(
            @ApiParam(value = "id", required = true) @PathVariable(value = "id") String id) {
        try {
            final String deletedId = teamUserService.deleteEntity(id);
            return MessageUtil.success(deletedId, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.FAIL_TO_UPDATE.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.FAIL_TO_UPDATE, throwable);
        }
    }

    @ApiOperation(value = "获取单个团队成员", notes = "根据 id 获取团队成员信息")
    @GetMapping(value = "/query/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getSingleTeamUser(
            @ApiParam(value = "id", required = true) @PathVariable(value = "id") String id) {
        try {
            final TeamUser teamUser = teamUserService.selectSingleEntity(id);
            return MessageUtil.success(teamUser, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.FAIL_TO_QUERY.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.FAIL_TO_QUERY, throwable);
        }
    }

    @ApiOperation(value = "根据参数分页获取团队成员", notes = "根据参数分页获取团队成员信息")
    @GetMapping(value = "/query", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getteamUsers(
            @ApiParam(value = "页码", defaultValue = "1") @RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
            @ApiParam(value = "每页加载量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        try {
            TeamUser teamUser = new TeamUser();
            final PageInfo<TeamUser> teamUsers = teamUserService.selectTeamUsersByExample(teamUser, pageNum, pageSize);
            return MessageUtil.success(teamUsers, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.FAIL_TO_QUERY.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.FAIL_TO_QUERY, throwable);
        }
    }

    @ApiOperation(value = "更新团队成员", notes = "更新团队成员信息")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> updateTeamUser(
          @ApiParam(name = "团队成员信息", required = true) @RequestBody TeamUser teamUser) {
        try {
            final TeamUser updatedTeamUser = teamUserService.updateEntitySelective(teamUser);
            return MessageUtil.success(updatedTeamUser, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.FAIL_TO_UPDATE.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.FAIL_TO_UPDATE, throwable);
        }
    }
}