package com.zsz.serviceconsumerfegin.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-provider",fallback = HelloErrorService.class)
public interface HelloService {
    @RequestMapping("/hello")
    String hello(@RequestParam(value = "name") String name);
}
