package com.liyang.orchard.dao;

import com.liyang.orchard.model.pojo.ProvinceCityDistrict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProvinceCityDistrictMapper {

    List<ProvinceCityDistrict> getProvince();

    List<ProvinceCityDistrict> getCityByProvince(@Param("provincePrefix") String provincePrefix);

    List<ProvinceCityDistrict> getDistrictByCity(@Param("cityPrefix") String cityPrefix);
}
