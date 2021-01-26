package com.liyang.orchard.controller;
import com.liyang.orchard.core.Result;
import com.liyang.orchard.core.ResultGenerator;
import com.liyang.orchard.model.Watchlist;
import com.liyang.orchard.service.WatchlistService;
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
@RequestMapping("/watchlist")
@CrossOrigin
@Api(tags = "观看记录")
public class WatchlistController {
    @Resource
    private WatchlistService watchlistService;

    @ApiOperation(value = "添加-观看记录")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody Watchlist watchlist) {
        watchlistService.save(watchlist);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id删除-观看记录")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result delete(@ApiParam("") @RequestParam Integer id) {
        watchlistService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id更新-观看记录")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody Watchlist watchlist) {
        watchlistService.update(watchlist);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id查询-观看记录")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result detail(@ApiParam("") @RequestParam Integer id) {
        Watchlist watchlist = watchlistService.findById(id);
        return ResultGenerator.genSuccessResult(watchlist);
    }

    @ApiOperation(value = "分页查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@ApiParam("页数") @RequestParam(defaultValue = "0") Integer page, @ApiParam("每页展示数量")  @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Watchlist> list = watchlistService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
