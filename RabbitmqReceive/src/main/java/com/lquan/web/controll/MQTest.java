package com.lquan.web.controll;

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

    @ResponseBody
    @RequestMapping("/rev")
    public  String message(){


        return  "hello 接受";
    }
}
