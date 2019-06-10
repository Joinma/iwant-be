package com.liori.controller.team;

import com.github.pagehelper.PageInfo;
import com.liori.common.message.MessageEnum;
import com.liori.common.utils.message.MessageUtil;
import com.liori.model.team.Team;
import com.liori.service.team.TeamService;
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
 * <p>团队的控制器</p>
 * <b>created on 2019-06-10 20:52:43</b>
 *
 * @author liori
 * @since 0.1
 */
@Api(value = "团队Controller", tags = {"团队接口"})
@RestController
@RequestMapping(value = "/api/teams")
public class TeamController {

    private final static Logger LOG = LoggerFactory.getLogger(TeamController.class);

    @Autowired
    private TeamService teamService;

    @ApiOperation(value = "新增团队", notes = "添加一个团队")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> saveTeam(
            @ApiParam(name = "团队信息", required = true) @RequestBody Team team) {
        try {
            final Team insertedTeam = teamService.saveEntitySelective(team);
            return MessageUtil.success(insertedTeam, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.FAIL_TO_CREATE.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.FAIL_TO_CREATE, throwable);
        }
    }

    @ApiOperation(value = "删除单个团队", notes = "根据 id 删除单个团队信息")
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> deleteTeam(
            @ApiParam(value = "id", required = true) @PathVariable(value = "id") String id) {
        try {
            final String deletedId = teamService.deleteEntity(id);
            return MessageUtil.success(deletedId, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.FAIL_TO_UPDATE.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.FAIL_TO_UPDATE, throwable);
        }
    }

    @ApiOperation(value = "获取单个团队", notes = "根据 id 获取团队信息")
    @GetMapping(value = "/query/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getSingleTeam(
            @ApiParam(value = "id", required = true) @PathVariable(value = "id") String id) {
        try {
            final Team team = teamService.selectSingleEntity(id);
            return MessageUtil.success(team, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.FAIL_TO_QUERY.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.FAIL_TO_QUERY, throwable);
        }
    }

    @ApiOperation(value = "根据参数分页获取团队", notes = "根据参数分页获取团队信息")
    @GetMapping(value = "/query", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getteams(
            @ApiParam(value = "页码", defaultValue = "1") @RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
            @ApiParam(value = "每页加载量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        try {
            Team team = new Team();
            final PageInfo<Team> teams = teamService.selectTeamsByExample(team, pageNum, pageSize);
            return MessageUtil.success(teams, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.FAIL_TO_QUERY.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.FAIL_TO_QUERY, throwable);
        }
    }

    @ApiOperation(value = "更新团队", notes = "更新团队信息")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> updateTeam(
          @ApiParam(name = "团队信息", required = true) @RequestBody Team team) {
        try {
            final Team updatedTeam = teamService.updateEntitySelective(team);
            return MessageUtil.success(updatedTeam, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.FAIL_TO_UPDATE.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.FAIL_TO_UPDATE, throwable);
        }
    }
}