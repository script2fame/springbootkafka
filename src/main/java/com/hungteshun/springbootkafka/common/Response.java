package com.hungteshun.springbootkafka.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hungteshun
 * @description:
 * @date 2018/10/23 08:40
 */
@Getter
@Setter
public class Response {

    private int code;

    private String message;

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
