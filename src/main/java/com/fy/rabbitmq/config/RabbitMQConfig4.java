package com.fy.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
 * @Description: 交换器 - direct
 */

@Configuration
public class RabbitMQConfig4 {

    /**
     *  学习 交换器 - topic 路由模糊匹配
     *  #: 匹配1个单词后缀
     *  *：匹配0或多个单词后缀
     *
     */
    //1.1 创建交换器 用哪个交换器就创建哪个
    @Bean
    public TopicExchange create(){
        return new TopicExchange("ex-t");
    }
    //1.2 创建2个队列
    @Bean
    public Queue createD1(){  //队列1
        return new Queue("q_topic_01");
    }
    @Bean
    public Queue createD2(){ //队列2
        return new Queue("q_topic_02");
    }
    //1.3 创建队列和交换器绑定
    @Bean
    public Binding createB1(TopicExchange te){
        //把队列绑定到交换器上
        //with("log1")：路由关键字
        return BindingBuilder.bind(createD1()).to(te).with("user.*");//绑定队列1
    }
    @Bean
    public Binding createB2(TopicExchange te){
        return BindingBuilder.bind(createD2()).to(te).with("order.#");//绑定队列2
    }
}
