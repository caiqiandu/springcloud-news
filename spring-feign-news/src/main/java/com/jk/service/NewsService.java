package com.jk.service;

import com.jk.model.News;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

@FeignClient(value ="springcloud-provider-news",fallback =NewsServiceHystrix.class )//指定生产者的实例名称
public interface NewsService {
    @PostMapping("findNewsList")
    public HashMap<String, Object> findNewsList(@RequestBody News news);
    @GetMapping("deleteNews/{ids}")
  public  String deleteNews(@PathVariable Integer[] ids);
    @PostMapping("saveNews")
    public String saveNews(@RequestBody News news);
    @GetMapping("queryById/{id}")
    public News queryById(@PathVariable Integer id);
}
