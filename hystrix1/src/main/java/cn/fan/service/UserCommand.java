package cn.fan.service;

import cn.fan.pojo.User;
import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

public class UserCommand extends HystrixCommand<User> {

    private RestTemplate restTemplate;
    private Long id;

    public UserCommand(Setter setter, RestTemplate restTemplate, Long id) {

// 以继承方式实现的Hystrix命令使用类名作为默认的命令名称
//        也可以在构造中通过Setter静态类来设置
//        super(
//                Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GroupName"))
//                        .andCommandKey(HystrixCommandKey.Factory.asKey("CommandName"))
//        更细粒度的线程池划分
//                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ThreadPoolKey"))
//                );

        super(setter);
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected User run() throws Exception {
        return restTemplate.getForObject("http://USER-SERVICE/users/{1}", User.class, id);
    }

    /**
     * Hystrix会在run()执行过程中出现错误、超时、线程池拒绝、断路器熔断等情况时，执行getFallback()
     */
    @Override
    protected User getFallback() {
        // 降级处理逻辑
        return new User();
    }

}
