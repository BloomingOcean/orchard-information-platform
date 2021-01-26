package com.liyang.orchard.controller;
import com.liyang.orchard.core.Result;
import com.liyang.orchard.core.ResultGenerator;
import com.liyang.orchard.model.Report;
import com.liyang.orchard.service.ReportService;
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
@RequestMapping("/report")
@CrossOrigin
@Api(tags = "举报")
public class ReportController {
    @Resource
    private ReportService reportService;

    @ApiOperation(value = "添加-举报信息")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody Report report) {
        reportService.save(report);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id删除-举报信息")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result delete(@ApiParam("") @RequestParam Integer id) {
        reportService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id更新-举报信息")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody Report report) {
        reportService.update(report);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id查询-举报信息")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result detail(@ApiParam("") @RequestParam Integer id) {
        Report report = reportService.findById(id);
        return ResultGenerator.genSuccessResult(report);
    }

    @ApiOperation(value = "分页查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@ApiParam("页数") @RequestParam(defaultValue = "0") Integer page, @ApiParam("每页展示数量")  @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Report> list = reportService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
