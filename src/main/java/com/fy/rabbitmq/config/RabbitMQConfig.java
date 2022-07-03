package com.fy.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
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
 * @Description:
 */

@Configuration
public class RabbitMQConfig {
    //创建队列
    @Bean
    public Queue createq1(){
        return new Queue("fly");
    }


    /**
     *  学习 交换器 - fanout 直接转发
     *  交换器改变的是发送端 而不是消费端
     *  绑定几个队列 几个队列都能同时接收消息 因此 交换器发送一个消息能被所有绑定的队列进行消费 (一条消息能被消费多次)
     */
    //1.1 创建交换器 用哪个交换器就创建哪个
    @Bean
    public FanoutExchange create(){
        return new FanoutExchange("ex-f");
    }
    //1.2 创建2个队列
    @Bean
    public Queue createF1(){  //队列1
        return new Queue("q_fanout_01");
    }
    @Bean
    public Queue createF2(){ //队列2
        return new Queue("q_fanout_02");
    }
    //1.3 创建队列和交换器绑定
    @Bean
    public Binding createB1(FanoutExchange fe){
        //把队列绑定到交换器上
        return BindingBuilder.bind(createF1()).to(fe);//绑定队列1
    }
    @Bean
    public Binding createB2(FanoutExchange fe){
        return BindingBuilder.bind(createF2()).to(fe);//绑定队列2
    }
}
