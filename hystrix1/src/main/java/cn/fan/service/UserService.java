package cn.fan.service;

import cn.fan.pojo.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    public User findUser(Long id) {
        return restTemplate.getForObject("http://USER-SERVICe/users/{1}", User.class, id);
    }

    public List<User> findAll(List<Long> ids) {
        return restTemplate.getForObject("http://USER-SERVICE/users?id={1}",
                List.class,
                StringUtils.join(ids, ","));
    }
}
