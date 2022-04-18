package com.feue.ml.exception;

/**
 * @author Feue
 * @create 2022-04-18 14:43
 */
public class UnAuthenticatedException extends HttpException {
    public UnAuthenticatedException(int code) {
        this.code = code;
        this.httpStatusCode = 401;
    }
}
