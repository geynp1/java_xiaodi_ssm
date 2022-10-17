package net.xdclass.demoproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 视频控制器
 */

@Controller
@RequestMapping("/api/v2/video")
public class VideoControllerTest {

    @ResponseBody
    @RequestMapping("list")
    public Object list(){
        Map<String, String> map = new HashMap<>();
        map.put("1","面试专题课程XXX");
        map.put("2","SpringCloud微服务课程XXX");

        return map;
    }
}

