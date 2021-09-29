package com.chenyu.test01.controller;


import com.chenyu.test01.entity.UserEntity;
import com.chenyu.test01.entity.UserParam;
import com.chenyu.test01.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: learnSpringSecurity
 * @description: test
 * @author: chen yu
 * @create: 2021-09-28 22:10
 */

@Slf4j
@RestController
public class TestController01 {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public String register(@RequestBody UserParam userParam){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userParam.getUserName());
        userEntity.setPassword(passwordEncoder.encode(userParam.getPassword()));
        userService.registerService(userEntity);
        return "register success";
    }



    @PostMapping("/login")
    public  String  login(@RequestBody UserParam userParam){
       log.info("开始进行登录");
       log.info("登录用户的账号：{}，密码：{}", userParam.getUserName(),userParam.getPassword());
       //生成一个包含账号密码的认证信息
        Authentication token = new UsernamePasswordAuthenticationToken(userParam.getUserName(),userParam.getPassword());
        // AuthenticationManager校验这个认证信息，返回一个已认证的Authenticated 校验完成后要进行存储
        Authentication authenticated = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authenticated);
        return  "login success";

    }
}