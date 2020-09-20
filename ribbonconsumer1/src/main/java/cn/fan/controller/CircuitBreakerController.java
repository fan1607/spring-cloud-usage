package cn.fan.controller;

import cn.fan.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {

    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/circuitBreaker")
    public String helloConsumer() {
        return helloService.helloService();
    }
}
