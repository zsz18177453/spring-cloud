package com.zsz.serviceconsumerfegin.controller;

import com.zsz.serviceconsumerfegin.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;
    @RequestMapping
    public String hello(@RequestParam String name){
        return helloService.hello(name);
    }
}
