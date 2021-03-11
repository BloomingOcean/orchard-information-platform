package com.liyang.orchard.service.impl;

import com.liyang.orchard.config.shiro.SysUser;
import com.liyang.orchard.dao.UserMapper;
import com.liyang.orchard.model.User;
import com.liyang.orchard.model.user.DetailUser;
import com.liyang.orchard.model.user.SimpleUser;
import com.liyang.orchard.model.user.UpdateUser;
import com.liyang.orchard.service.UserService;
import com.liyang.orchard.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


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

    @Override
    public SimpleUser getSimpleUserInfo(Integer userId) {
        return userMapper.getSimpleUserInfo(userId);
    }

    @Override
    public DetailUser getDetailUserInfo(Integer userId) {
        return userMapper.getDetailUserInfo(userId);
    }

    @Override
    public void setUserInfo(UpdateUser updateUser) {
        userMapper.setUserInfo(updateUser);
    }

    @Override
    public List<SysUser> findUserAuthority(String phone) {
        return userMapper.findUserAuthority(phone);
    }


}
