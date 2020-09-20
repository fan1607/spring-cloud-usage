package cn.fan.service.cache;

import cn.fan.pojo.User;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

public class UserPostCommand extends HystrixCommand<User> {

    private RestTemplate restTemplate;
    private User user;

    public UserPostCommand(RestTemplate restTemplate, User user) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GetSetGet")));
        this.restTemplate = restTemplate;
        this.user = user;
    }

    @Override
    protected User run() throws Exception {
        // 写操作
        User r = restTemplate.postForObject("http://USER-SERVICE/users", user, User.class);
        // 刷新缓存，清理缓存中失效的User
        UserGetCommand.flushCache(r.getId());
        return r;
    }
}
