package com.xlk.mapper;

import com.xlk.common.vo.RewardQuery;
import com.xlk.pojo.Reward;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RewardMapper {
    List<Reward> getRewardList(RewardQuery param);

    Long countRewardList(RewardQuery param);

    void addReward(Reward reward);

    Reward queryById(Integer id);

    void updateReward(Reward reward);

    void deleteRewardById(String ids);

}
