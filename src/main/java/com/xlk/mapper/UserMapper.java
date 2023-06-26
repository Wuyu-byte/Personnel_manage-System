package com.xlk.mapper;

import com.xlk.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    User Login(User user);
    void UpdatePassword(User user);
}
