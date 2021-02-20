package com.liyang.orchard;

import com.liyang.orchard.config.shiro.UserRealm;
import com.liyang.orchard.dao.ProvinceCityDistrictMapper;
import com.liyang.orchard.service.FeedbackService;
import com.liyang.orchard.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

import static java.awt.SystemColor.info;

public class UserTest extends Tester{
    private Logger logger = LoggerFactory.getLogger(UserTest.class);

    @Resource
    private FeedbackService feedbackService;

    @Resource
    private UserService userService;

    @Resource
    private ProvinceCityDistrictMapper provinceCityDistrictMapper;

    @Test
    public void feedback(){
        System.out.println(feedbackService.findAll());
        System.out.println(feedbackService.findById(1).getIpAddress());
    }

    @Test
    public void provinceCityDistrict(){
        Integer in = 123456;
        logger.info(in.toString().substring(0,2));
//        System.out.println("provincePrefix".substring(0, 2));
//        System.out.println(provinceCityDistrictMapper.getProvince());
//        System.out.println(provinceCityDistrictMapper.getCityByProvince("21%"));
//        System.out.println(provinceCityDistrictMapper.getDistrictByCity("2109%"));
    }

    @Test
    public void user(){
//        System.out.println(userService.getSimpleUserInfo(1));
        System.out.println(userService.findById(1));
    }
}
