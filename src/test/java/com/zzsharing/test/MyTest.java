package com.zzsharing.test;

import com.zzsharing.model.Teacher;
import com.zzsharing.service.ITeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 钟述林 393156105@qq.com on 2016/11/28 21:27.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("zsl")
public class MyTest {

    @Autowired
    private ITeacherService teacherService;

    @Test
    public void testAdd() {
        for(int i=0; i<50; i++) {
            Teacher t = new Teacher();
            t.setName("tea"+i);
            teacherService.save(t);
        }
    }
}
