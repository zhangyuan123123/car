package com.jk.dao;

import com.jk.model.User;
import com.jk.model.ordergoods;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PersonalcenterDao {

    //查看当前用户下的所有订单
    @Select("select * from user u,ordergoods og where u.userId=og.goodUserId\n" +
            "and u.userId =#{id}")
    List<ordergoods> selectorder(Integer id);

    //根据用户Id查询用户信息
    @Select("select u.*,ap.name as name ,ap.sfz as sfz from user u, t_aptitude ap where u.userInfoid= ap.id and u.userId =#{id} ")
    List<User> selectUserById(Integer id);

    //添加用户的信息已登陆状态
    void addUserXinxi(User user);

    //查看用户所有的订单
    @Select("select og.* from user u, ordergoods og where u.userId= og.goodUserId and u.userId =#{id}")
    List<ordergoods> selectdingdanall(Integer id);

    //查看用户正在租赁的订单
    @Select("select og.* from user u, ordergoods og where u.userId= og.goodUserId and og.zhuangtai=1 and og.status=1 and og.endTime >=SYSDATE() and u.userId =#{id} ")
    List<ordergoods> selectdingdanByzhuangtai(Integer id);

    //查看用户已经租赁完成的订单
    @Select("select og.* from user u, ordergoods og where u.userId= og.goodUserId and og.zhuangtai=2 and og.status=1 and og.endTime >=SYSDATE() and u.userId =#{id} ")
    List<ordergoods> seedingdanByzhuangtai(Integer id);

    //查看用户已经过期的订单
    @Select("select og.* from user u, ordergoods og where u.userId= og.goodUserId and og.zhuangtai=2 and og.status=1 and og.endTime <=SYSDATE()  and u.userId =#{id} ")
    List<ordergoods> querydingdanBytime(Integer id);
}
