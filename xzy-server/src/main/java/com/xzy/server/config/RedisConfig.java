package com.xzy.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author luobo
 * @Date 2022-12-23
 **/
@Configuration
@ConfigurationProperties(prefix = "redis")
public class RedisConfig {

    private String host;
    private Integer port;
    private Integer timeout;
    private String password;
    private Integer db;
    private Integer poolMaxTotal;
    private Integer poolMaxIdle;
    private Integer poolMinIdle;
    private Long maxWaitMillis;

    @Bean
    public JedisPool jedisPool() {
        return new JedisPool(getUserConfig(), host, port, timeout, password, db);
    }

    private JedisPoolConfig getUserConfig() {
        JedisPoolConfig jconfig = new JedisPoolConfig();
        jconfig.setMaxIdle(poolMaxIdle);
        jconfig.setTestOnBorrow(true);
        jconfig.setMaxTotal(poolMaxTotal);
        jconfig.setMinIdle(poolMinIdle);
        jconfig.setMaxWaitMillis(maxWaitMillis);
        return jconfig;
    }
}
