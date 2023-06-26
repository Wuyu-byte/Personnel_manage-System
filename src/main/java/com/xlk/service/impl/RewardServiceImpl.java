package com.xlk.service.impl;

import com.xlk.common.vo.RewardQuery;
import com.xlk.mapper.RewardMapper;
import com.xlk.pojo.Reward;
import com.xlk.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class RewardServiceImpl implements RewardService {
    @Autowired
    private RewardMapper rewardMapper;
    @Override
    public List<Reward> getRewardList(RewardQuery param) {
        return rewardMapper.getRewardList(param);
    }

    @Override
    public Long countRewardList(RewardQuery param) {
        return rewardMapper.countRewardList(param);
    }

    @Override
    public void addReward(Reward reward) {
        rewardMapper.addReward(reward);
    }

    @Override
    public Reward queryById(Integer id) {
        return rewardMapper.queryById(id);
    }

    @Override
    public void updateReward(Reward reward) {
        rewardMapper.updateReward(reward);
    }

    @Override
    public void deleteRewardById(String ids) {
        rewardMapper.deleteRewardById(ids);
    }

}
