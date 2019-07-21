package com.jk.controller;

import com.jk.model.News;
import com.jk.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author ：mmzs
 * @date ：Created in 2019/4/12 20:54
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
public class NewsController {
    @Autowired
    private NewsService newsService;
    /*分页查询新闻列表*/
    @PostMapping("findNewsList")
    public HashMap<String,Object>findNewsList(Integer page, Integer rows, News news){
        integer i=1;
        news.setPage(page);
        news.setRows(rows);
        HashMap<String,Object>NewsList=newsService.findNewsList(news);
        return NewsList;
    }
    /*
    批量删除新闻列表
     */
    @PostMapping("deleteNews")
    public String deleteNews(Integer []ids){
      String result=  newsService.deleteNews(ids);
      return result;
    }
    /*
    新增
     */
    @PostMapping("saveNews")
    public String saveNews( News news){
        String result=newsService.saveNews(news);
        return result;
    }
    @PostMapping("queryById")
    public News queryById( Integer id){
        News news=  newsService.queryById(id);
        return news;
    }
}
