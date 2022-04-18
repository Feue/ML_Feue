package com.feue.ml.core;

import com.feue.ml.core.configuration.ExceptionCodeConfiguration;
import com.feue.ml.exception.HttpException;
import com.feue.ml.vo.UnifyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Feue
 * @create 2022-04-17 15:31
 */
@ControllerAdvice
public class GlobalExceptionAdvice {
    @Autowired
    private ExceptionCodeConfiguration codeConfiguration;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public UnifyResponse handleException(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        String url = request.getRequestURI();
        String method = request.getMethod();
        return new UnifyResponse(9999, "服务器异常", method+" "+url);
    }

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<UnifyResponse> handleHttpException(HttpServletRequest request, HttpException e) {
        e.printStackTrace();
        String url = request.getRequestURI();
        String method = request.getMethod();
        UnifyResponse response = new UnifyResponse(e.getCode(), codeConfiguration.getMessage(e.getCode()), method+" "+url);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpStatus status = HttpStatus.resolve(e.getHttpStatusCode());
        return new ResponseEntity<>(response, headers, status);
    }
}
