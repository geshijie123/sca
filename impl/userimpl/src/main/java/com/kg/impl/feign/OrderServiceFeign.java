package com.kg.impl.feign;

import com.kg.impl.feign.hystix.OrderServiceHystrix;
import com.kg.order.OrderService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "order"/*,fallback = OrderServiceHystrix.class*/)
//@FeignClient(name = "order",fallback = OrderServiceHystrix.class)
public interface OrderServiceFeign extends OrderService {
}
