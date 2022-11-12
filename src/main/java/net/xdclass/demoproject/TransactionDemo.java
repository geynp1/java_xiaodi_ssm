package net.xdclass.demoproject;

import net.xdclass.demoproject.dao.VideoMapper;
import net.xdclass.demoproject.entity.Video;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class TransactionDemo {

    public static void main(String[] args) throws IOException {
        String resouce = "config/mybatis-config.xml";

        //读取配置文件
        InputStream inputStream =  Resources.getResourceAsStream(resouce);

        //构建Session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //false是非自动提交,true是自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        //获取Session
       try{
           VideoMapper videoMapper = sqlSession.getMapper(VideoMapper.class);
           Video video = new Video();
           video.setTitle("小滴课堂 微服务架构");
           videoMapper.add(video);
           int i = 1/0;
           sqlSession.commit();
       }catch (Exception e){
           e.printStackTrace();
           sqlSession.rollback();
       }
       sqlSession.close();

    }
}
