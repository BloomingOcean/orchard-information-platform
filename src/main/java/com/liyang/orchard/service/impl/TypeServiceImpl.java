package com.liyang.orchard.service.impl;

import com.liyang.orchard.dao.TypeMapper;
import com.liyang.orchard.model.Type;
import com.liyang.orchard.service.TypeService;
import com.liyang.orchard.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Liyang on 2021/01/25.
 */
@Service
@Transactional
public class TypeServiceImpl extends AbstractService<Type> implements TypeService {
    @Resource
    private TypeMapper typeMapper;

}
