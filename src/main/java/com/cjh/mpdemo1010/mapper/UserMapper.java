package com.cjh.mpdemo1010.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cjh.mpdemo1010.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {

}