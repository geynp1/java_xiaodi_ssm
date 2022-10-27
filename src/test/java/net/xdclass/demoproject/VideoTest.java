package net.xdclass.demoproject;

import junit.framework.TestCase;
import net.xdclass.demoproject.domain.Video;
import net.xdclass.demoproject.service.VideoService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.ModelResultMatchers;

import java.nio.charset.Charset;
import java.util.List;

@RunWith(SpringRunner.class) //底层⽤junit SpringJUnit4ClassRunner
@SpringBootTest(classes={DemoProjectApplication.class})//启动整个springboot⼯程
@AutoConfigureMockMvc
public class VideoTest {


    @Autowired
    private VideoService videoService;
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testVideoListApi() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pub/video/list"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();//http200响应码,通用的
        int status = mvcResult.getResponse().getStatus();
        System.out.println(status);

        String result = mvcResult.getResponse().getContentAsString(Charset.forName("utf-8"));
        System.out.println(result);


    }

    @Before//资源的预加载
    public void testOne(){
        System.out.println("这个是测试 before");
    }

    @Test
    public void testVideoList(){
        List<Video> videoList = videoService.listVideo();
        TestCase.assertTrue(videoList.size()>0);
    }
    @Test
    public void testTwo1(){
        System.out.println("这个是测试 test1");
        TestCase.assertEquals(1,2);
    }

    @Test
    public void testTwo2(){
        System.out.println("这个是测试 test2");
    }

    @After//资源回收
    public void testThree(){
        System.out.println("这个是测试 after");
    }
}
