package com.liyang.orchard.service;
import com.liyang.orchard.core.Result;
import com.liyang.orchard.model.InfoSquare;
import com.liyang.orchard.core.Service;
import com.liyang.orchard.model.infosquare.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by Liyang on 2021/01/25.
 */
public interface InfoSquareService extends Service<InfoSquare> {

    DetailsInfoSquare selectDetailsInfoSquareById(Integer id);

    void insertBuyInfoSquare(BuyInfoSquare buyInfoSquare);

    void insertSupplyInfoSquare(SupplyInfoSquare supplyInfoSquare);

    void insertLabourInfoSquare(LabourInfoSquare labourInfoSquare);

    void insertLeaseInfoSquare(LeaseInfoSquare leaseInfoSquare);

    void insertTransferInfoSquare(TransferInfoSquare transferInfoSquare);

    List<PaginationInfoSquare> selectMyInfoSquareList(Integer userId);

    InfoSquare getInfoById(Integer infoId);

    Result updateInfoSquare(InfoSquare infoSquare);
}
