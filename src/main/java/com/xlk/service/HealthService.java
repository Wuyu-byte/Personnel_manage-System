package com.xlk.service;

import com.xlk.common.vo.DeptQuery;
import com.xlk.common.vo.HealthQuery;
import com.xlk.pojo.Health;

import java.util.List;

/**
 * @author zhaochangxin
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/12 14:21
 */
public interface HealthService {
    List<Health> getHealthList(HealthQuery param);

    Long countHealthList(HealthQuery param);

    void deleteHealthById(String ids);

    Health queryById(Integer id);

    void updateHealth(Health health);

    void addHealth(Health health);

}
