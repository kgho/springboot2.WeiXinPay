package net.xdclass.xdvideo.mapper;

import net.xdclass.xdvideo.domain.Video;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * video数据访问层
 */
public interface VideoMapper {

    @Select("select * from video")
//    @Results({
//            @Result(column = "cover_img",property = "coverImg")  //javaType = java.util.Date.class
//    })
    List<Video> findALl();


    @Select("SELECT * FROM video WHERE id = #{id}")
    Video findById(int id);


    @Update("UPDATE video SET title=#{title} WHERE id =#{id}")
    int update(Video Video);

    @Delete("DELETE FROM video WHERE id =#{id}")
    int delete(int id);

    @Insert("INSERT INTO `video` ( `title`, `summary`, " +
            "`cover_img`, `view_num`, `price`, `create_time`," +
            " `online`, `point`)" +
            "VALUES" +
            "(#{title}, #{summary}, #{coverImg}, #{viewNum}, #{price},#{createTime}" +
            ",#{online},#{point});")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int save(Video video);

}
