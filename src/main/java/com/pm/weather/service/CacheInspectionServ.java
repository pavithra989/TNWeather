package com.pm.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class CacheInspectionServ {
    @Autowired
    private CacheManager cacheManager;

    public void printCacheContents(String cacheName){
        Cache cache = cacheManager.getCache(cacheName);
        if( cache!= null) {
            System.out.println("Cache contents");
            System.out.println(Objects.requireNonNull(cache.getNativeCache()));
        }else {
            System.out.println("no such cache :"+ cacheName);
        }
    }
}
