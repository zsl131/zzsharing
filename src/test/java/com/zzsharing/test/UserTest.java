package com.zzsharing.test;

import com.zzsharing.model.User;
import com.zzsharing.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 钟述林 393156105@qq.com on 2016/11/29 13:49.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("zsl")
public class UserTest {

    @Autowired
    private IUserService userService;

    @Test
    public void test() {
        for(Integer i=0; i<50; i++) {
            User u = new User();
            u.setUsername("user"+(i+1));
            u.setPassword("password"+(i+1));
            userService.save(u);
        }
    }
}
