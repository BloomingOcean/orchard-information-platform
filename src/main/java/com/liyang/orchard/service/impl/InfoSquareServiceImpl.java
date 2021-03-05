package com.liyang.orchard.service.impl;

import com.liyang.orchard.core.Result;
import com.liyang.orchard.core.ResultGenerator;
import com.liyang.orchard.dao.ImgListMapper;
import com.liyang.orchard.dao.InfoSquareMapper;
import com.liyang.orchard.dao.UserMapper;
import com.liyang.orchard.model.ImgList;
import com.liyang.orchard.model.InfoSquare;
import com.liyang.orchard.model.User;
import com.liyang.orchard.model.infosquare.*;
import com.liyang.orchard.service.ImgListService;
import com.liyang.orchard.service.InfoSquareService;
import com.liyang.orchard.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by Liyang on 2021/01/25.
 */
@Service
@Transactional
public class InfoSquareServiceImpl extends AbstractService<InfoSquare> implements InfoSquareService {
    @Resource
    private InfoSquareMapper infoSquareMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private ImgListService imgListService;

    @Override
    public void deleteById(Integer infoSquareId){
        mapper.deleteByPrimaryKey(infoSquareId);
        imgListService.deleteByInfoSquareId(infoSquareId);
    }

    @Override
    public DetailsInfoSquare selectDetailsInfoSquareById(Integer id) {
        InfoSquare infoSquare = infoSquareMapper.getInfoById(id);
        DetailsInfoSquare detailsInfoSquare = new DetailsInfoSquare();
        // 赋值
        detailsInfoSquare.setInfoId(infoSquare.getInfoId());
        detailsInfoSquare.setTitle(infoSquare.getTitle());
        detailsInfoSquare.setDescription(infoSquare.getDescription());
        detailsInfoSquare.setVideoUrl(infoSquare.getVideoUrl());
        detailsInfoSquare.setInfoTypeId(infoSquare.getInfoTypeId());
        detailsInfoSquare.setTags(infoSquare.getTags());
        // nickname
        User user = userMapper.findByPhone(infoSquare.getPhone());
        detailsInfoSquare.setUserNikename(user.getNickname());
        // 图片List赋值
        List<String> imgList = new LinkedList<>();
        for (ImgList Temp: imgListService.selectByInfoSquareId(infoSquare.getInfoId())
        ) {imgList.add(Temp.getImgUrl());
        }
        detailsInfoSquare.setImgList(imgList);
        return detailsInfoSquare;
    }

    /**
     * useGeneratedKeys返回的是0或1，id的值会返回到参数实体的id里面去
     * @param buyInfoSquare
     */
    @Override
    public void insertBuyInfoSquare(BuyInfoSquare buyInfoSquare){
        String name = userMapper.selectByPrimaryKey(buyInfoSquare.getUserId()).getName();
        infoSquareMapper.insertBuyInfoSquare(buyInfoSquare, name);
        // 获得返回给参数的UserId的值
        Integer idKey = buyInfoSquare.getInfoId();
        // 图片List存储
        List<String> imgList = new LinkedList<>();
        for (String newImgUrl: buyInfoSquare.getImgList()
        ) {
            imgListService.save(ImgList.builder().infoSquareId(idKey).imgUrl(newImgUrl).build());
        }
    }

    @Override
    public void insertSupplyInfoSquare(SupplyInfoSquare supplyInfoSquare) {
        String name = userMapper.selectByPrimaryKey(supplyInfoSquare.getUserId()).getName();
        infoSquareMapper.insertSupplyInfoSquare(supplyInfoSquare, name);
        // 获得返回给参数的UserId的值
        Integer idKey = supplyInfoSquare.getInfoId();
        // 图片List存储
        List<String> imgList = new LinkedList<>();
        for (String newImgUrl: supplyInfoSquare.getImgList()
        ) {
            imgListService.save(ImgList.builder().infoSquareId(idKey).imgUrl(newImgUrl).build());
        }
    }

