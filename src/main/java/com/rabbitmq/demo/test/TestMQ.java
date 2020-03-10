package com.rabbitmq.demo.test;


import com.rabbitmq.demo.mq.ProducerOne;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMQ {


    @Autowired
    private ProducerOne p1;

    @Test
    public void test() throws Exception {
//        p1.sendString();
//        p1.sendEntity();
    }

}
