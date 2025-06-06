package com.xuyi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xuyi
 * @date 2022/10/27 17:09
 * @description 系统首页请求控制器
 */
@Controller
public class IndexController {

    /**
     * 进入登录页面
     * @return 重定向至登录页面
     */
    @GetMapping("/")
    public String toIndex(){
        return "redirect:login.html";
    }
}
