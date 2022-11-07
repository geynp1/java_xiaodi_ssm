package net.xdclass.demoproject;

import net.xdclass.demoproject.dao.VideoMapper;
import net.xdclass.demoproject.entity.Video;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

//            Video video = videoMapper.selectById(44);
//            System.out.println(video.toString());
            //通过注解
//            List<Video> videoList1 =  videoMapper.selectList();
//            List<Video> videoList = videoMapper.selectListByXML();
//            System.out.println(videoList.toString());
            //多参数查询
//            List<Video> videoList = videoMapper.selectByPointAndTitleLike(8.7, "HTML");
//            System.out.println(videoList.toString());

            //新增一条记录
            Video video1 = new Video();
            video1.setTitle("小滴课堂面试装填30道");
            video1.setCoverImg("xdclass.net/aaa.png");
            video1.setPoint(9.4);
            video1.setPrice(9900);
            video1.setSummary("这个是面试专题概要");
//            int rows = videoMapper.add(video1);
//            System.out.println(rows);
//            System.out.println(video1.toString());

            Video video2 = new Video();
            video2.setTitle("小滴课堂面试装填30道2");
            video2.setCoverImg("xdclass.net/aaa.png2");
            video2.setPoint(9.4);
            video2.setPrice(9900);
            video2.setSummary("这个是面试专题概要2");

            List<Video> list = new ArrayList<>();
            list.add(video1);
            list.add(video2);


            int rows= videoMapper.addBatch(list);
            System.out.println(rows);
            System.out.println(list.toString());


        }
    }
}
