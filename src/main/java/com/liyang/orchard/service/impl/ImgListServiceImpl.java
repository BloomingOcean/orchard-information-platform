package com.liyang.orchard.service.impl;

import com.liyang.orchard.dao.ImgListMapper;
import com.liyang.orchard.model.ImgList;
import com.liyang.orchard.service.ImgListService;
import com.liyang.orchard.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by Liyang on 2021/02/17.
 */
@Service
@Transactional
public class ImgListServiceImpl extends AbstractService<ImgList> implements ImgListService {
    @Resource
    private ImgListMapper imgListMapper;

    @Override
    public List<ImgList> selectByInfoSquareId(Integer infoSquareId) {
        return imgListMapper.selectByInfoSquareId(infoSquareId);
    }

    @Override
    public List<ImgList> selectByOwnerHouseId(Integer ownerHouseId) {
        return imgListMapper.selectByOwnerHouseId(ownerHouseId);
    }

    @Override
    public void deleteByInfoSquareId(Integer infoSquareId) {
        imgListMapper.deleteByInfoSquareId(infoSquareId);
    }

    @Override
    public void deleteByOwnerHouseId(Integer ownerHouseId) {
        imgListMapper.deleteByOwnerHouseId(ownerHouseId);
    }
}
