package com.jk.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Package com.jk.mapper
 * @作者 韩慧鑫
 * @创建时间 2019/6/19 16:45
 */
public interface HhxMapper {
    List<LinkedHashMap> findCarCity(@Param("cityName") String cityName);

    LinkedHashMap findCarCityByXingId(@Param("cityName") String cityName,@Param("id") Integer id);

    List<LinkedHashMap> findmendian(@Param("id") Integer id,@Param("cityName") String cityName);
}
