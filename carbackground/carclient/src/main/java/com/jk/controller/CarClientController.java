package com.jk.controller;

import com.jk.service.CarClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class CarClientController {

    @Resource
    private CarClientService carClientService;

    @RequestMapping("refer")
    public String refer(){
        return carClientService.refer();
    }
}
