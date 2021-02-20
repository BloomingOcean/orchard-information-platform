package com.liyang.orchard.dao;

import com.liyang.orchard.core.Mapper;
import com.liyang.orchard.model.OwnerHouse;
import com.liyang.orchard.model.ownerhouse.AddOwnerHouse;
import com.liyang.orchard.model.ownerhouse.UpdateOwnerHouse;

@org.apache.ibatis.annotations.Mapper
public interface OwnerHouseMapper extends Mapper<OwnerHouse> {

    Integer addOwnerHouse(AddOwnerHouse addOwnerHouse);

    void updateOwnerHouse(UpdateOwnerHouse updateOwnerHouse);
}