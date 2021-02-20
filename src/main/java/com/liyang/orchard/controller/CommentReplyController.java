package com.liyang.orchard.controller;
import com.liyang.orchard.core.Result;
import com.liyang.orchard.core.ResultGenerator;
import com.liyang.orchard.model.CommentReply;
import com.liyang.orchard.model.commentreport.AddCommentReply;
import com.liyang.orchard.service.CommentReplyService;
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
* Created by Liyang on 2021/02/20.
*/
@RestController
@RequestMapping("/commentReply")
@CrossOrigin
@Api(tags = "回复")
public class CommentReplyController {
    @Resource
    private CommentReplyService commentReplyService;

//    @ApiOperation(value = "添加-回复")
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public Result add(@RequestBody CommentReply commentReply) {
//        commentReplyService.save(commentReply);
//        return ResultGenerator.genSuccessResult();
//    }

//    @ApiOperation(value = "根据id删除-回复")
//    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
//    public Result delete(@ApiParam("") @RequestParam Integer id) {
//        commentReplyService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }

    @ApiIgnore
    @ApiOperation(value = "根据id更新-回复")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody CommentReply commentReply) {
        commentReplyService.update(commentReply);
        return ResultGenerator.genSuccessResult();
    }

    @ApiIgnore
    @ApiOperation(value = "根据id查询-回复")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result detail(@ApiParam("") @RequestParam Integer id) {
        CommentReply commentReply = commentReplyService.findById(id);
        return ResultGenerator.genSuccessResult(commentReply);
    }

    @ApiIgnore
    @ApiOperation(value = "分页查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@ApiParam("页数") @RequestParam(defaultValue = "0") Integer page, @ApiParam("每页展示数量")  @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CommentReply> list = commentReplyService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "评论下回复")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result addCommentReply(@RequestBody AddCommentReply addCommentReply) {
        commentReplyService.addCommentReply(addCommentReply);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "删除回复")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result deleteCommentReplyById(@RequestParam("commentReplyId") Integer CommentReplyId) {
        commentReplyService.deleteCommentReplyById(CommentReplyId);
        return ResultGenerator.genSuccessResult();
    }

}
