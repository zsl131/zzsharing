package com.zzsharing.test;

import com.zzsharing.model.BaseEntity;
import com.zzsharing.model.Teacher;
import com.zzsharing.model.User;
import com.zzsharing.service.IBaseService;
import com.zzsharing.service.ITeacherService;
import org.hibernate.criterion.*;
import org.hibernate.jpa.criteria.OrderImpl;
import org.hibernate.jpa.criteria.ParameterRegistry;
import org.hibernate.jpa.criteria.expression.SelectionImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by 钟述林 393156105@qq.com on 2016/11/28 21:27.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("zsl")
public class MyTest {

    @Autowired
    private ITeacherService teacherService;

//    @Autowired
//    private IBaseService baseService;

    @Test
    public void testAdd() {
        for(int i=0; i<50; i++) {
            Teacher t = new Teacher();
            t.setName("tea"+i);
            teacherService.save(t);
        }
    }

    @Test
    public void test01() {
        List<Teacher> list = teacherService.findAll(new Specification<Teacher>() {
            @Override
            public Predicate toPredicate(Root<Teacher> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
//                System.out.println(root.get("name").);
//                return null;
//                root.alias("user");
//                root.as(User.class);
                CriteriaQuery q = builder.createQuery(User.class);
                Root<User> r = q.from(User.class);

                System.out.println("===ddd=="+root.getAlias());
                Predicate pre = builder.like(r.get("username"), "user%");
                Predicate pre2 = builder.equal(r.get("id"), "4");
//                return query.where(pre, pre2).groupBy(root.get("id"), root.get("name")).getRestriction();
                return q.where(pre, pre2).groupBy(r.get("id"), r.get("username")).getRestriction();
//                Expression count = builder.count(root);
//                return builder.createQuery(Long.class).select(count).getRestriction();
//                return query.select(count).getRestriction();
//                return null;
            }
        });

        for(Teacher t : list) {
            System.out.println(t.getName());
        }
        System.out.println("++++++++++++++"+list.size());
    }

    @Test
    public void test3() {
       /* List list = baseService.findAll(new Specification<Teacher>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder builder) {
                root.as(Teacher.class);
                Predicate pre = builder.like(root.get("name"), "tea%");
                Predicate pre2 = builder.equal(root.get("id"), "4");
                return query.where(pre).groupBy(root.get("id")).getRestriction();
            }
        });

        System.out.println("+++++++++="+list.size());*/
    }

    @Test
    public void test2() {
        List<Teacher> list = teacherService.findAllByName("tea2", new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                System.out.println("=-=-=-=="+query.getParameters().size());
                return null;
            }
        });

        System.out.println("==="+list.size());
    }
}
