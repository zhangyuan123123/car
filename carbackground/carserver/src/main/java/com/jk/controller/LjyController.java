/**
 * 此处不是注释
 * <p>
 * 业务描述
 *
 * @author 刘军谊
 * @create new Date();
 * @since 1.0.0
 */

package com.jk.controller;


import com.jk.model.CarModel;
import com.jk.model.OssImg;
import com.jk.service.LjyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("ljyController")
public class LjyController {


    @Resource
    private LjyService ljyService;


    /**
     * 首页轮播图查询
     */
    @RequestMapping("findLunBo")
    @ResponseBody
    public List<OssImg> findLunBo(){
        return ljyService.findLunBo();
    }


    /**
     * 热租车型查询
     */
    @RequestMapping("findCarByCity")
    @ResponseBody
    public List<CarModel> findCarByCity(Integer cityId){
        return ljyService.findCarByCity(cityId);
    }


    /**
     * 刷新页面新增访问量
     */
    @RequestMapping("addVisit")
    @ResponseBody
    public String addVisit(){
        ljyService.addVisit();
        return "";
    }


}
