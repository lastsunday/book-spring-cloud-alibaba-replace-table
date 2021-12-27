package com.github.lastsunday.cloud.replacetable.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.lastsunday.cloud.replacetable.bo.OrderBO;
import com.github.lastsunday.cloud.replacetable.entity.OrderEntity;

import java.util.List;

public interface OrderMapper extends BaseMapper<OrderEntity> {

    List<OrderEntity> selectOrder(OrderBO orderBO);
}
