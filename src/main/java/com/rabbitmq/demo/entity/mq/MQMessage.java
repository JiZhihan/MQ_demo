package com.rabbitmq.demo.entity.mq;

import lombok.Data;

import java.io.Serializable;

@Data
public class MQMessage implements Serializable {

    private String sendId;//发送ID
    private String msgId;//消息ID
    private Object data;
}
