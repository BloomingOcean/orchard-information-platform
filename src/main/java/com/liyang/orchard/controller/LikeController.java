package com.liyang.orchard.controller;
import com.liyang.orchard.core.Result;
import com.liyang.orchard.core.ResultGenerator;
import com.liyang.orchard.model.Like;
import com.liyang.orchard.service.LikeService;
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
@RequestMapping("/like")
@CrossOrigin
@Api(tags = "点赞")
public class LikeController {
    @Resource
    private LikeService likeService;

    @ApiOperation(value = "添加-点赞")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody Like like) {
        likeService.save(like);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id删除-点赞")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result delete(@ApiParam("") @RequestParam Integer id) {
        likeService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id更新-点赞")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody Like like) {
        likeService.update(like);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id查询-点赞")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result detail(@ApiParam("") @RequestParam Integer id) {
        Like like = likeService.findById(id);
        return ResultGenerator.genSuccessResult(like);
    }

    @ApiOperation(value = "分页查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@ApiParam("页数") @RequestParam(defaultValue = "0") Integer page, @ApiParam("每页展示数量")  @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Like> list = likeService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
