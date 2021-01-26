package com.liyang.orchard.controller;
import com.liyang.orchard.core.Result;
import com.liyang.orchard.core.ResultGenerator;
import com.liyang.orchard.model.Comment;
import com.liyang.orchard.service.CommentService;
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
@RequestMapping("/comment")
@CrossOrigin
@Api(tags = "评论")
public class CommentController {
    @Resource
    private CommentService commentService;

    @ApiOperation(value = "添加-评论")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody Comment comment) {
        commentService.save(comment);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id删除-评论")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result delete(@ApiParam("") @RequestParam Integer id) {
        commentService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id更新-评论")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody Comment comment) {
        commentService.update(comment);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id查询-评论")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result detail(@ApiParam("") @RequestParam Integer id) {
        Comment comment = commentService.findById(id);
        return ResultGenerator.genSuccessResult(comment);
    }

    @ApiOperation(value = "分页查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@ApiParam("页数") @RequestParam(defaultValue = "0") Integer page, @ApiParam("每页展示数量")  @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Comment> list = commentService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
