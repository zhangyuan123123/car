package com.jk.service;

import com.jk.model.OrderBean;

import java.util.HashMap;

public interface CarService {
    HashMap<String, Object> refer();

    HashMap<String, Object> cityrefer();

    HashMap<String, Object> refermendian(String cityid);

    HashMap<String, Object> refercar(String cityid);

    HashMap<String, Object> qurefer(Integer qid);

    HashMap<String, Object> hairefer(Integer hid);

    HashMap<String, Object> refercom(Integer userid);

    HashMap<String, Object> referinsurance();

    Integer addorder(OrderBean orderBean);
}
