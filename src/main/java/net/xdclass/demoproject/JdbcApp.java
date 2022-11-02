package net.xdclass.demoproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp {

    /**
     *   ○ 加载JDBC驱动程序
     *   ○ 创建数据库的连接
     *   ○ 创建preparedStatement
     *   ○ 执⾏SQL语句
     *   ○ 处理结果集
     *   ○ 关闭JDBC对象资源
     */
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");//加载数据库的驱动，固定这么写
        //数据库连接
        String url = "jdbc:mysql://bj-cynosdbmysql-grp-9ojd982i.sql.tencentcdb.com:24051/xdclass?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String username = "root";
        String password = "Hello123!";
        //获取连接对象，并连接数据库
        Connection connection = DriverManager.getConnection(url,username,password);
        //获取语句对象
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from video");
        while (resultSet.next()){
            System.out.println("视频标题:"+resultSet.getString("title"));
        }
        statement.close();
    }
}
