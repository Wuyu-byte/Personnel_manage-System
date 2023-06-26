package com.xlk.service.impl;

import com.xlk.common.vo.HealthQuery;
import com.xlk.mapper.HealthMapper;
import com.xlk.pojo.Health;
import com.xlk.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaochangxin
 * @Title: HealthServiceImpl
 * @Package com.xlk.service.impl
 * @Description: HealthServiceImpl
 * @date 2022/4/12 14:23
 */
@Service
public class HealthServiceImpl implements HealthService {
    @Autowired
    HealthMapper healthMapper;
    @Override
    public List<Health> getHealthList(HealthQuery param) {
        return healthMapper.getHealthList(param);
    }

    @Override
    public Long countHealthList(HealthQuery param) {
        return healthMapper.countHealthList(param);
    }

    @Override
    public void deleteHealthById(String ids) {
        healthMapper.deleteHealthById(ids);
    }

    @Override
    public Health queryById(Integer id) {
        return healthMapper.queryById(id);
    }

    @Override
    public void updateHealth(Health health) {
        healthMapper.updateHealth(health);
    }

    @Override
    public void addHealth(Health health) {
        healthMapper.addHealth(health);

    }
}
