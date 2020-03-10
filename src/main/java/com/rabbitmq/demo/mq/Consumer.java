package com.rabbitmq.demo.mq;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.rabbitmq.demo.entity.mq.MQMessage;
import com.rabbitmq.demo.entity.mq.MqReqMessage;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Consumer {

    @RabbitHandler
    @RabbitListener(queues = "QUEUE_TO_BGY_SUPPLIER_INFO_CHAIN")
    public void process (Message message , Channel channel) throws IOException {
        System.out.println("[STRING]收到消息:" + new String(message.getBody()));
        //false是确认消息已经消费，true为拒绝
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

}
