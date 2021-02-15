package com.liyang.orchard;

import com.liyang.orchard.core.ResultGenerator;
import com.liyang.orchard.model.User;
import com.liyang.orchard.model.pojo.LoginUser;
import com.liyang.orchard.service.UserService;
import com.liyang.orchard.utils.TokenUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TokenTest extends Tester{

    @Autowired
    private UserService userService;

    @Test
    public void testToken(){
        String phone = "15317650881";
        User user = userService.findByPhone(phone);
        // 生成一个token
        String token = TokenUtil.getToken(user.getUserId(), user.getName());
        // 生成一个LoginUser
        LoginUser loginUser = new LoginUser();
//        System.out.println("user.getUserId():" + user);
        loginUser.setUserId(user.getUserId());
        loginUser.setUserPhone(phone);
        loginUser.setUserNikename(user.getNikename());
        loginUser.setUserToken(token);
        System.out.println(ResultGenerator.genSuccessResult(loginUser));
    }

}
