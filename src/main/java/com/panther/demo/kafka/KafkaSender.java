package com.panther.demo.kafka;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


/**
 * 消息生产者
 *
 */
@Component
public class KafkaSender<T> {

    private Logger logger = LoggerFactory.getLogger(KafkaSender.class);

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public void send(T obj){
        String jsonObj = JSON.toJSONString(obj);
        logger.info("------------------message = {}",jsonObj);

        //发送消息
        ListenableFuture<SendResult<String,Object>> future = kafkaTemplate.send(TopicConst.EXECUTOR_TOPIC,jsonObj);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                logger.info("Produce: The message failed to be sent:" + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                //TODO 业务处理
                logger.info("Produce: The message was sent successfully:");
                logger.info("Produce: _+_+_+_+_+_+_+ result: " + stringObjectSendResult.toString());
            }
        });
    }

    /**
     * 监听kafka.tut 的 topic
     * 使用@KafkaListener 注解监听 topics 消息
     * @Header(KafkaHeaders.RECEIVED_TOPI 直接获取 topic
     */
    //@KafkaListener(id = "tut",topics = "kafka.tut")
    //public void listen(ConsumerRecord<?,?> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic){
    //    //判断是否为NULL
    //    Optional<?> kafkaMessage = Optional.ofNullable(record.value());
    //    if(kafkaMessage.isPresent()){
    //        Object message = kafkaMessage.get();
    //        logger.info("Receive： +++++++++++++++ Topic:" + topic);
    //        logger.info("Receive： +++++++++++++++ Record:" + record);
    //        logger.info("Receive： +++++++++++++++ Message:" + message);
    //    }
    //}

}
