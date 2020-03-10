package com.rabbitmq.demo.mq;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.demo.entity.business.BsFinanceLoanResult;
import com.rabbitmq.demo.entity.mq.MqReqMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProducerOne {

    @Autowired
    private RabbitTemplate mq;

    public void sendEntity() {
        MqReqMessage msg = new MqReqMessage();
        msg.setData("内容: producer1");
        msg.setSendId(UUID.randomUUID().toString());
        msg.setMsgId("Producer1");
        //简单的消息发送，你们那边应该也是这样用的
        mq.convertAndSend("QUEUE_TO_BGY_SUPPLIER_INFO_CHAIN", msg);

    }

    public void sendString() {
        MqReqMessage msg = new MqReqMessage();
        msg.setData(this.initData());
        msg.setSendId(UUID.randomUUID().toString());
        msg.setMsgId("eNoteFinanceLoanResult");
        //简单的消息发送，你们那边应该也是这样用的
        mq.convertAndSend("QUEUE_ENTROBUS_ENOTE_CHAIN", JSON.toJSONString(msg));
    }

    private BsFinanceLoanResult initData(){
        BsFinanceLoanResult result = new BsFinanceLoanResult();
        result.setId(2);
        result.seteNoteNo("3012019122700012");
        result.setpENoteNo("1002019122601052");
        result.setAmount("2924460.06");
        result.setState("0");
        result.setLoanDate("2020-01-14 17:25:22");
        result.setInstitution("中国银行");
        result.setUuid("2E89DBAA-ED89-4065-B8A8-AEC185CA983C");
        result.setBatchNo("3012019122700012");
        result.setPeriodsNum("1");
        result.setCompany("碧桂园地产集团有限公司");
        result.setBankName("中国银行顺德北滘支行营业部");
        result.setBankAccount("699069027809");
        result.setExpireDate("2020-12-24");
        return result;
    }
}
