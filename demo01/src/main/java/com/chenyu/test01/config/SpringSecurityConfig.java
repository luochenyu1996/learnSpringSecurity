package com.chenyu.test01.config;

import com.chenyu.test01.handler.AuthenticationEntryPointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsUtils;

/**
 * @program: learnSpringSecurity
 * @description:  SpringSecurity的配置文件
 * @author: chen yu
 * @create: 2021-09-28 22:15
 */

@EnableWebSecurity
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationEntryPointImpl authenticationEntryPointImpl;

    @Override
    protected void  configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); //关闭 csrf
        http.headers().frameOptions().disable();
        http.cors();// 开启跨域以便前端调用接口
        // 这是配置的关键，决定哪些接口开启防护，哪些接口绕过防护
        http.authorizeRequests()
                // 注意这里，是允许前端跨域联调的一个必要配置
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                // 指定某些接口不需要通过验证即可访问。登陆、注册接口肯定是不需要认证的
                .antMatchers("/login", "/register").permitAll()
                // 这里意思是其它所有接口需要认证才能访问
                .anyRequest().authenticated()
                // 指定认证错误处理器
                .and().exceptionHandling().authenticationEntryPoint(authenticationEntryPointImpl);
    }
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        // 这里我们使用bcrypt加密算法，安全性比较高
        return new BCryptPasswordEncoder();
    }

}