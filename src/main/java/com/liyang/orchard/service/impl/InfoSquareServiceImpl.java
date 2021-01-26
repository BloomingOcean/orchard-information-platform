package com.liyang.orchard.service.impl;

import com.liyang.orchard.dao.InfoSquareMapper;
import com.liyang.orchard.model.InfoSquare;
import com.liyang.orchard.service.InfoSquareService;
import com.liyang.orchard.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Liyang on 2021/01/25.
 */
@Service
@Transactional
public class InfoSquareServiceImpl extends AbstractService<InfoSquare> implements InfoSquareService {
    @Resource
    private InfoSquareMapper infoSquareMapper;

}
