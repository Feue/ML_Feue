package com.feue.ml.exception;

/**
 * @author Feue
 * @create 2022-04-17 15:30
 */
public class ServerErrorException extends HttpException {
    public ServerErrorException(int code) {
        this.code = code;
        this.httpStatusCode = 500;
    }
}
