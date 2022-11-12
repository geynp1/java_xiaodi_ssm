package net.xdclass.demoproject;

import net.xdclass.demoproject.dao.VideoMapper;
import net.xdclass.demoproject.dao.VideoOrderMapper;
import net.xdclass.demoproject.entity.User;
import net.xdclass.demoproject.entity.Video;
import net.xdclass.demoproject.entity.VideoOrder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlSessionDemo {

    public static void main(String[] args) throws IOException {
        String resouce = "config/mybatis-config.xml";

        //读取配置文件
        InputStream inputStream =  Resources.getResourceAsStream(resouce);

        //构建Session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取Session
        try(SqlSession sqlSession = sqlSessionFactory.openSession(true)){

            VideoMapper videoMapper = sqlSession.getMapper(VideoMapper.class);
            VideoOrderMapper videoOrderMapper = sqlSession.getMapper(VideoOrderMapper.class);
//            for (int i = 0; i < 2; i++) {
//                Video video = videoMapper.selectById(44);
//                System.out.println(video.toString());
//            }

            //通过注解
//            List<Video> videoList1 =  videoMapper.selectList();
//            List<Video> videoList = videoMapper.selectListByXML();
//            System.out.println(videoList.toString());
            //多参数查询
//            List<Video> videoList = videoMapper.selectByPointAndTitleLike(8.7, "HTML");
//            System.out.println(videoList.toString());

            //新增一条记录
//            Video video1 = new Video();
//            video1.setTitle("小滴课堂面试装填30道");
//            video1.setCoverImg("xdclass.net/aaa.png");
//            video1.setPoint(9.4);
//            video1.setPrice(9900);
//            video1.setSummary("这个是面试专题概要");
//            int rows = videoMapper.add(video1);
//            System.out.println(rows);
//            System.out.println(video1.toString());

//            Video video2 = new Video();
//            video2.setTitle("小滴课堂面试装填30道2");
//            video2.setCoverImg("xdclass.net/aaa.png2");
//            video2.setPoint(9.4);
//            video2.setPrice(9900);
//            video2.setSummary("这个是面试专题概要2");
//
//            List<Video> list = new ArrayList<>();
//            list.add(video1);
//            list.add(video2);
//
//
//            int rows= videoMapper.addBatch(list);
//            System.out.println(rows);
//            System.out.println(list.toString());
//            Video video = new Video();
//            video.setId(65);
//            video.setTitle("小滴课堂面试装填30道 2021年新版");
//            video.setCoverImg("xdclass.net/666666.png");
//            videoMapper.updateVideoSelective(video);


//            Map<String, Object> map = new HashMap<>();
//            map.put("createTime", "2021-01-01 00:00:00");
//            map.put("price", 9000);
//            int rows = videoMapper.deleteByCreateTimeAndPrice(map);
//            System.out.println(rows);

//            Video video = videoMapper.selectBaseFieldByIdWithResultMap(45);
//            System.out.println(video.toString());

            //resultmap asssociation关联查询
//            List<VideoOrder> videoOrderList = videoOrderMapper.queryVideoOrderList();
//            System.out.println(videoOrderList.toString());

            //resultmap collection测试
//            List<User> userList = videoOrderMapper.queryUserOrder();
//            System.out.println(userList.toString());

            //resultmap asssociation关联查询
            List<VideoOrder> videoOrderList = videoOrderMapper.queryVideoOrderListLazy();

            for (VideoOrder videoOrder : videoOrderList) {
//                System.out.println(videoOrder.getVideoTitle());
                System.out.println(videoOrder.getUser().getName());
            }
        }
    }
}
