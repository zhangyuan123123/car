package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class CouponModel {
    /**
     * 订单model
     */
    private Integer couponId;
    private String couponTitle;
    private Integer imgId;
    private String couponTimeliness;
    private Integer couponQuantity;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date couponStarttime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date couponEndtime;
    private Integer couponStatus;
    private String couponType;
    private Integer couponPrice;
    private String coupon;
    private Integer shiyongyouhuiquan;
    private String imgUrl;


    /**
     * 用户model
     */
    private Integer userId;
    private String userAccount;
    private String userPwd;
    private String imgCode;
    private String userPhone;
    private Integer phoneYan;

}
