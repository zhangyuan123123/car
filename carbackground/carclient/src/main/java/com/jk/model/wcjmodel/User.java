package com.jk.model.wcjmodel;

import org.apache.ibatis.annotations.Select;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -4651625903780843876L;
    private  Integer userId;
    private  String userAccount;
    private String userPhone;
    private  Integer userInfoid;
    private  String userPwd;

    private  String name;
    private  String sfz;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSfz() {
        return sfz;
    }

    public void setSfz(String sfz) {
        this.sfz = sfz;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getUserInfoid() {
        return userInfoid;
    }

    public void setUserInfoid(Integer userInfoid) {
        this.userInfoid = userInfoid;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
