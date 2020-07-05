package org.example.exception;

import lombok.Data;

/**
 * @author xunlailiu
 * @date 2020/07/03
 */
@Data
public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    public Result(){}

    public Result(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(ResultEnum resultEnum){
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    public Result(ResultEnum resultEnum, T data){
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.data = data;
    }

    /**
     * 自定义异常返回的结果
     * @param definitionException 自定义异常处理类
     * @return 返回自定义异常
     */
    public static Result<Object> defineError(DefinitionException definitionException) {
        return new Result<>(definitionException.getErrorCode(), definitionException.getErrorMessage());
    }

    /**
     * 其他异常处理方法返回的结果
     * @param resultEnum 自定义枚举类，包含 code 和 message
     * @return 返回其他异常
     */
    public static Result<Object> otherError(ResultEnum resultEnum) {
        return new Result<>(resultEnum);
    }


}