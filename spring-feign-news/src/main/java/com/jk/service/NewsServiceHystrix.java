package com.jk.service;

import com.jk.model.News;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author ：mmzs
 * @date ：Created in 2019/4/12 20:58
 * @description：
 * @modified By：
 * @version: $
 */
@Component
public class NewsServiceHystrix implements NewsService {
    @Override
    public HashMap<String, Object> findNewsList(News news) {
        HashMap<String, Object> map = new HashMap<>();
map.put("message","网络异常");
        return map;
    }

    @Override
    public String deleteNews(Integer[] ids) {

        return "网络异常";
    }

    @Override
    public String saveNews(News news) {
        return "网络异常";
    }

    @Override
    public News queryById(Integer id) {
        News news = new News();
        news.setName("网络异常");
        return news;
    }
}
