package com.liyang.orchard.service.impl;

import com.liyang.orchard.dao.OwnerHouseMapper;
import com.liyang.orchard.model.OwnerHouse;
import com.liyang.orchard.service.OwnerHouseService;
import com.liyang.orchard.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Liyang on 2021/01/25.
 */
@Service
@Transactional
public class OwnerHouseServiceImpl extends AbstractService<OwnerHouse> implements OwnerHouseService {
    @Resource
    private OwnerHouseMapper ownerHouseMapper;

}
