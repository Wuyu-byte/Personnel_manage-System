package com.xlk.mapper;

import com.xlk.common.vo.LevelQuery;
import com.xlk.common.vo.Page;
import com.xlk.pojo.Level;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface LevelMapper {
    List<Level> queryAll();

    Level queryById(String level_id);

    List<Level> getLevelList(LevelQuery param);

    Long countLevelList(LevelQuery param);

    void addLevel(Level level);

    void deleteLevelById(String ids);

    void updateLevel(Level level);

    List<Level> queryLevelByDept(String department_name);

}
