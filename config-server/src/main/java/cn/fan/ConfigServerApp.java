package cn.fan;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApp {

    /**
     * http://localhost:7001/fan/dev/2.0
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigServerApp.class).web(WebApplicationType.SERVLET).run(args);
    }
}
