package org.example.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 *  全局异常处理
 * @author xunlailiu
 * @date 2020/07/03
 */
//@ControllerAdvice

public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public String exceptionHandler(Exception e){
        return e.getMessage();
    }

}
