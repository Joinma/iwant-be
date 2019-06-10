package com.liori.service.plan;

import com.github.pagehelper.PageInfo;
import com.liori.model.plan.Plan;
import com.liori.model.plan.PlanExample;
import com.liori.service.base.BaseService;
import org.springframework.stereotype.Service;

/**
 * <p>计划的接口类</p>
 * <b>created on 2019-06-10 21:03:34</b>
 *
 * @author liori
 * @since 0.1
 */
@Service
public interface PlanService extends BaseService<Plan, PlanExample> {

    /**
     * 分页查询计划
     *
     * @param plan
     * @param pageNum 页码
     * @param pageSize 每页加载量
     * @return PageInfo<Plan>
     */
    PageInfo<Plan> selectPlansByExample(Plan plan, Integer pageNum, Integer pageSize);

}
