package com.jk.mapper;

import com.jk.model.OrderBean;

import java.util.LinkedHashMap;
import java.util.List;

public interface CarMapper {
    List<LinkedHashMap> refer();

    List<LinkedHashMap> cityrefer();

    List<LinkedHashMap> refermendian(String cityid);

    List<LinkedHashMap> refercar(String cityid);

    List<LinkedHashMap> hairefer(Integer hid);

    List<LinkedHashMap> qurefer(Integer qid);

    List<LinkedHashMap> refercom(Integer userid);

    List<LinkedHashMap> referinsurance();

    Integer addorder(OrderBean orderBean);

    void upuser(String uid);

}
