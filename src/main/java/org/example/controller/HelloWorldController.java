package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.exception.DefinitionException;
import org.example.exception.Result;
import org.example.exception.ResultEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xunlailiu
 * @date 2020/07/03
 */
@Slf4j
@RestController
@RequestMapping("hello")
public class HelloWorldController {

    @GetMapping("get")
    public Result<String> get(){
        return new Result<>(ResultEnum.SUCCESS, "hello DSM");
    }

    @RequestMapping("deExcp")
    public Result<String> deException(){
        if (true){
            throw new DefinitionException(ResultEnum.SERVER_ERROR.getCode(), "出错了");
        }
        return new Result<>(ResultEnum.SUCCESS, "");
    }

    @RequestMapping("normalExcp")
    public Result normalExcp(){
        int a = 1/0;
        return new Result();
    }

}
