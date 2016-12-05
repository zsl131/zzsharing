package com.zzsharing;

import com.zzsharing.basic.model.User;
import com.zzsharing.basic.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zsl-pc on 2016/12/5.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("zsl")
public class InitTest {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    public void test() {
        User user = new User();
        user.setUsername("zsl");
        user.setPassword("123");
        user.setNickname("钟述林");

        userServiceImpl.initBaseUser(user);
    }
}
