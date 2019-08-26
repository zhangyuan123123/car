package com.jk.service;

import com.jk.model.CarModel;
import com.jk.model.OssImg;

import java.util.List;

public interface LjyService {
    List<OssImg> findLunBo();

    List<CarModel> findCarByCity(Integer cityId);

    void addVisit();
}
