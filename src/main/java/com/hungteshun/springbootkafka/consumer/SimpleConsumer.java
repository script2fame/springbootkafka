package com.hungteshun.springbootkafka.consumer;

import com.google.gson.Gson;
import com.hungteshun.springbootkafka.common.MessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author hungteshun
 * @description:
 * @date 2018/10/23 09:19
 */
@Component
@Slf4j
public class SimpleConsumer {

    private Gson gson = new Gson();

    @KafkaListener(topics = "${kafka.topic.default}", containerFactory = "kafkaListenerContainerFactory")
    public void receive(MessageEntity message) {
        log.info("监听到了新消息：" + gson.toJson(message));
    }
}
