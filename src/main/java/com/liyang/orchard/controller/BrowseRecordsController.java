package com.liyang.orchard.controller;
import com.liyang.orchard.core.Result;
import com.liyang.orchard.core.ResultGenerator;
import com.liyang.orchard.model.BrowseRecords;
import com.liyang.orchard.service.BrowseRecordsService;
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
@RequestMapping("/browse_records")
@CrossOrigin
@Api(tags = "浏览记录")
public class BrowseRecordsController {
    @Resource
    private BrowseRecordsService browseRecordsService;

    @ApiOperation(value = "添加-浏览记录")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody BrowseRecords browseRecords) {
        browseRecordsService.save(browseRecords);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id删除-浏览记录")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result delete(@ApiParam("") @RequestParam Integer id) {
        browseRecordsService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id更新-浏览记录")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody BrowseRecords browseRecords) {
        browseRecordsService.update(browseRecords);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id查询-浏览记录")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result detail(@ApiParam("") @RequestParam Integer id) {
        BrowseRecords browseRecords = browseRecordsService.findById(id);
        return ResultGenerator.genSuccessResult(browseRecords);
    }

    @ApiOperation(value = "分页查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@ApiParam("页数") @RequestParam(defaultValue = "0") Integer page, @ApiParam("每页展示数量")  @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<BrowseRecords> list = browseRecordsService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
