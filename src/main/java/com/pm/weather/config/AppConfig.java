package com.pm.weather.config;

import com.pm.weather.entity.Weather;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class AppConfig {
    @Bean
    public CacheManager cacheManager()
    {
        return new ConcurrentMapCacheManager("weather");
    }
}
