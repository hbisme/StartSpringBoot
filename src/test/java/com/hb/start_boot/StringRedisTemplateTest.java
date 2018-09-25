package com.hb.start_boot;

import com.hb.start_boot.service.RedisService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StringRedisTemplateTest {
    private static final Logger logger = LoggerFactory.getLogger(StringRedisTemplateTest.class);

    @Resource
    private RedisService redisService;

    @Test
    public void contextLoads(){
        redisService.setString("name", "hb");
        logger.info("my name is {}", redisService.getString("name")  );


    }

}
