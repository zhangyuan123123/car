package com.jk.controller;

import com.jk.model.OrderBean;
import com.jk.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;

@Controller
public class CarController {
    @Resource
    private CarService carService;
    @RequestMapping("refer")
    @ResponseBody
    public HashMap<String,Object> refer(){
        return carService.refer();
    }
    @RequestMapping("cityrefer")
    @ResponseBody
    public HashMap<String,Object> cityrefer(){
        return carService.cityrefer();
    }
    @RequestMapping("refermendian")
    @ResponseBody
    public HashMap<String,Object> refermendian(String cityid){
        return carService.refermendian(cityid);
    }
    @RequestMapping("refercar")
    @ResponseBody
    public HashMap<String,Object> refercar(String cityid){
        return carService.refercar(cityid);
    }

    @RequestMapping("qurefer")
    @ResponseBody
    public HashMap<String,Object> qurefer(Integer qid){
        return carService.qurefer(qid);
    }

    @RequestMapping("hairefer")
    @ResponseBody
    public HashMap<String,Object> hairefer(Integer hid){
        return carService.hairefer(hid);
    }

    @RequestMapping("refercom")
    @ResponseBody
    public HashMap<String,Object> refercom(Integer userid){
        return carService.refercom(userid);
    }

    @RequestMapping("referinsurance")
    @ResponseBody
    public HashMap<String,Object> referinsurance(){
        return carService.referinsurance();
    }

    @RequestMapping("addorder")
    @ResponseBody
    public Integer addorder(@RequestBody OrderBean orderBean){
       return carService.addorder(orderBean);
    }

}
