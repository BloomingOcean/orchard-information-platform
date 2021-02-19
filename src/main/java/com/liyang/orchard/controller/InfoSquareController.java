package com.liyang.orchard.controller;
import com.liyang.orchard.core.Result;
import com.liyang.orchard.core.ResultGenerator;
import com.liyang.orchard.model.InfoSquare;
import com.liyang.orchard.model.infosquare.*;
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
@RequestMapping("/square")
@CrossOrigin
@Api(tags = "信息广场")
public class InfoSquareController {
    @Resource
    private InfoSquareService infoSquareService;

//    @Resource
//    private DetailsInfoSquareService detailsInfoSquareService;

//    @ApiOperation(value = "添加-信息广场")
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public Result add(@RequestBody InfoSquare infoSquare) {
//        infoSquareService.save(infoSquare);
//        return ResultGenerator.genSuccessResult();
//    }

    @ApiOperation(value = "删除我发布的信息")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result delete(@ApiParam("信息id") @RequestParam Integer id) {
        infoSquareService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

//    @ApiOperation(value = "更新我发布的信息")
//    @RequestMapping(value = "/update", method = RequestMethod.PUT)
//    public Result update(@RequestBody InfoSquare infoSquare) {
//        infoSquareService.update(infoSquare);
//        return ResultGenerator.genSuccessResult();
//    }

    @ApiOperation(value = "根据id查询-信息广场")
    @RequestMapping(value = "/sebyid", method = RequestMethod.GET)
    public Result detail(@ApiParam("信息Id") @RequestParam Integer id) {
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

    @ApiOperation(value = "查询指定id的详细信息")
    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public Result details(@RequestParam Integer id) {
        return ResultGenerator.genSuccessResult(infoSquareService.selectDetailsInfoSquareById(id));
    }

    @ApiOperation(value = "发布求购信息")
    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public Result buy(@RequestBody BuyInfoSquare buyInfoSquare) {
        infoSquareService.insertBuyInfoSquare(buyInfoSquare);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "发布供应信息")
    @RequestMapping(value = "/supply", method = RequestMethod.POST)
    public Result supply(@RequestBody SupplyInfoSquare supplyInfoSquare) {
        infoSquareService.insertSupplyInfoSquare(supplyInfoSquare);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "发布转让信息")
    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public Result transfer(@RequestBody TransferInfoSquare transferInfoSquare) {
        infoSquareService.insertTransferInfoSquare(transferInfoSquare);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "发布劳务信息")
    @RequestMapping(value = "/labour", method = RequestMethod.POST)
    public Result labour(@RequestBody LabourInfoSquare labourInfoSquare) {
        infoSquareService.insertLabourInfoSquare(labourInfoSquare);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "发布租赁信息")
    @RequestMapping(value = "/lease", method = RequestMethod.POST)
    public Result lease(@RequestBody LeaseInfoSquare leaseInfoSquare) {
        infoSquareService.insertLeaseInfoSquare(leaseInfoSquare);
        return ResultGenerator.genSuccessResult();
    }

    // 还差List<ImgList>没实现
    @ApiOperation(value = "查询 我发布的信息")
    @RequestMapping(value = "/mylist", method = RequestMethod.GET)
    public Result mylist(@ApiParam("页数") @RequestParam(defaultValue = "0") Integer page,
                         @ApiParam("每页展示数量") @RequestParam(defaultValue = "0") Integer size,
                         @ApiParam("用户id") @RequestParam(defaultValue = "0") Integer userId) {
        PageHelper.startPage(page, size);
        List<PaginationInfoSquare> list = infoSquareService.selectMyInfoSquareList(userId);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "修改 发布的信息")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update(@RequestBody InfoSquare infoSquare) {
        return infoSquareService.updateInfoSquare(infoSquare);
    }
}
