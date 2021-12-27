package com.github.lastsunday.cloud.replacetable.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.github.lastsunday.cloud.replacetable.bo.OrderBO;
import com.github.lastsunday.cloud.replacetable.entity.OrderEntity;
import com.github.lastsunday.cloud.replacetable.mapper.OrderMapper;
import com.github.lastsunday.cloud.replacetable.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private UserService userService;

    //access url http://localhost:7867/test/1
    @GetMapping(path = "/test/{tenantId}")
    public String test(@PathVariable Long tenantId) throws JsonProcessingException {
        userService.login(tenantId);
        OrderBO orderBO = new OrderBO();
        List<OrderEntity> result = orderMapper.selectOrder(orderBO);
        JsonMapper jsonMapper = new JsonMapper();
        return jsonMapper.writeValueAsString(result);
    }
}
