package net.xdclass.demoproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 视频控制器
 */

@RestController
@RequestMapping("/api/v3/video")
public class VideoControllerMapping {

    @GetMapping("list")
    public Object list(){
        Map<String, String> map = new HashMap<>();
        map.put("1","面试专题课程get");
        map.put("2","SpringCloud微服务课程");

        return map;
    }
    @PostMapping("show")
    public Object show(){
        Map<String, String> map = new HashMap<>();
        map.put("1","面试专题课程post");
        map.put("2","SpringCloud微服务课程");

        return map;
    }
}

