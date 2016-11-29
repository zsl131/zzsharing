package com.zzsharing.service;

import com.zzsharing.model.Teacher;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by 钟述林 393156105@qq.com on 2016/11/28 21:31.
 */
public interface ITeacherService extends JpaRepository<Teacher, Integer>, JpaSpecificationExecutor<Teacher> {

    List<Teacher> findAllByName(String name, Specification spe);
}
