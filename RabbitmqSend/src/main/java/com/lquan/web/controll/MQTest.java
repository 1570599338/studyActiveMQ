package com.lquan.web.controll;

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
    @RequestMapping("/workQueue")
    public  String workQueue(){
        System.out.println("**************");

        return  producer.Send();
    }

}
