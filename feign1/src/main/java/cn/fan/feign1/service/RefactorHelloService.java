package cn.fan.feign1.service;

import cn.fan.api.service.HelloServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "HELLO-SERVICE")
public interface RefactorHelloService extends HelloServiceApi {

}
