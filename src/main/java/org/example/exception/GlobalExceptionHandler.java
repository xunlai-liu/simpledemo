package org.example.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author xunlailiu
 * @date 2020/07/03
 */
@RestControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(value = DefinitionException.class)
    @ResponseBody
    public Result<Object> customExceptionHandler(DefinitionException e){
        return Result.defineError(e);
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<Object> exceptionHandler(Exception e){
        return Result.otherError(ResultEnum.SERVER_ERROR);
    }
}
