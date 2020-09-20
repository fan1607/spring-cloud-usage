package cn.fan.controller;

import cn.fan.api.dto.User;
import cn.fan.api.service.HelloServiceApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefactorHelloController implements HelloServiceApi {

    @Override
    public String hello(String name) {
        return "Hello" + name;
    }

    @Override
    public User hello(String name, Integer age) {
        return new User(name, age);
    }

    @Override
    public String hello(User user) {
        return "Hello, " + user.getName() + ", " + user.getAge();
    }
}
