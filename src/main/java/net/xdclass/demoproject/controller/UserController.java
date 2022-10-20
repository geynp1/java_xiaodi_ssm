package net.xdclass.demoproject.controller;

import net.xdclass.demoproject.domain.User;
import net.xdclass.demoproject.domain.Video;
import net.xdclass.demoproject.service.UserService;
import net.xdclass.demoproject.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pub/user")
public class UserController {

//    @PostMapping("login")
//    public JsonData login(String pwd,String username){//post-form提交
//        System.out.println("username="+username+" pwd="+pwd);
//
//        return JsonData.buildSuccess("");
//    }

//    @PostMapping("login")
//    public JsonData login(User user){//post-form提交
//        System.out.println("user"+user.toString());
//
//        return JsonData.buildSuccess("");
//    }

    @Autowired
    public UserService userService;

    /**
     * 登录接口
     * @param user
     * @return
     */
    @PostMapping("login")
    public JsonData login(@RequestBody User user){//post提交json参数，添加注解@RequestBody
        System.out.println("user"+user.toString());
        String token = userService.login(user.getUsername(),user.getPwd());

        return token != null ? JsonData.buildSuccess(token):JsonData.buildError("账号密码错误");

    }

    /**
     * 列出全部用户
     * @return
     */
    @GetMapping("list")
    public Object listUser(){
        return JsonData.buildSuccess(userService.listUser());
    }

}
