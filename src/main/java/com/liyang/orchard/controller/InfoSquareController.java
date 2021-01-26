package com.liyang.orchard.controller;
import com.liyang.orchard.core.Result;
import com.liyang.orchard.core.ResultGenerator;
import com.liyang.orchard.model.InfoSquare;
import com.liyang.orchard.service.InfoSquareService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Liyang on 2021/01/25.
*/
@RestController
@RequestMapping("/info_square")
@CrossOrigin
@Api(tags = "信息广场")
public class InfoSquareController {
    @Resource
    private InfoSquareService infoSquareService;

    @ApiOperation(value = "添加-信息广场")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody InfoSquare infoSquare) {
        infoSquareService.save(infoSquare);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id删除-信息广场")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result delete(@ApiParam("") @RequestParam Integer id) {
        infoSquareService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id更新-信息广场")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody InfoSquare infoSquare) {
        infoSquareService.update(infoSquare);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id查询-信息广场")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result detail(@ApiParam("") @RequestParam Integer id) {
        InfoSquare infoSquare = infoSquareService.findById(id);
        return ResultGenerator.genSuccessResult(infoSquare);
    }

    @ApiOperation(value = "分页查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@ApiParam("页数") @RequestParam(defaultValue = "0") Integer page, @ApiParam("每页展示数量")  @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<InfoSquare> list = infoSquareService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
