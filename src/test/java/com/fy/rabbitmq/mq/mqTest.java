package com.fy.rabbitmq.mq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　 ┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　  ┃
 * 　　┃　　　　　　 ┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　 ┃
 * 　　┗━┓　　　┏━┛Faith and purpose must always be in the heart of the programmer
 * 　　　　┃　　　┃
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 *
 * @Author: fly
 * @Description:
 */

@SpringBootTest
public class mqTest {
    @Autowired
    RabbitTemplate template;

    //交换器 - fanout 测试发送消息给交换器
    @Test
    public void t1(){
        template.convertAndSend("ex-f","","测试001");
    }

    //交换器 - direct 测试发送消息给交换器
    @Test
    public void t2(){
        template.convertAndSend("ex-d","error","看看我在哪？");
    }

    //交换器 - topic 测试发送消息给交换器
    @Test
    public void t3(){
        //测试 user.*  *代表1个单词后缀
//        template.convertAndSend("ex-t","user","用户");
//        template.convertAndSend("ex-t","user.add","用户新增");//匹配
//        template.convertAndSend("ex-t","user.del.a","用户删除");
        //测试 order.#  #代表多个单词后缀
        template.convertAndSend("ex-t","order","订单");//匹配
        template.convertAndSend("ex-t","order.add","订单新增");//匹配
        template.convertAndSend("ex-t","order.query.del","订单删除");//匹配
    }
}
