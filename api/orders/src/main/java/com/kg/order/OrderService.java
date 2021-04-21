package com.kg.order;

import org.springframework.web.bind.annotation.RequestMapping;

public interface OrderService {
    @RequestMapping("getOrder")
    String getOrder();
    @RequestMapping("getCount")
    Integer getOrderCount();
}
