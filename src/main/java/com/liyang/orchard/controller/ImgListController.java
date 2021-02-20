package com.liyang.orchard.controller;
import com.liyang.orchard.core.Result;
import com.liyang.orchard.core.ResultGenerator;
import com.liyang.orchard.model.ImgList;
import com.liyang.orchard.service.ImgListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Liyang on 2021/02/17.
*/
@RestController
@RequestMapping("/img/list")
@CrossOrigin
@Api(tags = "")
@ApiIgnore
public class ImgListController {
    @Resource
    private ImgListService imgListService;

    @ApiOperation(value = "添加-")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody ImgList imgList) {
        imgListService.save(imgList);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id删除-")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result delete(@ApiParam("") @RequestParam Integer id) {
        imgListService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id更新-")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody ImgList imgList) {
        imgListService.update(imgList);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id查询-")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result detail(@ApiParam("") @RequestParam Integer id) {
        ImgList imgList = imgListService.findById(id);
        return ResultGenerator.genSuccessResult(imgList);
    }

    @ApiOperation(value = "分页查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@ApiParam("页数") @RequestParam(defaultValue = "0") Integer page, @ApiParam("每页展示数量")  @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ImgList> list = imgListService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
