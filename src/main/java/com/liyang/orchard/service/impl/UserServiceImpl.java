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

    /***
     * 通过手机号查找账户
     * @param phone 电话
     * @return 查找到的用户
     */
    public User findByPhone(String phone) {
        return userMapper.findByPhone(phone);
    }

}
