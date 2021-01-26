package com.liyang.orchard.controller;
import com.liyang.orchard.core.Result;
import com.liyang.orchard.core.ResultGenerator;
import com.liyang.orchard.model.Feedback;
import com.liyang.orchard.service.FeedbackService;
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
@RequestMapping("/feedback")
@CrossOrigin
@Api(tags = "反馈")
public class FeedbackController {
    @Resource
    private FeedbackService feedbackService;

    @ApiOperation(value = "添加-反馈")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody Feedback feedback) {
        feedbackService.save(feedback);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id删除-反馈")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result delete(@ApiParam("") @RequestParam Integer id) {
        feedbackService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id更新-反馈")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody Feedback feedback) {
        feedbackService.update(feedback);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id查询-反馈")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result detail(@ApiParam("") @RequestParam Integer id) {
        Feedback feedback = feedbackService.findById(id);
        return ResultGenerator.genSuccessResult(feedback);
    }

    @ApiOperation(value = "分页查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@ApiParam("页数") @RequestParam(defaultValue = "0") Integer page, @ApiParam("每页展示数量")  @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Feedback> list = feedbackService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
