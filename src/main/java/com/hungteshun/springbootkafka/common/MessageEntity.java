package com.hungteshun.springbootkafka.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author hungteshun
 * @description:
 * @date 2018/10/23 08:14
 */
@Getter
@Setter
@EqualsAndHashCode
public class MessageEntity {

    private String title;

    private String body;

    @Override
    public String toString() {
        return "MessageEntity{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
