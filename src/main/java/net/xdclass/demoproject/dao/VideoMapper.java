package net.xdclass.demoproject.dao;

import net.xdclass.demoproject.entity.Video;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

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

    /**
     * 更新视频
     */
    int updateVideo(Video video);

    /**
     * 动态选择更新视频
     */
    int updateVideoSelective(Video video);

    /**
     * 根据时间和价格删除
     * @param map
     * @return
     */
    int deleteByCreateTimeAndPrice(Map<String,Object> map);
}

