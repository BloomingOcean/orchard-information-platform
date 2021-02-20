package com.liyang.orchard.service;
import com.liyang.orchard.model.ImgList;
import com.liyang.orchard.core.Service;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by Liyang on 2021/02/17.
 */
public interface ImgListService extends Service<ImgList> {

    List<ImgList> selectByInfoSquareId(Integer infoSquareId);

    List<ImgList> selectByOwnerHouseId(Integer ownerHouseId);

    void deleteByInfoSquareId(Integer infoSquareId);

    void deleteByOwnerHouseId(Integer ownerHouseId);

}
