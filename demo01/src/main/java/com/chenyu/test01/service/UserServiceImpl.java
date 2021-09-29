package com.chenyu.test01.service;
import com.chenyu.test01.entity.LoginUser;
import com.chenyu.test01.entity.UserEntity;
import com.chenyu.test01.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;

/**
 * @program: learnSpringSecurity
 * @description: springSecurity 用户验证处理
 * @author: chen yu
 * @create: 2021-09-29 09:10
 */

@Slf4j
@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("查询的名字是："+username);
        UserEntity user = userMapper.selectUserByUserName(username);
        log.info("数据库中查询的用户信息，用户名：{},用户密码:{}",user.getUserName(),user.getPassword());
        // 走到这代表查询到了实体对象，那就返回我们自定义的LoginUser对象（这里权限暂时放个空集合）
        return new LoginUser(user, Collections.emptyList());
    }
}
