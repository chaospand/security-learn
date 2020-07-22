package com.chaosgreat.security.distributed.uaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @email 1170714974@qq.com
 * @author: Chaos
 * @date : 2020/7/11
 * @time: 22:56
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public AuthenticationManager authenticationManagerBean()throws Exception{
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){return NoOpPasswordEncoder.getInstance();}
    //new BCryptPasswordEncoder();
    //安全拦截机制（最重要）
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/r/r1").hasAnyAuthority("p1") //所有/r/**的请求必须认证通过
                .antMatchers("/login*").permitAll() // 除了上面拦截的，其他的都开放
                .anyRequest().authenticated()
                .and()
                .formLogin(); //允许表单登录
    }


//    //安全拦截机制（最重要）
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/r/**").authenticated() //所有/r/**的请求必须认证通过
//                .anyRequest().permitAll() // 除了上面拦截的，其他的都开放
//                .and()
//                .formLogin() //允许表单登录
//                .loginPage("/login-view")
//                .loginProcessingUrl("/login")
//                .successForwardUrl("/login-success")
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login-view?logout");
//    }



}
