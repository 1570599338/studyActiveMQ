package com.lquan.web.controll;

import com.lquan.mq.send.config.fanout.FanoutProduct;
import com.lquan.mq.send.config.topic.TopicProduct;
import com.lquan.mq.send.config.workqueue.WorkQueueProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName MQTest
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/

@RestController
public class MQTest{

    @Autowired
    private WorkQueueProducer producer;

    @ResponseBody
    @RequestMapping("/msg")
    public  String message(){


        return  "hello";
    }



    @ResponseBody
    @RequestMapping("/wq")
    public  String workQueue(){
        System.out.println("**************");

        return  producer.Send();
    }



    @Autowired
    private FanoutProduct product;

    /**
     * fanout 模式
     * @return
     */
    @ResponseBody
    @RequestMapping("/fanout")
    public  String message2(){


        return  product.fanoutSend();
    }

    @Autowired
    private TopicProduct topicProduct;

    @ResponseBody
    @RequestMapping("/top")
    public  String message3(){

        topicProduct.fanoutSend("topic.msg");

        topicProduct.fanoutSend("topic.good.msg");

        topicProduct.fanoutSend("topic.m.z");


        return  topicProduct.fanoutSend("topic.msg")+"^^^^^"+
                topicProduct.fanoutSend("topic.good.msg")+"^^^^^"+
                topicProduct.fanoutSend("topic.m.z");
    }



}
