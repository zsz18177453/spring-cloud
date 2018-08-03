package com.zsz.serviceconsumerfegin.service;

import org.springframework.stereotype.Component;

@Component
public class HelloErrorService implements HelloService{
    @Override
    public String hello(String name) {
        return "你好："+name+"；服务错误";
    }
}
