package com.kg.impl.feign.hystix;

import com.kg.impl.feign.OrderServiceFeign;
import org.springframework.stereotype.Component;


@Component
public class OrderServiceHystrix implements OrderServiceFeign {
	@Override
	public String getOrder() {
		return "熔断";
	}

	@Override
	public Integer getOrderCount() {
		return -99;
	}
}