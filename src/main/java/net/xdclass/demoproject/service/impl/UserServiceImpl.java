package net.xdclass.demoproject.service.impl;

import net.xdclass.demoproject.domain.User;
import net.xdclass.demoproject.mapper.UserMapper;
import net.xdclass.demoproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    public static Map<String, User> sessionMap = new HashMap<>();

    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(String username, String pwd) {
        User user = userMapper.login(username, pwd);
        if (user == null) {
            return null;
        }else{
            String token = UUID.randomUUID().toString();
            System.out.println(token);
            sessionMap.put(token, user); //用session把tocken存起来，单机可用，分布式要存入redis，redis是分布式缓存
            return token;
        }
    }

    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }
}
