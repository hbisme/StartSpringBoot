package com.hb.start_boot.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisService {

    // 注入StringRedisTemplate 类型对象
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /*
    * set redis: string 类型
    * @param key key
    * @param value value
    * */
    public void setString(String key, String value) {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    /*
    * get redis: string 类型
    * */

    public String getString(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }



}
