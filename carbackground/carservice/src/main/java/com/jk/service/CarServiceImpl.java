package com.jk.service;

import com.jk.mapper.CarMapper;
import com.jk.model.OrderBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    @Resource
    private CarMapper carMapper;
    @Override
    public HashMap<String, Object> refer() {
        HashMap<String,Object> map=new HashMap<>();
        List<LinkedHashMap> list=carMapper.refer();
        map.put("data",list);
        return map;
    }

    @Override
    public HashMap<String, Object> cityrefer() {
        HashMap<String,Object> map=new HashMap<>();
        List<LinkedHashMap> list=carMapper.cityrefer();
        map.put("data",list);
        return map;
    }

    @Override
    public HashMap<String, Object> refermendian(String cityid) {
        HashMap<String,Object> map=new HashMap<>();
        List<LinkedHashMap> list=carMapper.refermendian(cityid);
        map.put("data",list);
        return map;
    }

    @Override
    public HashMap<String, Object> refercar(String cityid) {
        HashMap<String,Object> map=new HashMap<>();
        List<LinkedHashMap> list=carMapper.refercar(cityid);
        map.put("data",list);
        return map;
    }

    @Override
    public HashMap<String, Object> qurefer(Integer qid) {
        HashMap<String,Object> map=new HashMap<>();
        List<LinkedHashMap> list=carMapper.qurefer(qid);
        map.put("data",list);
        return map;
    }

    @Override
    public HashMap<String, Object> hairefer(Integer hid) {
        HashMap<String,Object> map=new HashMap<>();
        List<LinkedHashMap> list=carMapper.hairefer(hid);
        map.put("data",list);
        return map;
    }

    @Override
    public HashMap<String, Object> refercom(Integer userid) {
        HashMap<String,Object> map=new HashMap<>();
        List<LinkedHashMap> list=carMapper.refercom(userid);
        map.put("data",list);
        return map;
    }

    @Override
    public HashMap<String, Object> referinsurance() {
        HashMap<String,Object> map=new HashMap<>();
        List<LinkedHashMap> list=carMapper.referinsurance();
        map.put("data",list);
        return map;
    }

    @Override
    public Integer addorder(OrderBean orderBean) {

        Integer flag=carMapper.addorder(orderBean);
        if (flag==1) {
            if (orderBean.getYouhuiquan() != null) {
                carMapper.upuser(orderBean.getUid());
            }
        }
        return flag;
    }
}
