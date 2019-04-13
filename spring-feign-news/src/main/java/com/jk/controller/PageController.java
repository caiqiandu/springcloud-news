package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：mmzs
 * @date ：Created in 2019/4/13 8:25
 * @description：
 * @modified By：
 * @version: $
 */
@Controller
@RequestMapping("page")
public class PageController {
    @RequestMapping("tonews")
    public String tonews(){
        return "news";
    }
}
