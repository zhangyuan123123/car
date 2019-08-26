package com.jk.controller;

import com.jk.model.UserModel;
import com.jk.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 积极思考造成积极人生，消极思考造成消极人生
 *
 * @author 赵苑辰
 * @title: ServerController
 * @date 2019/6/18  19:22
 */
@Controller
@RequestMapping("zycserver")
public class ServerController {
    @Autowired
    private ServerService serverService;


    @RequestMapping("test")
    @ResponseBody
    public String test(){
        return "success!!!!!!!";
    }

    //loginUser  登录
    @RequestMapping("loginUser")
    @ResponseBody
    public HashMap<String,String> loginUser(@RequestBody UserModel user , HttpServletRequest request){
        //登陆时存对象，用于加入购物车时判断状态
       /* request.getSession().setAttribute("userId",user.getUserId());
        request.getSession().setAttribute("userName",user.getUserAccount());//账号
        request.getSession().setAttribute("user",user);*/
        //如果一致  继续在  业务层判断
        HashMap<String,String>  map = serverService.loginUser(user);
        return map;
    }

    //手机号登录   loginUserPhone
    @RequestMapping("loginUserPhone")
    @ResponseBody
    public HashMap<String,String> loginUserPhone(@RequestBody UserModel user , HttpServletRequest request){
        //登陆时存对象，用于加入购物车时判断状态
        request.getSession().setAttribute("userId",user.getUserId());//用户id
        request.getSession().setAttribute("userName",user.getUserAccount());//账号
        request.getSession().setAttribute("userPhone",user.getUserPhone());//手机号
        request.getSession().setAttribute("user",user);
        //如果一致  继续在  业务层判断
        HashMap<String,String> map = serverService.loginUserPhone(user);
        return map;
    }

    //注册 addUser
    @RequestMapping("addUser")
    @ResponseBody
    public String addUser(@RequestBody UserModel userModel){
        String flag = "";
        flag =  serverService.addUser(userModel);
        return flag;
    }


    //根据租车辆领取优惠券
    @RequestMapping("getYouHuiQuan")
    @ResponseBody
    public HashMap<String,String> getYouHuiQuan(String userId){
        HashMap<String,String> map=new HashMap<String,String>();
        if(userId!=""){
            map = serverService.getYouHuiQuan(userId);
        }
        return map;
    }

    //优惠券查询   findYouHuiQuan
    @RequestMapping("findYouHuiQuan")
    @ResponseBody
    public HashMap<String,Object> findYouHuiQuan(Integer page , Integer limit,String userId){
        return serverService.findYouHuiQuan(page,limit,userId);
    }


    //按钮禁用  anniu
    @RequestMapping("getcount")
    @ResponseBody
    public Integer getcount(String userId){
        return serverService.getcount(userId);
    }


}
