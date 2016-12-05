package com.zzsharing.basic.service;

import com.zzsharing.basic.model.AppConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

/**
 * Created by zsl-pc on 2016/9/7.
 */
@Service("appConfigService")
public interface IAppConfigService extends JpaRepository<AppConfig, Integer> {

    @Query("FROM AppConfig ")
    public AppConfig loadOne();
}
