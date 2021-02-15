package com.liyang.orchard;


import com.liyang.orchard.Application;
import com.liyang.orchard.core.ResultGenerator;
import com.liyang.orchard.model.BrowseRecords;
import com.liyang.orchard.model.User;
import com.liyang.orchard.model.pojo.LoginUser;
import com.liyang.orchard.service.BrowseRecordsService;
import com.liyang.orchard.service.UserService;
import com.liyang.orchard.utils.TokenUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 单元测试继承该类即可
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
@Rollback
public abstract class Tester {


}



