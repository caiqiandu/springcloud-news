package com.jk.service;

import com.jk.mapper.NewsMapper;
import com.jk.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author ：mmzs
 * @date ：Created in 2019/4/12 20:43
 * @description：
 * @modified By：
 * @version: $
 */
@Controller
public class NewsServiceImpl {
  @Autowired
    private NewsMapper newsMapper;
  /*
  分页查询新闻
   */
  @PostMapping("findNewsList")
  @ResponseBody
  public HashMap<String,Object>findNewsList(@RequestBody News news){
    HashMap<String, Object> params = new HashMap<>();
    int count=newsMapper.findNewsCount(news);
    int start=(news.getPage()-1)*(news.getRows());
    List<News> list=newsMapper.findNewsList(start,news.getRows(),news);
    params.put("total",count);
    params.put("rows",list);
  return params;
  }
  /*
  批量删除
   */
  @GetMapping("deleteNews/{ids}")
  @ResponseBody
  public String deleteNews(@PathVariable Integer [] ids){
    newsMapper.deleteNews(ids);
    return "删除成功";
  }
  /*
  新增
   */
  @PostMapping("saveNews")
  @ResponseBody
  public String saveNews(@RequestBody News news){
    Integer id = news.getId();

    if(id ==null){
    news.setPraise(0);

    newsMapper.saveNews(news);
    return "新增成功";}
    else{
      newsMapper.update(news);
      return "修改成功";
    }
  }
  /*
  回显
   */
  @GetMapping("queryById/{id}")
  @ResponseBody
  public News queryById(@PathVariable Integer id){
     News news=newsMapper.queryById(id);
     return news;
  }
}
