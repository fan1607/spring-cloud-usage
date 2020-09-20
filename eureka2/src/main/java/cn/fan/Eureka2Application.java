package cn.fan;


import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Eureka2Application {

    /**
     * http://localhost:1112/
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(Eureka2Application.class).web(WebApplicationType.SERVLET).run(args);
    }
}
