package com.example.shixun.mapper;

import com.example.shixun.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    User login(String name);

}