package cn.fan.controller;

import cn.fan.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Resource
    private Registration registration;

    @Resource
    private DiscoveryClient client;

    @GetMapping("/hello")
    public String index() {
        List<String> instanceIds = new ArrayList<>();
        List<ServiceInstance> instances = client.getInstances(registration.getServiceId());
        for (ServiceInstance instance : instances) {
//            LOGGER.info("/hello, host: {}, service_id: {}", instance.getHost(), instance.getServiceId());
            instanceIds.add(instance.getInstanceId());
        }
        LOGGER.info("/hello, available-instances: {}", instanceIds.toString());
        return "hello";
    }

    @GetMapping("/hello-wait")
    public String hello() throws Exception {
        // 让处理线程等待几秒钟
        int sleepTime = ThreadLocalRandom.current().nextInt(2500);
        LOGGER.info("sleepTime: {}", sleepTime);
        Thread.sleep(sleepTime);
        return "hello word";
    }

    // ---------------- feign ----------------

    @GetMapping("/hello1")
    public String hello1(@RequestParam String name) {
        return "Hello, " + name;
    }

    @GetMapping("/hello2")
    public User hello2(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @PostMapping("/hello3")
    public String hello3(@RequestBody User user) {
        return "Hello, " + user.getName() + ", " + user.getAge();
    }

}
