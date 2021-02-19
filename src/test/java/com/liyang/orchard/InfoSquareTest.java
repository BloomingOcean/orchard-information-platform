package com.liyang.orchard;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyang.orchard.dao.InfoSquareMapper;
import com.liyang.orchard.dao.UserMapper;
import com.liyang.orchard.model.ImgList;
import com.liyang.orchard.model.InfoSquare;
import com.liyang.orchard.model.infosquare.BuyInfoSquare;
import com.liyang.orchard.model.infosquare.PaginationInfoSquare;
import com.liyang.orchard.service.ImgListService;
import com.liyang.orchard.service.InfoSquareService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InfoSquareTest extends Tester{

    @Resource
    private InfoSquareMapper infoSquareMapper;

    @Resource
    private InfoSquareService infoSquareService;

    @Resource
    private ImgListService imgListService;

    @Resource
    private UserMapper userMapper;

    @Test
    public void test(){
        System.out.println(infoSquareService.selectMyInfoSquareList(1));
//        System.out.println(infoSquareService.selectInfoSquareById(1));
    }

    @Test
    public void test1(){
    }

}
