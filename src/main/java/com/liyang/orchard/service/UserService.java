package com.liyang.orchard.service;
import com.liyang.orchard.config.shiro.SysUser;
import com.liyang.orchard.model.User;
import com.liyang.orchard.core.Service;
import com.liyang.orchard.model.user.DetailUser;
import com.liyang.orchard.model.user.SimpleUser;
import com.liyang.orchard.model.user.UpdateUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by Liyang on 2021/01/25.
 */
public interface UserService extends Service<User> {

    /***
     * 通过手机号查找账户
     * @param phone 电话
     * @return 查找到的用户
     */
    User findByPhone(String phone);

    SimpleUser getSimpleUserInfo(Integer userId);

    DetailUser getDetailUserInfo(Integer userId);

    void setUserInfo(UpdateUser updateUser);

    List<SysUser> findUserAuthority(String phone);
}
