package com.liyang.orchard.service;

import com.liyang.orchard.model.pojo.ProvinceCityDistrict;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProvinceCityDistrictService {
    List<ProvinceCityDistrict> getProvince();

    List<ProvinceCityDistrict> getCityByProvince(Integer provinceId);

    List<ProvinceCityDistrict> getDistrictByCity(Integer cityId);

}
