package org.example.exception;

import lombok.Data;

/**
 * @author xunlailiu
 * @date 2020/07/03
 */
@Data
public class DefinitionException extends RuntimeException{

    private Integer errorCode;
    private String errorMessage;

    public DefinitionException(){}
    public DefinitionException(Integer errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
