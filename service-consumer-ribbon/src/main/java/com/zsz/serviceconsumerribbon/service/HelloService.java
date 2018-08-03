package com.zsz.serviceconsumerribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "sayError")
    public String sayHello(String name){
        return  restTemplate.getForObject("http://service-provider/hello?name="+name,String.class);
    }

    public String sayError(String name){
        return "你好："+name+"；服务错误";
    }
}
