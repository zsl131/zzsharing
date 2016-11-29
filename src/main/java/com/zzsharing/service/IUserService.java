package com.zzsharing.service;

import com.zzsharing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by 钟述林 393156105@qq.com on 2016/11/29 13:50.
 */
public interface IUserService extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
}
