package com.chaosgreat.security.distributed.uaa.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @email 1170714974@qq.com
 * @author: Chaos
 * @date : 2020/7/12
 * @time: 21:28
 */
@Service
public class SpringDataUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        System.out.println("username="+s);
        UserDetails userDetails = User.withUsername("zhangsan").password("123").authorities("p1").build();

        return userDetails;
    }
}
