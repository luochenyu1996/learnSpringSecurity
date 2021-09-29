package com.chenyu.test01.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: learnSpringSecurity
 * @description:
 * @author: chen yu
 * @create: 2021-09-28 22:35
 */
@Data
public class UserEntity {
    @JsonProperty( value = "username")
    private  String  userName ;
    private  String  password;
}