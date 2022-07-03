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
public class RabbitMQConfig3 {

    /**
     *  学习 交换器 - direct 精准路由匹配
     *
     */
    //1.1 创建交换器 用哪个交换器就创建哪个
    @Bean
    public DirectExchange create(){
        return new DirectExchange("ex-d");
    }
    //1.2 创建2个队列
    @Bean
    public Queue createD1(){  //队列1
        return new Queue("q_direct_01");
    }
    @Bean
    public Queue createD2(){ //队列2
        return new Queue("q_direct_02");
    }
    //1.3 创建队列和交换器绑定
    @Bean
    public Binding createB1(DirectExchange de){
        //把队列绑定到交换器上
        //with("log1")：路由关键字
        return BindingBuilder.bind(createD1()).to(de).with("log");//绑定队列1
    }
    @Bean
    public Binding createB2(DirectExchange de){
        return BindingBuilder.bind(createD2()).to(de).with("error");//绑定队列2
    }
}
