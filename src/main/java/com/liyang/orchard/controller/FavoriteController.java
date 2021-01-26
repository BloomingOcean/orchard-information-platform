package com.liyang.orchard.controller;
import com.liyang.orchard.core.Result;
import com.liyang.orchard.core.ResultGenerator;
import com.liyang.orchard.model.Favorite;
import com.liyang.orchard.service.FavoriteService;
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
@RequestMapping("/favorite")
@CrossOrigin
@Api(tags = "收藏")
public class FavoriteController {
    @Resource
    private FavoriteService favoriteService;

    @ApiOperation(value = "添加-收藏")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody Favorite favorite) {
        favoriteService.save(favorite);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id删除-收藏")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result delete(@ApiParam("") @RequestParam Integer id) {
        favoriteService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id更新-收藏")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody Favorite favorite) {
        favoriteService.update(favorite);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id查询-收藏")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result detail(@ApiParam("") @RequestParam Integer id) {
        Favorite favorite = favoriteService.findById(id);
        return ResultGenerator.genSuccessResult(favorite);
    }

    @ApiOperation(value = "分页查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@ApiParam("页数") @RequestParam(defaultValue = "0") Integer page, @ApiParam("每页展示数量")  @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Favorite> list = favoriteService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
