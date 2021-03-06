package com.lquan.mq.recv.config.workqueue;

import com.lquan.common.QueueUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName Consumer
 * 普通的工作模式
 *          rabbitmq消费者 @RabbitListener(queues = "simpleMsg") 监听名simpleMsg的队列
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/

@Component
@RabbitListener(queues = QueueUtils.QUEUE_WORK_QUEUE)
public class Consumer{

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 消息消费
     * @RabbitHandler 代表此方法为接受到消息后的处理方法
     */
    @RabbitHandler
    public void recieved(String msg){
        System.out.println("Rabbit WORK—QUEUE："+msg);

    }

}
