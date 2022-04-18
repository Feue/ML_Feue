package com.feue.ml.exception;

/**
 * @author Feue
 * @create 2022-04-17 15:29
 */
public class ParameterException extends HttpException {
    public ParameterException(int code) {
        this.code = code;
        this.httpStatusCode = 400;
    }
}
