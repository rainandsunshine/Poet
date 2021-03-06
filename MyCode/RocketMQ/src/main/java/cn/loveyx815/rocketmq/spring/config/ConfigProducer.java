package cn.loveyx815.rocketmq.spring.config;

import javax.swing.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.loveyx815.rocketmq.spring.MessageListener;
import cn.loveyx815.rocketmq.spring.SpringCousumer;
import cn.loveyx815.rocketmq.spring.SpringProducer;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/01/30 17:26
 * @Description: 消息生产者实例配置
 */
@Configuration
public class ConfigProducer {

    @Autowired
    private ApplicationContext applicationContext;
    /*
     * @Description: 生产者实例化
     * @Param: []
     * @Return: cn.loveyx815.rocketmq.spring.SpringProducer
     * @Author: Yonggang Shi
     * @Date: 2020/1/30/030 下午 5:35
     */
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public SpringProducer getProducer(){
        return new SpringProducer("spring_producer_group","114.55.254.102:9876");

    }

    @Bean(name = "messageListener")
    public MessageListener messageListener(){
        return  new MessageListener();
    }

    @Bean(initMethod = "init",destroyMethod = "destory")
    public SpringCousumer getCousumer(){
        //ApplicationContext context =
        return new SpringCousumer("spring_producer_group","114.55.254.102:9876","spring-rocketMQ-topic",messageListener());

    }
}
