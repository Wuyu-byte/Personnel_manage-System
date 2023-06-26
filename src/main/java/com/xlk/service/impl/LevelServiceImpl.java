package com.xlk.service.impl;

import com.xlk.common.vo.LevelQuery;
import com.xlk.common.vo.Page;
import com.xlk.mapper.LevelMapper;
import com.xlk.pojo.Level;
import com.xlk.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LevelServiceImpl implements LevelService {
    @Autowired
    LevelMapper levelMapper;
    @Override
    public List<Level> queryAll() {
        return levelMapper.queryAll();
    }

    @Override
    public Level queryById(String level_id) {
        return levelMapper.queryById(level_id);
    }

    @Override
    public List<Level> getLevelList(LevelQuery param) {
        return levelMapper.getLevelList(param);
    }

    @Override
    public Long countLevelList(LevelQuery param) {
        return levelMapper.countLevelList(param);
    }

    @Override
    public void addLevel(Level level) {
        levelMapper.addLevel(level);
    }

    @Override
    public void deleteLevelById(String ids) {
        levelMapper.deleteLevelById(ids);
    }

    @Override
    public void updateLevel(Level level) {
        levelMapper.updateLevel(level);
    }

    @Override
    public List<Level> queryLevelByDept(String department_name) {
        return levelMapper.queryLevelByDept(department_name);
    }
}
