package com.xlk.mapper;

import com.xlk.common.vo.HealthQuery;
import com.xlk.pojo.Health;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhaochangxin
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/12 14:26
 */
@Mapper
@Repository
public interface HealthMapper {
    List<Health> getHealthList(HealthQuery param);

    Long countHealthList(HealthQuery param);

    void deleteHealthById(String ids);

    Health queryById(Integer id);

    void updateHealth(Health health);

    void addHealth(Health health);

}
