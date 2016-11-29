package com.zzsharing.test;

import com.zzsharing.model.Teacher;
import com.zzsharing.service.ITeacherService;
import com.zzsharing.specification.BottomSpecification;
import com.zzsharing.specification.ConDto;
import com.zzsharing.specification.Condition;
import com.zzsharing.specification.SpecificationUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by 钟述林 393156105@qq.com on 2016/11/29 9:17.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("zsl")
public class BottomTest {

    @Autowired
    private ITeacherService teacherService;

    @Test
    public void test() {
        BottomSpecification bs = new BottomSpecification(Condition.one("id", "eq", 3), Condition.one("id", "eq", "5", "or"));
        List<Teacher> list = teacherService.findAll(bs);
        System.out.println("====================="+list.size());
    }

    @Test
    public void test2() {
        Specification spes = SpecificationUtil.buildSpe(new ConDto("and", Condition.one("id", "eq", 3), Condition.one("id", "eq", "5", "or")),
                                                        new ConDto("and", Condition.one("id", "gt", 4), Condition.one("id", "le", 3, "and")));
        List<Teacher> list = teacherService.findAll(spes);
        System.out.println("==============="+list.size());
    }
}
