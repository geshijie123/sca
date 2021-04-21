package com.kg.impl.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sentinel")
public class SentinelController {


    static final String APITEST_KET="apitest";


    // 或者注释下面 注解使用SentinelExceptionHandle 全局异常拦截
//    @SentinelResource(value = APITEST_KET,blockHandler = "apitestblockHandler",fallback ="apitestfallback" )
    @SentinelResource(value = APITEST_KET)
    @RequestMapping("/apitest")
    public Object apitest(Integer userId){
        return "访问成功~~";
    }

    public Object apitestfallback(Integer userId){
        return "服务降级fallback~~";
    }
    public Object apitestblockHandler(Integer userId){
        return "服务流量控制blockHandler~~";
    }
}
