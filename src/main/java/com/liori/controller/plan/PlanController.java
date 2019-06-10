package com.liori.controller.plan;

import com.github.pagehelper.PageInfo;
import com.liori.common.message.MessageEnum;
import com.liori.common.utils.message.MessageUtil;
import com.liori.model.plan.Plan;
import com.liori.service.plan.PlanService;
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
 * <p>计划的控制器</p>
 * <b>created on 2019-06-10 21:03:34</b>
 *
 * @author liori
 * @since 0.1
 */
@Api(value = "计划Controller", tags = {"计划接口"})
@RestController
@RequestMapping(value = "/api/plans")
public class PlanController {

    private final static Logger LOG = LoggerFactory.getLogger(PlanController.class);

    @Autowired
    private PlanService planService;

    @ApiOperation(value = "新增计划", notes = "添加一个计划")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> savePlan(
            @ApiParam(name = "计划信息", required = true) @RequestBody Plan plan) {
        try {
            final Plan insertedPlan = planService.saveEntitySelective(plan);
            return MessageUtil.success(insertedPlan, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.FAIL_TO_CREATE.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.FAIL_TO_CREATE, throwable);
        }
    }

    @ApiOperation(value = "删除单个计划", notes = "根据 id 删除单个计划信息")
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> deletePlan(
            @ApiParam(value = "id", required = true) @PathVariable(value = "id") String id) {
        try {
            final String deletedId = planService.deleteEntity(id);
            return MessageUtil.success(deletedId, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.FAIL_TO_UPDATE.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.FAIL_TO_UPDATE, throwable);
        }
    }

    @ApiOperation(value = "获取单个计划", notes = "根据 id 获取计划信息")
    @GetMapping(value = "/query/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getSinglePlan(
            @ApiParam(value = "id", required = true) @PathVariable(value = "id") String id) {
        try {
            final Plan plan = planService.selectSingleEntity(id);
            return MessageUtil.success(plan, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.FAIL_TO_QUERY.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.FAIL_TO_QUERY, throwable);
        }
    }

    @ApiOperation(value = "根据参数分页获取计划", notes = "根据参数分页获取计划信息")
    @GetMapping(value = "/query", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getplans(
            @ApiParam(value = "页码", defaultValue = "1") @RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
            @ApiParam(value = "每页加载量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        try {
            Plan plan = new Plan();
            final PageInfo<Plan> plans = planService.selectPlansByExample(plan, pageNum, pageSize);
            return MessageUtil.success(plans, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.FAIL_TO_QUERY.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.FAIL_TO_QUERY, throwable);
        }
    }

    @ApiOperation(value = "更新计划", notes = "更新计划信息")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> updatePlan(
          @ApiParam(name = "计划信息", required = true) @RequestBody Plan plan) {
        try {
            final Plan updatedPlan = planService.updateEntitySelective(plan);
            return MessageUtil.success(updatedPlan, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.FAIL_TO_UPDATE.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.FAIL_TO_UPDATE, throwable);
        }
    }
}