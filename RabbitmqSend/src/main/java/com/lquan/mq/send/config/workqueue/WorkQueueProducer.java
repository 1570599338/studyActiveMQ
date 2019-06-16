package com.lquan.mq.send.config.workqueue;

import com.lquan.common.QueueUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName WorkQueueProducer
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/

@Component
public class WorkQueueProducer{

    @Autowired
    private AmqpTemplate template;

    public String Send(){

        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-mm-DD hh:MM:ss").format(date);
        System.out.println("[string] send msg:" + dateString);
        // 第一个参数为刚刚定义的队列名称
        this.template.convertAndSend(QueueUtils.QUEUE_WORK_QUEUE, dateString);

        return  dateString;

    }


}
