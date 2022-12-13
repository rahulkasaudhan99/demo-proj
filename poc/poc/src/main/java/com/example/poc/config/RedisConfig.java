package com.example.poc.config;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * The Class RedisConfig.
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport implements CachingConfigurer {
    @Bean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory connectionFactory) {
        Map<String, RedisCacheConfiguration> cacheNamesConfigurationMap = new HashMap<>();
        cacheNamesConfigurationMap.put("productsDetails", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(10000)));
        RedisCacheManager redisCacheManager =  new RedisCacheManager(RedisCacheWriter.lockingRedisCacheWriter(connectionFactory),
                RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(10000)),
                cacheNamesConfigurationMap);
        redisCacheManager.setTransactionAware(false);
        return redisCacheManager;
    }


}
