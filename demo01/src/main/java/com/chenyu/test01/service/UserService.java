package com.chenyu.test01.service;

import com.chenyu.test01.entity.UserEntity;
import com.chenyu.test01.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

/**
 * @program: learnSpringSecurity
 * @description:
 * @author: chen yu
 * @create: 2021-09-29 12:21
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public void  registerService(UserEntity userEntity){
        System.out.println("进入到service");
        userMapper.insertUser(userEntity.getUserName(),userEntity.getPassword());
    }
}