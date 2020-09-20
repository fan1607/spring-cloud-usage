package cn.fan;

import cn.fan.filter.AccessFilter;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringCloudApplication
public class Zuul1App {

    /**
     * http://localhost:5555/api-a/hello
     * http://localhost:5555/api-b/feign-consumer2
     * http://localhost:5555/api-b/feign-consumer2?accessToken=xxx
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(Zuul1App.class).web(WebApplicationType.SERVLET).run(args);
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
