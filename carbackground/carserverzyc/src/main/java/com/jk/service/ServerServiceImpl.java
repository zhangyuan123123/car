package com.jk.service;

import com.jk.mapper.ServerMapper;
import com.jk.model.CouponModel;
import com.jk.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 积极思考造成积极人生，消极思考造成消极人生
 *
 * @author 赵苑辰
 * @title: ServerServiceImpl
 * @date 2019/6/18  19:23
 */
@Service
public class ServerServiceImpl implements ServerService{
    @Autowired
    private ServerMapper serverMapper;


    @Override
    public HashMap<String,String> loginUser(UserModel user) {
        HashMap<String,String> map=new HashMap<String,String>();
        List<UserModel> list = serverMapper.loginUser(user.getUserAccount());
        if(list == null || list.size() <= 0 ){
            map.put("flag","2");
            System.out.println("用户名不正确");
        }else{
            UserModel user2 = list.get(0);
            if(user2 !=null && user2.getUserPwd()!=null && user2.getUserPwd().equals(user.getUserPwd())){
                //登录成功后查出id
                Integer userId = serverMapper.getUserById(user.getUserAccount());
                //登录成功根据id查询用户名
                String userAccount = serverMapper.getUserByAccountLoginUser(userId);
                map.put("flag","4");
                map.put("userId",userId+"");
                map.put("userAccount",userAccount);
                System.out.println(userId);
                System.out.println("登录成功");
            }else{
                map.put("flag","3");
                System.out.println("密码不正确");
            }
        }
        return map;
    }

    @Override
    public HashMap<String,String> loginUserPhone(UserModel user) {
        HashMap<String,String> map=new HashMap<String,String>();
        List<UserModel> list = serverMapper.loginUserPhone(user.getUserPhone());//查询手机号
        if(list == null || list.size() <= 0 ){
            map.put("flag","2");
            System.out.println("手机号不正确");
        }else{
            UserModel user3 = list.get(0);
            if(user3 !=null && user3.getUserPhone()!=null && user3.getUserPhone().equals(user.getUserPhone())){
                Integer userId = serverMapper.getUserByIdPhone(user.getUserPhone());
                String userAccount = serverMapper.getUserByAccount(user.getUserPhone());//根据手机号获取用户名
                map.put("flag","4");
                map.put("userId",userId+"");
                map.put("userAccount",userAccount);
                System.out.println(userId);
                System.out.println("登录成功");
            }
        }
        return map;
    }

    @Override
    public String addUser(UserModel userModel) {
        String flag="";
        List<UserModel> list = serverMapper.findByUserAccount(userModel.getUserAccount());
        List<UserModel> listPhone = serverMapper.findByUserPhone(userModel.getUserPhone());
        if(list.size()>0){
            flag = "2";
            System.out.print("用户名已存在");
            return flag;
        }
        if(listPhone.size()>0){
            flag = "3";
            System.out.print("手机号已存在");
            return flag;
        }

        if(userModel.getUserAccount()!=""&&userModel.getUserPhone()!=""&&userModel.getUserPwd()!=""){
            serverMapper.addUser(userModel);
            flag = "4";
            System.out.print("注册成功");
        }
        return flag;
    }

    @Override
    public HashMap<String, String> getYouHuiQuan(String userId) {
        HashMap<String,String> map=new HashMap<String,String>();
        //当前用户订单已完成的总租车辆
        Integer count = serverMapper.getYouHuiQuan(userId);
        System.out.print("当前用户订单已完成的总租车辆"+count);

        if(count>3&&count<=5){
            serverMapper.getaddyouhui3(userId);
        }
        if(count>5){
            serverMapper.getaddyouhui5(userId);
        }
        map.put("count",count+"");
        return map;
    }

    @Override
    public HashMap<String, Object> findYouHuiQuan(Integer page, Integer limit,String userId) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Integer count = serverMapper.getSumSizeYouHui(userId);
        List<CouponModel> list = serverMapper.findYouHuiQuan((page-1)*limit,limit,userId);
        hashMap.put("count",count);
        hashMap.put("data",list);
        hashMap.put("code",0);
        hashMap.put("msg","");
        return hashMap;
    }

    @Override
    public Integer getcount(String userId) {
        Integer count = serverMapper.getSumSizeYouHui(userId);
        return count;
    }
}
