package com.rabbitmq.demo.mq;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.demo.entity.business.BsFinanceLoanResult;
import com.rabbitmq.demo.entity.mq.MQMessage;
import com.rabbitmq.demo.entity.mq.MqReqMessage;
import com.rabbitmq.demo.util.GUIDUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class ProducerOne {

    @Resource
    private RabbitTemplate mq;

    public void send(Object object) {
        MQMessage message = new MQMessage();
        message.setMsgId("supplierInfo");
        message.setData(object);
        message.setSendId(GUIDUtil.genRandomGUID());
        System.out.println(String.format("生产消息，消息处理方法：%s, 消息内容：%s", message.getMsgId(), JSON.toJSONString(message.getData())));
        //1.找到交换器，但是找不到队列，confirmCallback（返回true)和returnCallback都会被触发
        //mq.convertAndSend("no chain", JSON.toJSONString(message));
        //2.找不到交换器，只有confirmCallback被触发（返回false)
        //mq.convertAndSend("no exchange","routingKey",JSON.toJSONString(message));
        //3.找到队列，只有confirmCallback被触发（返回true)
        mq.convertAndSend(RabbitConfig.QUEUE_TO_BGY_SUPPLIER_INFO_CHAIN,JSON.toJSONString(message));
    }
}
