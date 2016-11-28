package com.zzsharing.test;

import com.zzsharing.model.Teacher;
import com.zzsharing.service.IBaseService;
import com.zzsharing.service.ITeacherService;
import com.zzsharing.tools.SpecificationKit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by 钟述林 393156105@qq.com on 2016/11/28 21:39.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("zsl")
public class BaseTest {

    @Autowired
    private ITeacherService teacherService;

    @Test
    public void testFind() {

//        Specifications.where().or().or().and()

//        Specifications spe1 = Specifications.where().or(); // name=tea or aa = bb
//        Specifications spe2 = Specifications.where().or().or(); // a = b or c =d
//        Specifications spe = Specifications.where(spe1).and(spe2);

        Specification spe1 = Specifications.where(SpecificationKit.buildSpe("id","eq", "1")).or(SpecificationKit.buildSpe("id", "eq", "3"));
        Specification spe2 = Specifications.where(SpecificationKit.buildSpe("name", "like", "tea%")).or(SpecificationKit.buildSpe("id","eq", "1"));

        Specification spe = Specifications.where(spe1).and(spe2);

//        List list = teacherService.findAll(Specifications.where(SpecificationKit.buildSpe("id", "eq", "1")).or(SpecificationKit.buildSpe("id", "eq", "3")).and(SpecificationKit.buildSpe("name", "like", "tea%")).or(SpecificationKit.buildSpe("id", "eq", "1")));

        List list = teacherService.findAll(spe);
        System.out.println(list.size());
    }
}
