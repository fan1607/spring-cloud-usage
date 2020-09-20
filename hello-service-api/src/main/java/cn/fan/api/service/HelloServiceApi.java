package cn.fan.api.service;

import cn.fan.api.dto.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/refactor")
public interface HelloServiceApi {

    @GetMapping("/hello1")
    String hello(@RequestParam String name);

    @GetMapping("/hello2")
    User hello(@RequestHeader String name, @RequestHeader Integer age);

    @PostMapping("/hello3")
    String hello(@RequestBody User user);
}
