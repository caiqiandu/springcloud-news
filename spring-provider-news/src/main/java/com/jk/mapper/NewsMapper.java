package com.jk.mapper;

import com.jk.model.News;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface NewsMapper {
   // @Select(" select count(1) from t_news")
    int findNewsCount(@Param("news") News news);
  // @Select(" select * from t_news limit #{start},#{rows}")
    List<News> findNewsList(@Param("start")int start,@Param("rows") Integer rows,@Param("news") News news);

    void deleteNews(Integer[] ids);
@Insert("insert into t_news(name,praise,comment,dateTime,author) values(#{name},#{praise},#{comment},Sysdate(),#{author})")
    void saveNews(News news);
@Update("update t_news set name=#{name}, comment=#{comment},author=#{author} where id=#{id}")
    void update(News news);
@Select("select * from t_news where id=#{value}")
    News queryById(Integer id);
}
