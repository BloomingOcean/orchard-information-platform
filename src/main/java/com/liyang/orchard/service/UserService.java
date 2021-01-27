package com.liyang.orchard.service;
import com.liyang.orchard.model.User;
import com.liyang.orchard.core.Service;


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
}
