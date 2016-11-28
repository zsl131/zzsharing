package com.zzsharing.service;

import com.zzsharing.model.BaseEntity;
import com.zzsharing.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by 钟述林 393156105@qq.com on 2016/11/28 21:33.
 */
public interface IBaseService extends JpaRepository<BaseEntity, Integer>, JpaSpecificationExecutor<BaseEntity> {

}
