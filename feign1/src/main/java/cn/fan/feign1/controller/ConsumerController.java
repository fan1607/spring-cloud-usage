package cn.fan.feign1.controller;

import cn.fan.feign1.dto.User;
import cn.fan.feign1.service.HelloService;
import cn.fan.feign1.service.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @Autowired
    RefactorHelloService refactorHelloService;

    @GetMapping("/feign-consumer")
    public String helloConsumer() {
        return helloService.hello();
    }

    @GetMapping("/feign-consumer2")
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("<br>")
                .append(helloService.hello("fan")).append("<br>")
                .append(helloService.hello("fan", 28)).append("<br>")
                .append(helloService.hello(new User("fan", 28))).append("<br>");
        return sb.toString();
    }

    @GetMapping("/feign-consumer3")
    public String helloConsumer3() {
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("fan")).append("<br>")
                .append(refactorHelloService.hello("fan", 28)).append("<br>")
                .append(refactorHelloService.hello(new cn.fan.api.dto.User("fan", 28))).append("<br>");
        return sb.toString();
    }

    @GetMapping("/feign-timeout")
    public String helloWait() {
        return helloService.helloWait();
    }
}
