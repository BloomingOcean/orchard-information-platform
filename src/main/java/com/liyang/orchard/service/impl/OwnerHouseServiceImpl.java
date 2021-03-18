package com.liyang.orchard.service.impl;

import com.liyang.orchard.dao.OwnerHouseMapper;
import com.liyang.orchard.model.ImgList;
import com.liyang.orchard.model.OwnerHouse;
import com.liyang.orchard.model.infosquare.PaginationInfoSquare;
import com.liyang.orchard.model.ownerhouse.AddOwnerHouse;
import com.liyang.orchard.model.ownerhouse.PaginationOwnerHouse;
import com.liyang.orchard.model.ownerhouse.UpdateOwnerHouse;
import com.liyang.orchard.service.ImgListService;
import com.liyang.orchard.service.OwnerHouseService;
import com.liyang.orchard.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by Liyang on 2021/01/30.
 */
@Service
@Transactional
public class OwnerHouseServiceImpl extends AbstractService<OwnerHouse> implements OwnerHouseService {
    @Resource
    private OwnerHouseMapper ownerHouseMapper;

    @Resource
    private ImgListService imgListService;

    @Override
    public void addOwnerHouse(AddOwnerHouse addOwnerHouse) {
        ownerHouseMapper.addOwnerHouse(addOwnerHouse);
        Integer idKey = addOwnerHouse.getOwnerHouseId();
        // 图片List存储
        List<String> imgList = new LinkedList<>();
        for (String newImgUrl: addOwnerHouse.getImgList()
        ) {
            imgListService.save(ImgList.builder().ownerHouseId(idKey).imgUrl(newImgUrl).build());
        }
    }

    @Override
    public void updateOwnerHouse(UpdateOwnerHouse updateOwnerHouse) {
        ownerHouseMapper.updateOwnerHouse(updateOwnerHouse);
        Integer idKey = updateOwnerHouse.getOwnerHouseId();
        // 图片List存储
        List<String> imgList = new LinkedList<>();
        for (String newImgUrl: updateOwnerHouse.getImgList()
        ) {
            imgListService.save(ImgList.builder().ownerHouseId(idKey).imgUrl(newImgUrl).build());
        }
    }

    @Override
    public List<PaginationOwnerHouse> selectOwnerHouseByElevator() {
        List<PaginationOwnerHouse> ownerHouseList = ownerHouseMapper.selectOwnerHouseByElevator();
        for (PaginationOwnerHouse ownerHouse : ownerHouseList) {
            List<ImgList> imgLists = imgListService.selectByOwnerHouseId(ownerHouse.getOwnerHouseId());
            List<String> imgList = new ArrayList<>();
            for (ImgList imgObject : imgLists) {
                imgList.add(imgObject.getImgUrl());
            }
            ownerHouse.setImgList(imgList);
        }
        return ownerHouseList;
    }

    @Override
    public List<PaginationOwnerHouse> selectOwnerHouseByStream() {
        List<PaginationOwnerHouse> ownerHouseList = ownerHouseMapper.selectOwnerHouseByStream();
        for (PaginationOwnerHouse ownerHouse : ownerHouseList) {
            List<ImgList> imgLists = imgListService.selectByOwnerHouseId(ownerHouse.getOwnerHouseId());
            List<String> imgList = new ArrayList<>();
            for (ImgList imgObject : imgLists) {
                imgList.add(imgObject.getImgUrl());
            }
            ownerHouse.setImgList(imgList);
        }
        return ownerHouseList;
    }

    @Override
    public void deleteById(Integer ownerHouseId){
        mapper.deleteByPrimaryKey(ownerHouseId);
        imgListService.deleteByOwnerHouseId(ownerHouseId);
    }
}
