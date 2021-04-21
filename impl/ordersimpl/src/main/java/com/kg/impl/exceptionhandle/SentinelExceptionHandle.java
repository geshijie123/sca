package com.kg.impl.exceptionhandle;

import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 也可以使用全局exception 来 监控  sentinel 服务限流 降级 熔断
 */
@RestControllerAdvice
public class SentinelExceptionHandle {
    @ResponseBody
    @ExceptionHandler(ParamFlowException.class) //参数的 热点限流
    public String businessInterfaceException(ParamFlowException e) {
        return "您当前访问的频率过高，请稍后重试!";
    }
    @ResponseBody
    @ExceptionHandler(FlowException.class)//普通限流
    public String FlowExceptionException(FlowException e) {
        return "您当前访问的频率过高，请稍后重试!";
    }
}
