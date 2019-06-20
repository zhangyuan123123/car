package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.dao.PersonalcenterDao;
import com.jk.model.User;
import com.jk.model.ordergoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PersonalcenterController {

    @Autowired
    private PersonalcenterDao personalcenterDao;


    //查看当前用户下的所有订单
     @RequestMapping("selectorder")
    public String selectorder(Integer id){
         List<ordergoods> selectorder = personalcenterDao.selectorder(id);

         JSONObject obj=new JSONObject();
         //前台通过key值获得对应的value值
         obj.put("code", 0);
         obj.put("msg", "");
         obj.put("data",selectorder);
         return obj.toJSONString();
     }



     //根据用户Id查询用户信息
     @RequestMapping("selectUserById")
     public List<User> selectUserById(Integer id){
         return personalcenterDao.selectUserById(id) ;
     }

    //查看用户所有的订单
    @RequestMapping("selectdingdanall")
    public List<ordergoods> selectdingdanall(Integer id){
        return personalcenterDao.selectdingdanall(id) ;
    }


    //查看用户正在租赁的订单
    @RequestMapping("selectdingdanByzhuangtai")
    public String selectdingdanByzhuangtai(Integer id){
        List<ordergoods> ordergoods = personalcenterDao.selectdingdanByzhuangtai(id);

        JSONObject obj=new JSONObject();
        //前台通过key值获得对应的value值
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("data",ordergoods);
        return obj.toJSONString();
    }
    //查看用户已经租赁完成的订单
    @RequestMapping("seedingdanByzhuangtai")
    public String seedingdanByzhuangtai(Integer id){
        List<ordergoods> ordergoods = personalcenterDao.seedingdanByzhuangtai(id);
        JSONObject obj=new JSONObject();
        //前台通过key值获得对应的value值
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("data",ordergoods);
        return obj.toJSONString();
    }

    //查看用户已经过期的订单
    @RequestMapping("querydingdanBytime")
    public String querydingdanBytime(Integer id){
        List<ordergoods> ordergoods = personalcenterDao.querydingdanBytime(id);
        JSONObject obj=new JSONObject();
        //前台通过key值获得对应的value值
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("data",ordergoods);
        return obj.toJSONString();
    }

    //修改用户
    @RequestMapping("addUserXinxi")
    public void addUserXinxi(@RequestBody User user) {
        personalcenterDao.addUserXinxi(user);

    }
}
