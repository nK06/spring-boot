package com.panther.demo.kafka;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaReceiver {
    private static Logger log = LoggerFactory.getLogger(KafkaReceiver.class);

    @KafkaListener(topics = {TopicConst.EXECUTOR_TOPIC})
    public void listen(String message) {
        log.info("------------------接收消息 message =" + message);
        Message msg = JSON.parseObject(message, Message.class);
        log.info("MessageConsumer: onMessage: message is: [" + msg + "]");
        log.info("------------------ message =" + message);
    }

}
