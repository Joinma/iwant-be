package com.liori.mapper.plan;

import com.liori.mapper.base.BaseMapper;
import com.liori.model.plan.Plan;
import com.liori.model.plan.PlanExample;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>计划的映射器</p>
 * <b>created on 2019-06-10 21:03:34</b>
 *
 * @author liori
 * @since 0.1
 */
@Mapper
@Repository
public interface PlanMapper extends BaseMapper<Plan, PlanExample> {

}