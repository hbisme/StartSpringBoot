package com.hb.start_boot.jms;

import com.hb.start_boot.configure.ActiveMqConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

    /*
    * 点对点消息的消费者
    * */
@Service
public class QueueConsumer {
    @JmsListener(destination = ActiveMqConfig.QUEUE_NAME)
    public void receiveQueueMsg(String msg){
        System.out.println("收到消息为: " + msg);
    }
}
