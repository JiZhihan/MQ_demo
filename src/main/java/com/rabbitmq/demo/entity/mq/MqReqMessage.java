package com.rabbitmq.demo.entity.mq;

import lombok.Data;

import java.io.Serializable;

/**
 * rabbitMq通信请求消息
 */
@Data
public class MqReqMessage implements Serializable {

    private String sendId;//发送ID
    private String msgId;//消息ID
    private Object data;
    private String loginToken;
    private String openAppKey;
}
