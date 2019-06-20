package com.jk.controller.wcjcontroller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

    //跳转个人中心页面
    @RequestMapping("toPersonalcenter")
    public String tree(){
        return "personalcenter";
    }

    //跳转用户信息页面
    @RequestMapping("tousershow")
    public String tousershow(){
        return "yonghuxinxi";
    }




}
