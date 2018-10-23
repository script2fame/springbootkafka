package com.hungteshun.springbootkafka.producer;

import com.google.gson.Gson;
import com.hungteshun.springbootkafka.common.MessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author hungteshun
 * @description:
 * @date 2018/10/23 08:53
 */
@Slf4j
public class ProducerCallback
        implements ListenableFutureCallback<SendResult<String, MessageEntity>> {

    private final long startTime;

    private final String key;

    private final MessageEntity message;

    public ProducerCallback(long startTime, String key,
            MessageEntity message) {
        this.startTime = startTime;
        this.key = key;
        this.message = message;
    }

    private final Gson gson = new Gson();

    @Override
    public void onFailure(Throwable ex) {
        ex.printStackTrace();
    }

    @Override
    public void onSuccess(SendResult<String, MessageEntity> result) {
        if (result == null) {
            return;
        }

        long elapsedTime = System.currentTimeMillis() - startTime;
        RecordMetadata recordMetadata = result.getRecordMetadata();
        if (recordMetadata != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("message(").append("key = ").append(key).append(",")
                    .append("message = ").append(gson.toJson(message)).append(")")
                    .append("sent to partition(").append(recordMetadata.partition()).append(")")
                    .append("with offset(").append(recordMetadata.offset()).append(")")
                    .append("in ").append(elapsedTime).append(" ms");
            log.info(stringBuilder.toString());
        }
    }
}
