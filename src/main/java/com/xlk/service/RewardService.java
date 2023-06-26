package com.xlk.service;

import com.xlk.common.vo.RewardQuery;
import com.xlk.pojo.Reward;

import java.util.List;

public interface RewardService {
    List<Reward> getRewardList(RewardQuery param);

    Long countRewardList(RewardQuery param);

    void addReward(Reward reward);

    Reward queryById(Integer id);

    void updateReward(Reward reward);

    void deleteRewardById(String ids);

}
