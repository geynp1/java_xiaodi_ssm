package net.xdclass.demoproject.controller;

import net.xdclass.demoproject.config.WXConfig;
import net.xdclass.demoproject.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/test")
@PropertySource({"classpath:pay.properties"})
public class TestController {

    @Value("${wxpay.appid}")
    private String payAppid;
    @Value("${wxpay.secret}")
    private String paySecret;

    @Autowired
    private WXConfig wxConfig;

    @RequestMapping("get_config")//通过配置文件
    public JsonData testConfig(){
        Map<String, String> map = new HashMap<>();
        map.put("appid", payAppid);
        map.put("secret", paySecret);

        return JsonData.buildSuccess(map);
    }

    @RequestMapping("get_config1")//通过配置类
    public JsonData testConfig1(){
        Map<String, String> map = new HashMap<>();
        map.put("appid", wxConfig.getPayAppid());
        map.put("secret", wxConfig.getPaySecret());
        map.put("mechid", wxConfig.getPayMechId());

        return JsonData.buildSuccess(map);
    }
}
