package com.jk.controller;

import com.jk.service.HhxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Package com.jk.controller
 * @作者 韩慧鑫
 * @创建时间 2019/6/19 16:43
 */
@Controller
public class HhxController {
    @Autowired
    private HhxService hhxService;
    @RequestMapping("findCarCity")
    @ResponseBody
    public List<LinkedHashMap> findCarCity(String cityName){
    return hhxService.findCarCity(cityName);
    }
    @RequestMapping("findCarCityByXingId")
    @ResponseBody
    public LinkedHashMap findCarCityByXingId(String cityName,Integer id){
        return hhxService.findCarCityByXingId(cityName,id);
    }
    @RequestMapping("findmendian")
    @ResponseBody
    public List<LinkedHashMap> findmendian(Integer id,String cityName){
        return hhxService.findmendian(id,cityName);
    }
}