    @Override
    public void insertLabourInfoSquare(LabourInfoSquare labourInfoSquare) {
        String name = userMapper.selectByPrimaryKey(labourInfoSquare.getUserId()).getName();
        infoSquareMapper.insertLabourInfoSquare(labourInfoSquare, name);
        // 获得返回给参数的UserId的值
        Integer idKey = labourInfoSquare.getInfoId();
        // 图片List存储
        List<String> imgList = new LinkedList<>();
        for (String newImgUrl: labourInfoSquare.getImgList()
        ) {
            imgListService.save(ImgList.builder().infoSquareId(idKey).imgUrl(newImgUrl).build());
        }
    }

    @Override
    public void insertLeaseInfoSquare(LeaseInfoSquare leaseInfoSquare) {
        String name = userMapper.selectByPrimaryKey(leaseInfoSquare.getUserId()).getName();
        infoSquareMapper.insertLeaseInfoSquare(leaseInfoSquare, name);
        // 获得返回给参数的UserId的值
        Integer idKey = leaseInfoSquare.getInfoId();
        // 图片List存储
        List<String> imgList = new LinkedList<>();
        for (String newImgUrl: leaseInfoSquare.getImgList()
        ) {
            imgListService.save(ImgList.builder().infoSquareId(idKey).imgUrl(newImgUrl).build());
        }
    }

    @Override
    public void insertTransferInfoSquare(TransferInfoSquare transferInfoSquare) {
        String name = userMapper.selectByPrimaryKey(transferInfoSquare.getUserId()).getName();
        infoSquareMapper.insertTransferInfoSquare(transferInfoSquare, name);
        // 获得返回给参数的UserId的值
        Integer idKey = transferInfoSquare.getInfoId();
        // 图片List存储
        List<String> imgList = new LinkedList<>();
        for (String newImgUrl: transferInfoSquare.getImgList()
        ) {
            imgListService.save(ImgList.builder().infoSquareId(idKey).imgUrl(newImgUrl).build());
        }
    }

    @Override
    public List<PaginationInfoSquare> selectMyInfoSquareList(Integer userId) {
//        List<String> imgList = new LinkedList<>();
        List<PaginationInfoSquare> list = infoSquareMapper.selectMyInfoSquareList(userId);
        // for循环赋值（效率不高）
        //        for (int i = 0; i < list.size(); i++) {
//            Integer infoId = list.get(i).getInfoId();
//            System.out.println("infoId:"+infoId);
//            List<ImgList> imgLists = imgListMapper.selectByInfoSquareId(infoId);
//            List<String> imgList = new LinkedList<>();
//            for (int i1 = 0; i1 < imgLists.size(); i1++) {
//                imgList.add(imgLists.get(i1).getImgUrl());
//            }
//            System.out.println("imgList:"+imgList);
//            List<String> imgList2 = imgList;
//            list.get(i).setImgList(imgList2);
//            imgList.clear();
//        }
        return list;
    }

    @Override
    public InfoSquare selectInfoSquareAllById(Integer infoId) {
        return infoSquareMapper.selectInfoSquareAllById(infoId);
    }

    public Result updateInfoSquare(UpdateInfoSquare updateInfoSquare) {
        try{
            // 更新info_square表的数据
            String name = userMapper.selectByPrimaryKey(updateInfoSquare.getUserId()).getName();
            infoSquareMapper.updateInfoSquare(updateInfoSquare, name);
        }catch (NullPointerException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("无此用户");
        }
        Integer infoSquareId = updateInfoSquare.getInfoId();
        System.out.println("infoSquareId:"+infoSquareId);
        // 删除imgList原先图片
        imgListService.deleteByInfoSquareId(infoSquareId);
        // 更新imgList表数据
//        List<String> imgList = new LinkedList<>();
//        for (String newImgUrl: infoSquare.getImgList()
//        ) {
//            imgListService.save(ImgList.builder().infoSquareId(infoSquareId).imgUrl(newImgUrl).build());
//        }
        List<String> imgList = new LinkedList<>();
        for (String newUrl: updateInfoSquare.getImgList()
        ) {
            imgListService.save(ImgList.builder().infoSquareId(infoSquareId).imgUrl(newUrl).build());
        }
        return ResultGenerator.genSuccessResult();
    }
}
