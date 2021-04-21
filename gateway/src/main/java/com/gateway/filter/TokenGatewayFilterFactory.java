package com.gateway.filter;

import com.google.common.collect.Lists;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TokenGatewayFilterFactory extends AbstractGatewayFilterFactory<TokenGatewayFilterFactory.Config> {

    Logger log = LoggerFactory.getLogger(getClass());

    public TokenGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Lists.newArrayList("tokenName");
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            log.info("每次路由匹配到会执行");
            String tokenName = config.getTokenName();
            log.info("从配置文件中获取到的 tokenName 的值=[{}].", tokenName);
            String value = exchange.getRequest().getQueryParams().getFirst(tokenName);
            log.info("从请求中获取到的token value 是:[{}]", value);
            return chain.filter(exchange);
        };
    }

    @Data
    public static class Config {
        private String tokenName;
    }
}