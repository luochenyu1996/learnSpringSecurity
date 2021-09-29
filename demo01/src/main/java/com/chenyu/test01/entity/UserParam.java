package com.chenyu.test01.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: learnSpringSecurity
 * @description:
 * @author: chen yu
 * @create: 2021-09-29 08:44
 */
@Data
public class UserParam {
    @JsonProperty(value = "username")
    private String userName;
    private String password;

}