package com.chenyu.test01.entity;


import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @program: learnSpringSecurity
 * @description: springSecurity使用
 * @author: chen yu
 * @create: 2021-09-28 22:59
 */
public class LoginUser extends User {
    /**
     * 我们自己的用户实体对象，要调取用户信息时直接获取这个实体对象。（这里我就不写get/set方法了）
     */
    private UserEntity userEntity;

    public LoginUser(UserEntity userEntity, Collection<? extends GrantedAuthority> authorities) {
        super(userEntity.getUserName(), userEntity.getPassword(), authorities);
        this.userEntity = userEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
