package cn.fan.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RefreshScope
@RestController
public class TestController {

//    @Value("${from}")
//    private String from;

    @Resource
    private Environment env;

    @RequestMapping("/from")
    public String from() {
//        return this.from;
        return env.getProperty("from", "undefined");
    }
}
