package com.jk.service;

import com.jk.model.UserModel;

import java.util.HashMap;

/**
 * 积极思考造成积极人生，消极思考造成消极人生
 *
 * @author 赵苑辰
 * @title: ServerService
 * @date 2019/6/18  19:23
 */
public interface ServerService {
    HashMap<String,String> loginUser(UserModel user);

    HashMap<String,String> loginUserPhone(UserModel user);

    String addUser(UserModel userModel);

    HashMap<String, String> getYouHuiQuan(String userId);

    HashMap<String, Object> findYouHuiQuan(Integer page, Integer limit,String userId);

    Integer getcount(String userId);
}
