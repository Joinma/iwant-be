package com.liori.service.plan.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liori.mapper.base.BaseMapper;
import com.liori.mapper.plan.PlanMapper;
import com.liori.model.plan.Plan;
import com.liori.model.plan.PlanExample;
import com.liori.service.base.impl.BaseServiceImpl;
import com.liori.service.plan.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


/**
 * <p>计划的接口实现类</p>
 * <b>created on 2019-06-10 21:03:34</b>
 *
 * @author liori
 * @since 0.1
 */
@Service
public class PlanServiceImpl extends BaseServiceImpl<Plan, PlanExample> implements PlanService {


    @Autowired
    private PlanMapper planMapper;

     @Override
    public BaseMapper<Plan, PlanExample> getSpecificMapper() {
        return planMapper;
    }

    @Override
    public PageInfo<Plan> selectPlansByExample(Plan plan, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        PlanExample planExample = new PlanExample();
        List<Plan> plans = planMapper.selectByExample(planExample);
        return new PageInfo<>(plans);
    }
}
