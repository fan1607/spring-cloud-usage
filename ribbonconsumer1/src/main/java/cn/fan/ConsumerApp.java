package cn.fan;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@SpringCloudApplication


@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerApp {

    /**
     * http://localhost:9000/ribbon-consumer
     * http://localhost:9000/circuitBreaker
     */
    public static void main(String[] args) {
//        new SpringApplicationBuilder(ConsumerApp.class).web(WebApplicationType.SERVLET).run(args);
        SpringApplication.run(ConsumerApp.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean
                = new ServletRegistrationBean<>(streamServlet);
        registrationBean.setName("hystrixMetricsStreamServlet");
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        return registrationBean;
    }
}
