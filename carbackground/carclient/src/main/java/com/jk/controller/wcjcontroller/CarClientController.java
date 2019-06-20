package com.jk.controller.wcjcontroller;

import com.jk.model.wcjmodel.User;
import com.jk.model.wcjmodel.ordergoods;
import com.jk.service.wcjservice.CarClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("car")
public class CarClientController {

    @Resource
    private CarClientService carClientService;


    //查看当前用户下的所有订单
    @RequestMapping("selectorder")
    @ResponseBody
    public String selectorder(Integer id){
        String carList= carClientService.selectorder(id) ;
        return carList;
    }


    //查看用户正在租赁的订单
    @RequestMapping("selectdingdanByzhuangtai")
    @ResponseBody
    public String selectdingdanByzhuangtai(Integer id){

        String carList= carClientService.selectdingdanByzhuangtai(id) ;
        return carList;
    }

    //查看用户已经租赁完成的订单
    @RequestMapping("querydingdanBytime")
    @ResponseBody
    public String querydingdanBytime(Integer id){
        return carClientService.querydingdanBytime(id) ;
    }
    //查看用户已经过期的订单
    @RequestMapping("seedingdanByzhuangtai")
    @ResponseBody
    public String seedingdanByzhuangtai(Integer id){
        return carClientService.seedingdanByzhuangtai(id) ;
    }

    //根据用户Id查询用户信息
    @RequestMapping("selectUserById")
    @ResponseBody
    public List<User> selectUserById(Integer id){
        return carClientService.selectUserById(id) ;
    }


     //添加用户信息已登录状态
    @RequestMapping("addUserXinxi")
    @ResponseBody
    public Boolean addUserXinxi(User user) {
        try {
            carClientService.addUserXinxi(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }



}
