package cn.fan;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Eureka1Application {

    /**
     * http://localhost:1111/
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(Eureka1Application.class).web(WebApplicationType.SERVLET).run(args);
    }
}
