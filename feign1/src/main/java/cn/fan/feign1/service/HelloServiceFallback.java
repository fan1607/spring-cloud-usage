package cn.fan.feign1.service;

import cn.fan.feign1.dto.User;
import org.springframework.stereotype.Component;

/**
 * 需要启用Hystrix：feign.hystrix.enabled=true
 */
@Component
public class HelloServiceFallback implements HelloService {

    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(String name) {
        return "error";
    }

    @Override
    public User hello(String name, Integer age) {
        return new User("未知", 0);
    }

    @Override
    public String hello(User user) {
        return "error";
    }

    @Override
    public String helloWait() {
        return "error";
    }
}
