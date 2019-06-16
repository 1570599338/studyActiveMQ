package com.lquan.mq.send.config.workqueue;

import com.lquan.common.QueueUtils;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName WorkQueueConfig
 * rabbitmq配置类
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
@Configuration
public class WorkQueueConfig{

    @Bean
    public Queue StringQueue(){
        return  new Queue(QueueUtils.QUEUE_WORK_QUEUE);
    }
}
