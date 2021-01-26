package com.liyang.orchard.service.impl;

import com.liyang.orchard.dao.UserMapper;
import com.liyang.orchard.model.User;
import com.liyang.orchard.service.UserService;
import com.liyang.orchard.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Liyang on 2021/01/25.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

}
