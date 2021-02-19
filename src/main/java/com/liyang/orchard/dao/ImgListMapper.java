package com.liyang.orchard.dao;

import com.liyang.orchard.core.Mapper;
import com.liyang.orchard.model.ImgList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface ImgListMapper extends Mapper<ImgList> {

    List<ImgList> selectByInfoSquareId(@Param("InfoSquareId") Integer infoSquareId);

    List<ImgList> selectByOwnerHouseId(@Param("OwnerHouseId") Integer ownerHouseId);

    void deleteByInfoSquareId(@Param("InfoSquareId") Integer infoSquareId);

    void deleteByOwnerHouseId(@Param("OwnerHouseId") Integer ownerHouseId);
}