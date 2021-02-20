package com.liyang.orchard.controller;
import com.liyang.orchard.core.Result;
import com.liyang.orchard.core.ResultGenerator;
import com.liyang.orchard.model.Comment;
import com.liyang.orchard.model.commentreport.AddInfoSquareComment;
import com.liyang.orchard.model.commentreport.AddOwnerHouseComment;
import com.liyang.orchard.service.CommentService;
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
* Created by Liyang on 2021/01/25.
*/
@RestController
@RequestMapping("/comment")
@CrossOrigin
@Api(tags = "评论")
public class CommentController {
    @Resource
    private CommentService commentService;

//    @ApiOperation(value = "添加-评论")
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public Result add(@RequestBody Comment comment) {
//        commentService.save(comment);
//        return ResultGenerator.genSuccessResult();
//    }

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

    @ApiOperation(value = "删除评论(同时删除其下回复)")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result deleteInfoSquareComment(@ApiParam("评论id") @RequestParam Integer id) {
        commentService.deleteByCommentId(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "信息广场 评论")
    @RequestMapping(value = "/addInfoSquare", method = RequestMethod.POST)
    public Result addInfoSquareComment(@RequestBody AddInfoSquareComment addSC) {
        commentService.addInfoSquareComment(addSC);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "园主之家 评论")
    @RequestMapping(value = "/addOwnerHouse", method = RequestMethod.POST)
    public Result addOwnerHouseComment(@RequestBody AddOwnerHouseComment addHC) {
        commentService.addOwnerHouseComment(addHC);
        return ResultGenerator.genSuccessResult();
    }

    @ApiIgnore
    @ApiOperation(value = "根据id更新-评论")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody Comment comment) {
        commentService.update(comment);
        return ResultGenerator.genSuccessResult();
    }
}
