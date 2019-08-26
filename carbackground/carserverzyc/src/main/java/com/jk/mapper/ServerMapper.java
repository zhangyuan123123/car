package com.jk.mapper;

import com.jk.model.CouponModel;
import com.jk.model.UserModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 积极思考造成积极人生，消极思考造成消极人生
 *
 * @author 赵苑辰
 * @title: ServerMapper
 * @date 2019/6/18  19:24
 */
public interface ServerMapper {

    @Select("select * from user where userAccount = #{userAccount} ")
    List<UserModel> loginUser(@Param("userAccount") String userAccount);

    @Select("select userId from user where userAccount = #{userAccount}")
    Integer getUserById(@Param("userAccount") String userAccount);

    @Select("select * from user where userPhone = #{userPhone} ")
    List<UserModel> loginUserPhone(@Param("userPhone") String userPhone);

    @Select("select userId from user where userPhone = #{userPhone}")
    Integer getUserByIdPhone(@Param("userPhone") String userPhone);

    void addUser(UserModel userModel);

    @Select("select * from user where userAccount=#{userAccount}")
    List<UserModel> findByUserAccount(@Param("userAccount") String userAccount);

    @Select("select * from user where userPhone=#{userPhone}")
    List<UserModel> findByUserPhone(@Param("userPhone") String userPhone);

    @Select("select count(*) from ordergoods where goodUserId = ${userId} and STATUS = 1")
    Integer getYouHuiQuan(@Param("userId") String userId);

    @Update("update user set youhuiId = 2 where userId=${userId}")
    void getaddyouhui3(@Param("userId") String userId);

    @Update("update user set youhuiId = 3 where userId=${userId}")
    void getaddyouhui5(@Param("userId") String userId);


    Integer getSumSizeYouHui(@Param("userId") String userId);

    List<CouponModel> findYouHuiQuan(@Param("page") Integer page, @Param("limit") Integer limit, @Param("userId") String userId);

    @Select("select userAccount from user where userPhone=#{userPhone} ")
    String getUserByAccount(@Param("userPhone") String userPhone);

    @Select("select userAccount from user where userId=#{userId} ")
    String getUserByAccountLoginUser(@Param("userId") Integer userId);
}
