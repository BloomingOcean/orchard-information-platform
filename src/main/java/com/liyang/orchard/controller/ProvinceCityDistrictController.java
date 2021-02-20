package com.liyang.orchard.controller;

import com.liyang.orchard.core.Result;
import com.liyang.orchard.core.ResultGenerator;
import com.liyang.orchard.model.Report;
import com.liyang.orchard.model.pojo.ProvinceCityDistrict;
import com.liyang.orchard.service.ProvinceCityDistrictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/cascade")
@CrossOrigin
@Api(tags = "省市区")
public class ProvinceCityDistrictController {

    @Resource
    private ProvinceCityDistrictService provinceCityDistrictService;

    @ApiOperation(value = "获取省信息")
    @RequestMapping(value = "/province", method = RequestMethod.POST)
    public Result getProvince() {
        List<ProvinceCityDistrict> provinceList = provinceCityDistrictService.getProvince();
        return ResultGenerator.genSuccessResult(provinceList);
    }

    @ApiOperation(value = "获取市信息")
    @RequestMapping(value = "/city", method = RequestMethod.POST)
    public Result getCity(@RequestParam("provinceId") Integer provinceId) {
        List<ProvinceCityDistrict> cityList = provinceCityDistrictService.getCityByProvince(provinceId);
        return ResultGenerator.genSuccessResult(cityList);
    }

    @ApiOperation(value = "获取区县信息")
    @RequestMapping(value = "/district", method = RequestMethod.POST)
    public Result getDistrict(@RequestParam("cityId") Integer cityId) {
        List<ProvinceCityDistrict> districtList = provinceCityDistrictService.getDistrictByCity(cityId);
        return ResultGenerator.genSuccessResult(districtList);
    }

}
