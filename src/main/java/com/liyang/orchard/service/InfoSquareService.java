package com.liyang.orchard.service;
import com.liyang.orchard.core.Result;
import com.liyang.orchard.model.InfoSquare;
import com.liyang.orchard.core.Service;
import com.liyang.orchard.model.infosquare.*;
import com.liyang.orchard.model.infosquare.vo.MyInfoSquare;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by Liyang on 2021/01/25.
 */
public interface InfoSquareService extends Service<InfoSquare> {

    /** 查询所有字段 **/
    InfoSquare selectInfoSquareAllById(Integer infoId);

    /** 查询细节信息 **/
    DetailsInfoSquare selectDetailsInfoSquareById(Integer id);

    /** 更新信息功能 **/
    Result updateInfoSquare(UpdateInfoSquare updateInfoSquare);

    /** 发布信息功能 **/
    void insertBuyInfoSquare(BuyInfoSquare buyInfoSquare);
    void insertSupplyInfoSquare(SupplyInfoSquare supplyInfoSquare);
    void insertLabourInfoSquare(LabourInfoSquare labourInfoSquare);
    void insertLeaseInfoSquare(LeaseInfoSquare leaseInfoSquare);
    void insertTransferInfoSquare(TransferInfoSquare transferInfoSquare);

    /** 查询我发布的信息功能 **/
    List<MyInfoSquare> selectMyInfoSquareList(Integer userId);

    /** 搜索功能 **/
    List<SearchInfoSquare> searchInfoSquare(String queryText, Integer infoType);

    /** 分页查询（流式、电梯式） **/
    List<PaginationInfoSquare> selectInfoSquareByElevator();
    List<PaginationInfoSquare> selectInfoSquareByStream();
}
