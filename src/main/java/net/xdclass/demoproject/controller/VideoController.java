package net.xdclass.demoproject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.xdclass.demoproject.domain.Video;
import net.xdclass.demoproject.service.VideoService;
import net.xdclass.demoproject.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 视频控制器
 */

@RestController
@RequestMapping("/api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

//    @RequestMapping(value = "list",method = RequestMethod.GET)
    @GetMapping("list")
    public Object list() throws JsonProcessingException {
        List<Video> list = videoService.listVideo();



        return JsonData.buildSuccess(list);
    }

    @PostMapping("save_video_chapter")
    public JsonData saveVideo(@RequestBody Video video) {
        System.out.println(video.toString());
        return JsonData.buildSuccess(video);
    }
}

