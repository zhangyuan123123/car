/**
 * 此处不是注释
 * <p>
 * 业务描述
 *
 * @author 刘军谊
 * @create new Date();
 * @since 1.0.0
 */

package com.jk.service;

import com.jk.mapper.LjyMapper;
import com.jk.model.CarModel;
import com.jk.model.OssImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LjyServiceImpl implements LjyService {

    @Resource
    private LjyMapper ljyMapper;


    /**
     * 首页轮播图查询
     * @return
     */
    @Override
    public List<OssImg> findLunBo() {
        return ljyMapper.findLunBo();
    }


    /**
     * 首页热租车型查询
     * @param cityId
     * @return
     */
    @Override
    public List<CarModel> findCarByCity(Integer cityId) {
        List<CarModel> list = ljyMapper.findCarByCity(cityId);
        return list;
    }


    /**
     * 刷新页面新增访问量
     */
    @Override
    public void addVisit() {
        ljyMapper.addVisit();
    }
}
