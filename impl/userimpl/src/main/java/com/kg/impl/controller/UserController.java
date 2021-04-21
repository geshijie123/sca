package com.kg.impl.controller;

import com.google.common.collect.ImmutableMap;
import com.kg.impl.feign.OrderServiceFeign;
import com.kg.impl.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/user")
@RestController
@RefreshScope
public class UserController {

    @Value("${config}")
    private String config;

    @Autowired
    OrderServiceFeign orderService;
    @Autowired
    UserServiceImpl userService;

    @RequestMapping("testRPC")
    public Object test() {
        Map<String, Object> rs = ImmutableMap.of(
                "userService.getUser()", userService.getUser(),
                "orderService.getOrder()", orderService.getOrder(),
                "orderService.getOrderCount()",orderService.getOrderCount());
        return rs;
    }


    @RequestMapping("config")
    public Object config(){
        return  config;
    }
}
