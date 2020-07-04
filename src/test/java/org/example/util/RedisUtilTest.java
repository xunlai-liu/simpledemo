package org.example.util;

import org.example.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xunlailiu
 * @date 2020/06/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={App.class})
public class RedisUtilTest {

    @Autowired
    RedisUtil redisUtil;

    @Test
    public void test(){
        double d = .1;
        System.out.println(redisUtil.get("hello"));
    }
}
