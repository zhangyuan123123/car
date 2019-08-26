package com.jk.service;

import com.jk.mapper.HhxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Package com.jk.service
 * @作者 韩慧鑫
 * @创建时间 2019/6/19 16:45
 */
@Service
public class HhxServiceImpl implements  HhxService{
    @Autowired
    private HhxMapper hhxMapper;

    @Override
    public List<LinkedHashMap> findCarCity(String cityName) {
        List<LinkedHashMap> list=hhxMapper.findCarCity(cityName);
        return list;
    }

    @Override
    public LinkedHashMap findCarCityByXingId(String cityName, Integer id) {
        return hhxMapper.findCarCityByXingId(cityName,id);
    }

    @Override
    public List<LinkedHashMap> findmendian(Integer id, String cityName) {
        List<LinkedHashMap> list=hhxMapper.findmendian(id,cityName);
        return list;
    }
}
