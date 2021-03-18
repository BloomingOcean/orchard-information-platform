package com.liyang.orchard.service;
import com.liyang.orchard.model.OwnerHouse;
import com.liyang.orchard.core.Service;
import com.liyang.orchard.model.ownerhouse.AddOwnerHouse;
import com.liyang.orchard.model.ownerhouse.PaginationOwnerHouse;
import com.liyang.orchard.model.ownerhouse.UpdateOwnerHouse;

import java.util.List;


/**
 * Created by Liyang on 2021/01/30.
 */
public interface OwnerHouseService extends Service<OwnerHouse> {

    void addOwnerHouse(AddOwnerHouse addOwnerHouse);

    void updateOwnerHouse(UpdateOwnerHouse updateOwnerHouse);

    List<PaginationOwnerHouse> selectOwnerHouseByElevator();

    List<PaginationOwnerHouse> selectOwnerHouseByStream();
}
