package cn.fan.feign1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class Fegin1App {

    /**
     * http://localhost:9001/feign-consumer
     * http://localhost:9001/feign-consumer2
     * http://localhost:9001/feign-consumer3
     * http://localhost:9001/feign-timeout
     */
    public static void main(String[] args) {
        SpringApplication.run(Fegin1App.class, args);
    }
}
