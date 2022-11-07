package net.xdclass.demoproject.dao;

import net.xdclass.demoproject.entity.Video;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VideoMapper {

    /**根据视频id找到视频对象
     *
     */
    //Video selectById(@Param("video_id")int videoId);//一个参数不用写@Param,多个参数必须写
    Video selectById(int videoId);

    /**
     * 查询全部视频列表
     * @return
     */
    List<Video> selectListByXML();


    /**
     * 查询全部视频列表
     */
    @Select("select * from video")
    List<Video> selectList();

    /**
     *根据评分和标题模糊查询
     * @param point
     * @param title
     * @return
     */
    List<Video> selectByPointAndTitleLike(@Param("point")double point,@Param("title")String title);

    /**
     * 新增一条视频记录
     * @param video
     * @return
     */
    int add(Video video);

    /**
     * 批量插入
     * @param list
     * @return
     */
    int addBatch(List<Video> list);
}

