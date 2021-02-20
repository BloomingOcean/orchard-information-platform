package com.liyang.orchard.service.impl;

import com.liyang.orchard.dao.ProvinceCityDistrictMapper;
import com.liyang.orchard.model.pojo.ProvinceCityDistrict;
import com.liyang.orchard.service.ProvinceCityDistrictService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProvinceCityDistrictServiceImpl implements ProvinceCityDistrictService {

    @Resource
    private ProvinceCityDistrictMapper provinceCityDistrictMapper;

    @Override
    public List<ProvinceCityDistrict> getProvince() {
        return provinceCityDistrictMapper.getProvince();
    }

    @Override
    public List<ProvinceCityDistrict> getCityByProvince(Integer provinceId) {
        String provincePrefix = provinceId.toString().substring(0,2);
        return provinceCityDistrictMapper.getCityByProvince(provincePrefix+"%");
    }

    @Override
    public List<ProvinceCityDistrict> getDistrictByCity(Integer cityId) {
        String cityPrefix = cityId.toString().substring(0,4);
        return provinceCityDistrictMapper.getDistrictByCity(cityPrefix+"%");
    }
}
