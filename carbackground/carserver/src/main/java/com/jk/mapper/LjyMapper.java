package com.jk.mapper;

import com.jk.model.CarModel;
import com.jk.model.OssImg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LjyMapper {


    //首页轮播图查询
    List<OssImg> findLunBo();

    //首页热租车型查询
    List<CarModel> findCarByCity(@Param("cityId") Integer cityId);

    //刷新页面新增访问量
    void addVisit();
}
