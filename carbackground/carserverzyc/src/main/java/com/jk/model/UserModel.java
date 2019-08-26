package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserModel implements Serializable {
    private Integer userId;
    private String userAccount;
    private String userPwd;
    private String imgCode;
    private String userPhone;
    private Integer phoneYan;

}
