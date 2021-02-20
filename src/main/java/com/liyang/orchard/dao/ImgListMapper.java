package com.liyang.orchard.dao;

import com.liyang.orchard.core.Mapper;
import com.liyang.orchard.model.ImgList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface ImgListMapper extends Mapper<ImgList> {

    List<ImgList> selectByInfoSquareId(@Param("infoSquareId") Integer infoSquareId);

    List<ImgList> selectByOwnerHouseId(@Param("ownerHouseId") Integer ownerHouseId);

    void deleteByInfoSquareId(@Param("infoSquareId") Integer infoSquareId);

    void deleteByOwnerHouseId(@Param("ownerHouseId") Integer ownerHouseId);
}