package com.hb.start_boot.configure;


import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Destination;

/*
* activemq的配置
* */
@Configuration
public class ActiveMqConfig {

    // 发布订阅模式队列名称
    public static final String TOPIC_NAME = "activemq.topic";
    // 点对点模式队列名称
    public static final String QUEUE_NAME = "activemq.queue";

    @Bean
    public Destination topic() {
        return new ActiveMQTopic(TOPIC_NAME);
    }

    @Bean
    public Destination queue() {
        return new ActiveMQQueue(QUEUE_NAME);
    }

}
