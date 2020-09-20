package cn.fan.feign1.service;

import cn.fan.feign1.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 服务名不区分大小写
 */
//@FeignClient(name = "hello-service", fallback = HelloServiceFallback.class)
//@FeignClient(name = "hello-service", configuration = FullLogConfiguration.class)
@FeignClient("hello-service")
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

    @GetMapping("/hello1")
    String hello(@RequestParam String name);

    @GetMapping("/hello2")
    User hello(@RequestHeader String name, @RequestHeader Integer age);

    @PostMapping("/hello3")
    String hello(@RequestBody User user);

    /**
     * 超时配置验证
     */
    @RequestMapping("/hello-wait")
    String helloWait();
}
