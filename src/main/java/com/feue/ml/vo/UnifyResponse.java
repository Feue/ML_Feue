package com.feue.ml.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Feue
 * @create 2022-04-17 14:33
 */
@Getter
@Setter
public class UnifyResponse<T> {
    private int code;
    private T result;
    private String message;
    private String requestUrl;

    public UnifyResponse(String message) {
        this.message = message;
    }

    public UnifyResponse(T result, String message) {
        this.result = result;
        this.message = message;

        this.code = 0;
    }

    public UnifyResponse(int code, String message, String requestUrl) {
        this.code = code;
        this.message = message;
        this.requestUrl = requestUrl;
    }
}
