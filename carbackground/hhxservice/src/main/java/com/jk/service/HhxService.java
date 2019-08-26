package com.jk.service;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Package com.jk.service
 * @作者 韩慧鑫
 * @创建时间 2019/6/19 16:44
 */
public interface HhxService {
    List<LinkedHashMap> findCarCity(String cityName);

    LinkedHashMap findCarCityByXingId(String cityName, Integer id);

    List<LinkedHashMap> findmendian(Integer id, String cityName);
}
