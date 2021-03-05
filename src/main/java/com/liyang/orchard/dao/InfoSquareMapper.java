package com.liyang.orchard.dao;

import com.liyang.orchard.core.Mapper;
import com.liyang.orchard.model.InfoSquare;
import com.liyang.orchard.model.infosquare.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface InfoSquareMapper extends Mapper<InfoSquare> {

    InfoSquare getInfoById(@Param("infoId") Integer infoId);

    Integer insertBuyInfoSquare(@Param("BIS") BuyInfoSquare buyInfoSquare,
                                @Param("name") String name);

    Integer insertSupplyInfoSquare(@Param("SIS")SupplyInfoSquare supplyInfoSquare,
                                   @Param("name") String name);

    Integer insertLabourInfoSquare(@Param("LaIS")LabourInfoSquare labourInfoSquare,
                                   @Param("name") String name);

    Integer insertLeaseInfoSquare(@Param("LeIS")LeaseInfoSquare leaseInfoSquare,
                                  @Param("name") String name);

    Integer insertTransferInfoSquare(@Param("TIS")TransferInfoSquare transferInfoSquare,@Param("name") String name);

    List<PaginationInfoSquare> selectMyInfoSquareList(@Param("userId") Integer userId);

    InfoSquare selectInfoSquareAllById(@Param("infoId") Integer infoId);

    void updateInfoSquare(@Param("UIQ")UpdateInfoSquare updateInfoSquare,
                          @Param("name") String name);

    List<SearchInfoSquare> searchInfoSquareByPiece(@Param("queryText") String queryText);

    List<SearchInfoSquare> searchInfoSquareByType(@Param("queryText") String queryText,
                                                  @Param("infoType") Integer infoType);

    List<SearchInfoSquare> searchAllInfoSquareByType(@Param("infoType") Integer infoType);

    List<SearchInfoSquare> searchAllInfoSquare();
}