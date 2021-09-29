package com.chenyu.test01.mapper;

import com.chenyu.test01.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @program: learnSpringSecurity
 * @description: 查询注册用户
 * @author: chen yu
 * @create: 2021-09-29 09:12
 */
@Mapper
public interface UserMapper {
    public  void  insertUser(String userName,String password);
    public UserEntity selectUserByUserName(String userName);



}