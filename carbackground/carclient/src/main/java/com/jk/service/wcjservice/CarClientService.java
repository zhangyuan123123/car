package com.jk.service.wcjservice;

import com.jk.model.wcjmodel.User;
import com.jk.model.wcjmodel.ordergoods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient("car-provider")
public interface CarClientService {

    //查看当前用户下的所有订单
    @RequestMapping("selectorder")
    String selectorder(@RequestParam("id") Integer id);

    //查看用户正在租赁的订单
    @RequestMapping("selectdingdanByzhuangtai")
    String selectdingdanByzhuangtai(@RequestParam("id")Integer id);

    //查看用户已经租赁完成的订单
    @RequestMapping("seedingdanByzhuangtai")
   String seedingdanByzhuangtai(@RequestParam("id")Integer id);

    //查看用户已经过期的订单
    @RequestMapping("querydingdanBytime")
    String querydingdanBytime(@RequestParam("id")Integer id);

    //根据用户Id查询用户信息
    @RequestMapping("selectUserById")
    List<User> selectUserById(@RequestParam("id") Integer id);


    //添加用户的信息已登陆状态
    @RequestMapping("addUserXinxi")
    void addUserXinxi(@RequestBody User user);



}
