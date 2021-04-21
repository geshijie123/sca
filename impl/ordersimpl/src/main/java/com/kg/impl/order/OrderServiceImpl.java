package com.kg.impl.order;

import com.kg.order.OrderService;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class OrderServiceImpl  implements OrderService {

    @Value("${server.port}")
    String port;

    static AtomicInteger num=new AtomicInteger(0);
    @Override
    public String getOrder() {
        System.out.println(num);
        num.set(num.get()+1);
        try {
            Thread.sleep(RandomUtils.nextInt(800));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "233333333" + port;
    }

    @Override
    public Integer getOrderCount() {
        return 666666;
    }
}
